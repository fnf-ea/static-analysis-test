package com.fnfcorp.sms.sale.domain.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Author           : yun
 * @Summary         : 대기열 상세 정보
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun        최초 생성
 *</pre>
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleQueDetailInfo {
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
}
