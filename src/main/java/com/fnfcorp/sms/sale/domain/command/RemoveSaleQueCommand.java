package com.fnfcorp.sms.sale.domain.command;

import com.fnfcorp.sms.sale.domain.entity.SaleQue;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

/**
 * @Author : yun
 * @Summary : 판매대기 삭제 요청 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Getter
@Builder(builderClassName = "Builder")
public class RemoveSaleQueCommand {
    @NotEmpty(message = "판매대기열 ID는 필수입니다.")
    private Long saleQueId;

    public static Builder Builder(Long saleQueId) {
        return builder().saleQueId(saleQueId);
    }

    public SaleQue toEntity() {
        return SaleQue.builder()
                .id(saleQueId)
                .build();
    }

}
