package com.fnfcorp.sms.sale.domain.info;

import com.fnfcorp.sms.sale.domain.entity.SaleQue;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary : 판매 대기열 정보 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */

@Builder
@Getter
public class SaleQueInfo {
    private Long id;
    private Long rfidId;
    private Long shopId;
    private Long scsId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate saleQueDate;

    public static SaleQueInfo of(SaleQue saleQue){
        return SaleQueInfo.builder()
                .id(saleQue.getId())
                .rfidId(saleQue.getRfidId())
                .shopId(saleQue.getShopId())
                .scsId(saleQue.getScsId())
                .saleQueDate(saleQue.getSaleQueDate())
                .build();
    }
}
