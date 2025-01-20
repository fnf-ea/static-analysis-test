package com.fnfcorp.sms.member.domain.command;

import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

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
@Builder(builderClassName = "Builder")
public class ModifyMemberMileageCommand {
    @NotEmpty(message = "memberId는 필수 입니다.")
    private final Long memberId;
    @NotEmpty(message = "판매가격은 필수 입니다.")
    private final Long actualPrice;
    private final Long useMileage;
    public Long getUseMileage() {
        if(useMileage == null) {
            return 0L;
        }
        return useMileage;
    }
}
