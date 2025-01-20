package com.fnfcorp.sms.member.domain.info;

import com.fnfcorp.sms.member.domain.entity.MemberMileage;
import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary :
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/28          yun       최초 생성
 * </pre>
 */
@Getter
@Builder
public class MemberMileageInfo {
    private Long id;
    private Long memberId;
    private Long getMileage;
    private Long useMileage;

    public static MemberMileageInfo of(MemberMileage memberMileage){
        return MemberMileageInfo.builder()
                .id(memberMileage.getId())
                .memberId(memberMileage.getMemberId())
                .getMileage(memberMileage.getGetMileage())
                .useMileage(memberMileage.getUseMileage())
                .build();
    }
}
