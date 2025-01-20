package com.fnfcorp.sms.sale.infra;

import com.fnfcorp.sms.sale.domain.SaleReader;
import com.fnfcorp.sms.sale.domain.info.SaleDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueDetailInfo;
import com.fnfcorp.sms.sale.domain.query.GetSaleDetailListQuery;
import com.fnfcorp.sms.sale.domain.query.GetSaleQueDetailListQuery;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author : yun
 * @Summary : SaleReader 구현체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun        최초 생성
 * </pre>
 */
@Component("SaleReaderImpl")
@RequiredArgsConstructor
public class SaleReaderImpl implements SaleReader {

    private final String MAPPER_NAMESPACE = "sms.sale.SaleMapper";
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<SaleQueDetailInfo> selectSaleQueDetailList(GetSaleQueDetailListQuery query) {
        return sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".selectSaleQueDetailList", query);
    }

    @Override
    public List<SaleDetailInfo> selectSaleDetailList(GetSaleDetailListQuery query) {
        return sqlSessionTemplate.selectList(MAPPER_NAMESPACE + ".selectSaleDetailList", query);
    }
}
