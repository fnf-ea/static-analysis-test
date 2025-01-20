package com.fnfcorp.sms.rfid.domain.info;

import com.fnfcorp.sms.rfid.domain.constant.RfidStatus;
import com.fnfcorp.sms.rfid.domain.entity.Rfid;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author : yun
 * @Summary :  Rfid Info 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun        최초 생성
 * </pre>
 */
@Builder
@Getter
@Slf4j
public class RfidInfo {
    private long rfidId;
    private String rfidCode;
    private long scsId;
    private String locationCode;
    private String statusCode;

    public static RfidInfo of(Rfid rfid) {
        return RfidInfo.builder()
                .rfidId(rfid.getId())
                .rfidCode(rfid.getCode())
                .scsId(rfid.getScsId())
                .locationCode(rfid.getLocationCode())
                .statusCode(rfid.getStatusCode())
                .build();
    }

    /**
     * 판매가능상태 체크 RfidStatusEnum.SALE_READY
     * @return boolean
     */
    public boolean isAvailableStatusForSale() {
        if(this.rfidCode == null || this.rfidCode.isEmpty()) {
            return false;
        }

        if(this.getStatusCode().equals(RfidStatus.SALE_READY.getCode())) {
            return true;
        }
        return false;
    }

    /**
     * 판매 가능한 위치인지 체크
     */
    public boolean isAvailableLocationForSale(String locationCode) {
        return this.getLocationCode().equals(locationCode);
    }
}
