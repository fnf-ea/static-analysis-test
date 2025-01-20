package com.fnfcorp.sms.shop.domain;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.sms.shop.domain.entity.Shop;
import com.fnfcorp.sms.shop.domain.info.ShopInfo;
import com.fnfcorp.sms.shop.domain.query.GetShopQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author : yun
 * @Summary : 매장 Service
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * 2022/01/30          yun       매장 에러코드로 변경
 * </pre>
 */

@Slf4j
@Service("ShopServiceImpl")
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    @Qualifier("ShopReaderImpl")
    private final ShopReader shopReader;

    /**
     * 매장정보 조회
     *
     * @param query 매장조회 조건
     * @return ShopInfo
     * @throws BusinessException
     */
    @Override
    public ShopInfo getShop(GetShopQuery query){
        Shop shop = shopReader.selectOneShop(query.toEntity());
        if (shop == null) {
            log.error(ShopErrorCode.ITEM_NOT_FOUND.getMessage());
            throw new BusinessException(ShopErrorCode.ITEM_NOT_FOUND);
        }
        return ShopInfo.of(shop);
    }
}
