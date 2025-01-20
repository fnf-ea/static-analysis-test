package com.fnfcorp.sms.sale.domain.command;

import com.fnfcorp.sms.sale.domain.entity.SaleQue;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * @Author : yun
 * @Summary : 판매 등록 Command
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */
@Getter
@Builder(builderClassName = "Builder")
public class SaveSaleQueCommand {
    @NotEmpty(message = "rfidId는 필수 입니다.")
    Long rfidId;
    @NotEmpty(message = "shopId는 필수 입니다.")
    Long shopId;
    @NotEmpty(message = "scsId는 필수 입니다.")
    Long scsId;
    @NotEmpty(message = "날짜는 필수입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "날짜는 현재 날짜 이전이어야 합니다.")
    LocalDate saleQueDate;

    public static Builder Builder(Long rfidId, Long shopId, Long scsId, LocalDate saleQueDate) {
        return builder().rfidId(rfidId).shopId(shopId).scsId(scsId).saleQueDate(saleQueDate);
    }

    public SaleQue toEntity(){
        return SaleQue.builder()
                .rfidId(this.rfidId)
                .shopId(this.shopId)
                .scsId(this.scsId)
                .saleQueDate(this.saleQueDate)
                .build();
    }

}
