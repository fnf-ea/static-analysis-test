package com.fnfcorp.sms.sale.domain.query;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary : 판매 상세 조회 Query
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Builder(builderClassName = "Builder")
@Getter
public class GetSaleDetailListQuery {
    @NotEmpty(message = "startDate는 필수 입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotEmpty(message = "endDate는 필수 입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @NotEmpty(message = "shopId는 필수 입니다.")
    private Long shopId;

    public static Builder Builder(LocalDate startDate, LocalDate endDate, Long shopId) {
        return builder().startDate(startDate).endDate(endDate).shopId(shopId);
    }
}
