package com.fnfcorp.sms.member.domain;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.sms.member.domain.command.ModifyMemberMileageCommand;
import com.fnfcorp.sms.member.domain.info.MemberInfo;
import com.fnfcorp.sms.member.domain.info.MemberMileageInfo;
import com.fnfcorp.sms.member.domain.query.GetMemberQuery;

/**
 * @Author : yun
 * @Summary : MemberService
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */
public interface MemberService {
    /**
     * 유저 정보 조회
     * @param query
     * @return
     */
    MemberInfo getMember(GetMemberQuery query);
    /**
     * 마일리지 수정
     * @param command
     * @return
     * @throws BusinessException
     */
    MemberMileageInfo modifyMemberMileage(ModifyMemberMileageCommand command);
}
