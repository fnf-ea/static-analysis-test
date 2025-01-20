package com.fnfcorp.sms.rfid.domain;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.sms.rfid.domain.command.ConfirmRfidStatusForSaleCommand;
import com.fnfcorp.sms.rfid.domain.entity.Rfid;
import com.fnfcorp.sms.rfid.domain.info.RfidInfo;
import com.fnfcorp.sms.rfid.domain.query.GetRfidQuery;
import com.fnfcorp.sms.rfid.domain.query.ValidateRfidForSaleQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;

/**
 * @Author : yun
 * @Summary : Rfid Service 구현체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Slf4j
@Service("RfidServiceImpl")
@RequiredArgsConstructor
public class RfidServiceImpl implements RfidService {

    @Qualifier("RfidReaderImpl")
    private final RfidReader rfidReader;

    @Qualifier("RfidStoreImpl")
    private final RfidStore rfidStore;

    @Override
    public RfidInfo getRfid(GetRfidQuery query) {
        Rfid rfid = rfidReader.selectOneRfid(query.toEntity());
        if (rfid == null) {
            log.error(RfidErrorCode.ITEM_NOT_FOUND.getMessage());
            throw new BusinessException(RfidErrorCode.ITEM_NOT_FOUND);
        }
        return RfidInfo.of(rfid);
    }

    @Override
    public void validateRfidStateForSale(ValidateRfidForSaleQuery query) {
        if (query.getRfidInfo() == null) {
            log.error(RfidErrorCode.ITEM_NOT_FOUND.getMessage());
            throw new BusinessException(RfidErrorCode.ITEM_NOT_FOUND);
        }

        if (!query.getRfidInfo().isAvailableStatusForSale()) {
            log.error(RfidErrorCode.STATUS_NOT_FOR_SALE.getMessage());
            throw new BusinessException(RfidErrorCode.STATUS_NOT_FOR_SALE);
        }

        // FIXME 위 아래중 어떤스타일 이 나을지
        //log.error를 Exption에 추가하는건? 에러 라인이 검출일 잘될까?
        query.getRfidInfo().isAvailableLocationForSale(""+query.getShopId());
    }

    @Transactional
    @Override
    public void confirmRfidStateForSale(@Valid ConfirmRfidStatusForSaleCommand command) {
        Rfid rfid = command.toEntity();
        rfid.setConfirmStatus();
        rfidStore.updateRfidStatus(rfid);
    }
}
