package com.fnfcorp.sms.rfid.domain.constant;

import lombok.Getter;

/**
 * @Author : yun
 * @Summary :Rfid 상태 Enum
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Getter
public enum RfidStatus {
    SALE_READY("35", "판매 대기중"),
    SALE_FINISH("40", "판매 완료");
    private final String code;
    private final String name;

    RfidStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
