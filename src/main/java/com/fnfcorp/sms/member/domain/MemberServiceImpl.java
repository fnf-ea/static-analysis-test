package com.fnfcorp.sms.member.domain;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.global.exception.CommonErrorCode;
import com.fnfcorp.sms.member.domain.command.ModifyMemberMileageCommand;
import com.fnfcorp.sms.member.domain.constant.MemberConstant;
import com.fnfcorp.sms.member.domain.entity.Member;
import com.fnfcorp.sms.member.domain.entity.MemberMileage;
import com.fnfcorp.sms.member.domain.info.MemberInfo;
import com.fnfcorp.sms.member.domain.info.MemberMileageInfo;
import com.fnfcorp.sms.member.domain.query.GetMemberQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;

/**
 * @Author : yun
 * @Summary : MemberService 구현체
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/28          yun       최초 생성
 * </pre>
 */

@Slf4j
@Service("MemberServiceImpl")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    @Qualifier("MemberReaderImpl")
    private final MemberReader memberReader;

    @Qualifier("MemberStoreImpl")
    private final MemberStore memberStore;

    @Override
    public MemberInfo getMember(GetMemberQuery query){
        Member member = memberReader.selectOneMember(query.toEntity());
        if (member == null) {
            log.error(MemberErrorCode.ITEM_NOT_FOUND.getMessage());
            throw new BusinessException(CommonErrorCode.NOT_FOUND);
        }
        return MemberInfo.of(member);
    }

    @Transactional
    @Override
    public MemberMileageInfo modifyMemberMileage(@Valid ModifyMemberMileageCommand command) {
        //1.사용마일리지 금액 확정: 마일리지 차감시에 사용마일리지가 가격보다 크면 가격만큼으로 보정
        long useMileage = command.getUseMileage();
        if (command.getActualPrice() < useMileage) {
            useMileage = command.getActualPrice();
        }

        //2. 사용마일리지가 없는 경우만 적립
        long getMileage = 0L;
        if (useMileage == 0L) {
            //기본 1% 적립
            getMileage = (long) (command.getActualPrice() * MemberConstant.MILEAGE_ACCRUAL_RATE);
        }

        //3.마일리지 정보 Update
        MemberMileage memberMileage = memberStore.updateMemberMileage(MemberMileage
                        .Builder(command.getMemberId(), getMileage, useMileage)
                        .build());

        return MemberMileageInfo.of(memberMileage);
    }
}
