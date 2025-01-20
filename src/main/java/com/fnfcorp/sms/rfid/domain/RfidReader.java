package com.fnfcorp.sms.rfid.domain;

import com.fnfcorp.sms.rfid.domain.entity.Rfid;

/**
 * @Author : yun
 * @Summary : Rfid Reader Interface
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */
public interface RfidReader {
    Rfid selectOneRfid(Rfid rfid);
}
