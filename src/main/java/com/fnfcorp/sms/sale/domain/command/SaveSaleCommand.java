package com.fnfcorp.sms.sale.domain.command;

import com.fnfcorp.sms.sale.domain.entity.Sale;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary : 판매 등록 Command
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Builder(builderClassName = "Builder")
@Getter
public class SaveSaleCommand {
    @NotEmpty(message = "rfidId는 필수 입니다.")
    private Long rfidId;
    @NotEmpty(message = "saleQueId는 필수 입니다.")
    private Long scsId;
    @NotEmpty(message = "shopId는 필수 입니다.")
    private Long shopId;
    @NotEmpty
    @Min(value = 1000, message = "판매가격은 1000원 보다 커야 합니다.")
    private Long actualPrice;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate saleDate;
    private Long memberId;
    private Long useMileage;

    public static Builder Builder(Long rfidId, Long scsId, Long shopId, Long actualPrice, LocalDate saleDate) {
        return builder().rfidId(rfidId).scsId(scsId).shopId(shopId).actualPrice(actualPrice).saleDate(saleDate);
    }

    public Sale toEntity() {
        return Sale.builder()
                .rfidId(this.rfidId)
                .scsId(this.scsId)
                .shopId(this.shopId)
                .saleDate(this.saleDate)
                .memberId(this.memberId)
                .actualPrice(this.actualPrice)
                .useMileage(this.useMileage)
                .build();
    }
}
