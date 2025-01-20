package com.fnfcorp.sms.sale.api.response;

import com.fnfcorp.sms.sale.domain.info.SaleQueInfo;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary :
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Getter
@Builder
public class SaveSaleQueResponse {
    private Long id;
    private Long rfidId;
    private Long shopId;
    private Long scsId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate saleQueDate;

    public static SaveSaleQueResponse of(SaleQueInfo info) {
        return SaveSaleQueResponse.builder()
                .id(info.getId())
                .rfidId(info.getRfidId())
                .shopId(info.getShopId())
                .scsId(info.getScsId())
                .saleQueDate(info.getSaleQueDate())
                .build();
    }
}
