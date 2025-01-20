package com.fnfcorp.sms.rfid.infra;

import com.fnfcorp.sms.rfid.domain.RfidReader;
import com.fnfcorp.sms.rfid.domain.entity.Rfid;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author : yun
 * @Summary : Rfid 조회 Dao
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Component("RfidReaderImpl")
@RequiredArgsConstructor
public class RfidReaderImpl implements RfidReader {
    private final String MAPPER_NAMESPACE = "sms.rfid.RfidMapper";
    private final SqlSessionTemplate sqlSessionTemplate;
    @Override
    public Rfid selectOneRfid(Rfid rfid) {
        return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".selectOneRfid", rfid);
    }
}
