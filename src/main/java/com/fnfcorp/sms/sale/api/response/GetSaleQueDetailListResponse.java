package com.fnfcorp.sms.sale.api.response;

import com.fnfcorp.sms.sale.domain.info.SaleQueDetailInfo;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

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
public class GetSaleQueDetailListResponse {
    private List<Item> items;

    @Getter
    @Builder
    public static class Item {
        private Long id;
        private Long rfidId;
        private String rfidCode;
        private Long shopId;
        private String shopCode;
        private Long scsId;
        private String styleCode;
        private String sizeCode;
        private String colorCode;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate saleQueDate;

        public static Item of(SaleQueDetailInfo info) {
            return Item.builder()
                    .id(info.getId())
                    .rfidId(info.getRfidId())
                    .rfidCode(info.getRfidCode())
                    .shopId(info.getShopId())
                    .shopCode(info.getShopCode())
                    .scsId(info.getScsId())
                    .styleCode(info.getStyleCode())
                    .sizeCode(info.getSizeCode())
                    .colorCode(info.getColorCode())
                    .saleQueDate(info.getSaleQueDate())
                    .build();
        }
    }

}
