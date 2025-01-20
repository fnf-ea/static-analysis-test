package com.fnfcorp.sms.rfid.domain.query;

import com.fnfcorp.sms.rfid.domain.info.RfidInfo;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

/**
 * @Author           : yun
 * @Summary         : Rfid 상태체크 요청 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun        최초 생성
 *</pre>
 */
@Builder(builderClassName = "Builder")
@Getter
public class ValidateRfidForSaleQuery{
    private RfidInfo rfidInfo;
    @NotEmpty(message = "shopId는 필수 입니다.")
    private Long shopId;

    public static Builder Builder(RfidInfo rfidInfo, Long shopId) {
        return builder().rfidInfo(rfidInfo).shopId(shopId);
    }

}
