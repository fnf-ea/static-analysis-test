package com.fnfcorp.sms.sale.api.request;

import com.fnfcorp.sms.rfid.domain.validation.RfidCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * packageName    : com.fnfcorp.sms.sale.api.request
 * fileName       : SaveSaleQueReq
 * author         : yun
 * date           : 2022/12/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/26        yun       최초 생성
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaveSaleQueRequest {

    @RfidCode
    @NotEmpty(message = "RFID 값은 필수 값 입니다.")
    private String rfidCode;
    @NotNull(message = "매장을 선택해주세요!")
    private Long shopId;
}
