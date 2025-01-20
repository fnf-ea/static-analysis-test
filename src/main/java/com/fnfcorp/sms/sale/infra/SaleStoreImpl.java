package com.fnfcorp.sms.sale.infra;

import com.fnfcorp.sms.sale.domain.SaleStore;
import com.fnfcorp.sms.sale.domain.entity.Sale;
import com.fnfcorp.sms.sale.domain.entity.SaleQue;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author           : yun
 * @Summary         : 판매 Store 구현체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun        최초 생성
 *</pre>
 */
@Component("SaleStoreImpl")
@RequiredArgsConstructor
public class SaleStoreImpl implements SaleStore {

    private final String MAPPER_NAMESPACE = "sms.sale.SaleMapper";
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public SaleQue insertSaleQue(SaleQue saleQue) {
        sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".insertSaleQue", saleQue);
        return saleQue;
    }

    @Override
    public Sale insertSale(Sale sale) {
        sqlSessionTemplate.insert(MAPPER_NAMESPACE + ".insertSale", sale);
        return sale;
    }
    @Override
    public void deleteSaleQue(SaleQue saleQue) {
        sqlSessionTemplate.delete(MAPPER_NAMESPACE + ".deleteSaleQue", saleQue);
    }
}
