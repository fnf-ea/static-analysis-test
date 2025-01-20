package com.fnfcorp.sms.sale.api.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary : 판매 대기열 조회 Request
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Getter
@Setter
public class GetSaleQueDetailListRequest {
    @NotNull(message = "조회 시작 날짜는 필수값입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @NotNull(message = "조회 종료 날짜는 필수값입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @NotNull(message = "shopId는 필수 입니다.")
    private Long shopId;
}
