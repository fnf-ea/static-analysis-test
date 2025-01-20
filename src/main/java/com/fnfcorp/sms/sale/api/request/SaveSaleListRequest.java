package com.fnfcorp.sms.sale.api.request;

import com.fnfcorp.sms.rfid.domain.validation.RfidCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * @Author : yun
 * @Summary : 판매 등록 Request
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveSaleListRequest {

    @Valid
    @NotEmpty(message = "판매등록할 항목이 없습니다.")
    private List<SaveSaleItem> items;

    @Getter
    @Setter
    public static class SaveSaleItem{
        @NotNull(message = "SaleQueID는 필수 입니다.")
        private Long saleQueId;
        @NotNull(message = "RFID ID는 필수 입니다.")
        private Long rfidId;
        @RfidCode(message = "RFID 코드 오류입니다")
        private String rfidCode;
        @NotNull(message = "shopId는 필수 입니다.")
        private Long shopId;
        @NotNull(message = "scsId는  필수 입니다.")
        private Long scsId;
        @NotNull(message = "실 판매가격은 필수입니다.")
        private Long actualPrice;
        private Long memberId;
        @PositiveOrZero
        private Long useMileage;
    }

}
