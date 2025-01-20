package com.fnfcorp.sms.rfid.domain;

import com.fnfcorp.sms.rfid.domain.command.ConfirmRfidStatusForSaleCommand;
import com.fnfcorp.sms.rfid.domain.info.RfidInfo;
import com.fnfcorp.sms.rfid.domain.query.GetRfidQuery;
import com.fnfcorp.sms.rfid.domain.query.ValidateRfidForSaleQuery;

/**
 * packageName    : com.fnfcorp.sms.rfid.domain
 * fileName       : RfidService
 * author         : yun
 * date           : 2022/12/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/26        yun       최초 생성
 */
public interface RfidService {
    RfidInfo getRfid(GetRfidQuery query);
    void validateRfidStateForSale(ValidateRfidForSaleQuery query);
    void confirmRfidStateForSale(ConfirmRfidStatusForSaleCommand command);
}
