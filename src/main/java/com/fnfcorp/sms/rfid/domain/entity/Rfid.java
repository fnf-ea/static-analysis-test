package com.fnfcorp.sms.rfid.domain.entity;

import com.fnfcorp.sms.rfid.domain.validation.RfidCode;
import com.fnfcorp.sms.rfid.domain.constant.RfidStatus;
import lombok.Builder;
import lombok.Getter;

/**
 * @Author           : yun
 * @Summary         :  Rfid Entity 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun        최초 생성
 *</pre>
 */
@Builder
@Getter
public class Rfid {
    private Long id;
    private String code;
    private Long scsId;
    private String locationCode;
    private String statusCode;
    public void setConfirmStatus(){
        this.statusCode = RfidStatus.SALE_FINISH.getCode();
    }
}
