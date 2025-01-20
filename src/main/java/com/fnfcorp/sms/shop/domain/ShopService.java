package com.fnfcorp.sms.shop.domain;

import com.fnfcorp.sms.shop.domain.info.ShopInfo;
import com.fnfcorp.sms.shop.domain.query.GetShopQuery;

/**
 * @Author : yun
 * @Summary : 매장 Service
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */
public interface ShopService {
    ShopInfo getShop(GetShopQuery query);
}
