package com.fnfcorp.sms.product.infra;

import com.fnfcorp.sms.product.domain.ProductReader;
import com.fnfcorp.sms.product.domain.entity.Scs;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author : yun
 * @Summary : 상품 조회 Reader
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */
@Component("ProductReaderImpl")
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {
    private final String MAPPER_NAMESPACE = "sms.product.ProductMapper";
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Scs selectOneScs(Scs scs) {
        return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".selectOneScs", scs);
    }
}
