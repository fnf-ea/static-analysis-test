package com.fnfcorp.sms.sale.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary : 판매 대기열 Entity
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private Long rfidId;
    private Long shopId;
    private Long scsId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate saleDate;
    private Long actualPrice;
    private Long memberId;
    private Long useMileage;
}