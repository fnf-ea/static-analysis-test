package com.fnfcorp.sms.rfid.infra;

import com.fnfcorp.sms.rfid.domain.RfidStore;
import com.fnfcorp.sms.rfid.domain.entity.Rfid;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author : yun
 * @Summary :
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */
@Component("RfidStoreImpl")
@RequiredArgsConstructor
public class RfidStoreImpl implements RfidStore {
    private final String MAPPER_NAMESPACE = "sms.rfid.RfidMapper";
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void updateRfidStatus(Rfid rfid) {
        sqlSessionTemplate.update(MAPPER_NAMESPACE + ".updateRfidStatus", rfid);
    }
}
