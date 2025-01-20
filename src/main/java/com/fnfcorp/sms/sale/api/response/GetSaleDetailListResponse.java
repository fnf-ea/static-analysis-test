package com.fnfcorp.sms.sale.api.response;

import com.fnfcorp.sms.sale.domain.info.SaleDetailInfo;
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
public class GetSaleDetailListResponse {
    private List<Item> items;

    @Getter
    @Builder
    public static class Item {
        private Long id;
        private Long rfidId;
        private String rfidCode;
        private Long shopId;
        private String shopCode;
        private String shopName;
        private Long scsId;
        private String styleCode;
        private String styleName;
        private String sizeCode;
        private String colorCode;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate saleDate;
        private String memberUuid;
        private String memberName;

        public static Item of(SaleDetailInfo info) {
            return Item.builder()
                    .id(info.getId())
                    .rfidId(info.getRfidId())
                    .rfidCode(info.getRfidCode())
                    .shopId(info.getShopId())
                    .shopCode(info.getShopCode())
                    .shopName(info.getShopName())
                    .scsId(info.getScsId())
                    .styleCode(info.getStyleCode())
                    .styleName(info.getStyleName())
                    .sizeCode(info.getSizeCode())
                    .colorCode(info.getColorCode())
                    .saleDate(info.getSaleDate())
                    .memberUuid(info.getMemberUuid())
                    .memberName(info.getMemberName())
                    .build();
        }
    }
}
