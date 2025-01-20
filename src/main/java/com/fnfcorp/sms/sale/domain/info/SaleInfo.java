package com.fnfcorp.sms.sale.domain.info;

import com.fnfcorp.sms.sale.domain.entity.Sale;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * packageName    : com.fnfcorp.sms.sale.domain
 * fileName       : SaleInfo
 * author         : yun
 * date           : 2022/12/23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/23        yun       최초 생성
 */

@Builder
@Getter
public class SaleInfo {
    private Long id;
    private Long rfidId;
    private Long shopId;
    private Long scsId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate saleDate;
    public static SaleInfo of(Sale sale) {
        return SaleInfo.builder()
                .id(sale.getId())
                .rfidId(sale.getRfidId())
                .shopId(sale.getShopId())
                .scsId(sale.getScsId())
                .saleDate(sale.getSaleDate())
                .build();
    }
}
