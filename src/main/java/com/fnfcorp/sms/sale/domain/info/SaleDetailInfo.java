package com.fnfcorp.sms.sale.domain.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailInfo {
    Long id;
    Long rfidId;
    String rfidCode;
    Long shopId;
    String shopCode;
    String shopName;
    Long scsId;
    String styleCode;
    String styleName;
    String sizeCode;
    String colorCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate saleDate;
    Long actualPrice;
    String memberUuid;
    String memberName;
}
