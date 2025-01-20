package com.fnfcorp.sms.shop.infra;

import com.fnfcorp.sms.shop.domain.ShopReader;
import com.fnfcorp.sms.shop.domain.entity.Shop;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author : yun
 * @Summary : 매장 조회 Dao ReaderImpl
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */
@Component("ShopReaderImpl")
@RequiredArgsConstructor
public class ShopReaderImpl implements ShopReader {
    private final String MAPPER_NAMESPACE = "sms.shop.ShopMapper";
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Shop selectOneShop(Shop shop) {
        return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".selectOneShop", shop);
    }
}
