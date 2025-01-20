package com.fnfcorp.sms.member.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
@Setter
@Builder(builderClassName = "Builder")
public class MemberMileage {
    private Long id;
    private Long memberId;
    private Long getMileage;
    private Long useMileage;
    public static Builder Builder(Long memberId,Long getMileage,Long useMileage) {
        return builder().memberId(memberId).getMileage(getMileage).useMileage(useMileage);
    }
}
