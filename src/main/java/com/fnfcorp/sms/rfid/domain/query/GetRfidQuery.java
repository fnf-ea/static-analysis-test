package com.fnfcorp.sms.rfid.domain.query;

import com.fnfcorp.sms.rfid.domain.validation.RfidCode;
import com.fnfcorp.sms.rfid.domain.entity.Rfid;
import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary :  Rfid 정보조회 요청 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun        최초 생성
 * </pre>
 */

@Getter
@Builder(builderClassName = "Builder")
public class GetRfidQuery {
    @RfidCode
    private String rfidCode;
    private Long rfidId;

    public static Builder Builder(String rfidCode) {
        return builder().rfidCode(rfidCode);
    }

    public static Builder Builder(long rfidId) {
        return builder().rfidId(rfidId);
    }

    public Rfid toEntity(){
        return Rfid.builder()
                .id(rfidId)
                .code(rfidCode)
                .build();
    }
}
