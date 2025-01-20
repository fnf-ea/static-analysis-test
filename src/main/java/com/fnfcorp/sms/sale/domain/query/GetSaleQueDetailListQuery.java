package com.fnfcorp.sms.sale.domain.query;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary : 판매 대기열 상세 조회
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */

@Builder
@Getter
public class GetSaleQueDetailListQuery {
    private Long saleQueId;
    private Long rfidId;
    private Long shopId;
    private Long scsId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
