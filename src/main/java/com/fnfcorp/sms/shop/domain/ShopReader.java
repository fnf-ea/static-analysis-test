package com.fnfcorp.sms.shop.domain;

import com.fnfcorp.sms.shop.domain.entity.Shop;

/**
 * @Author : yun
 * @Summary : 매장 조회 Dao Reader
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */
public interface ShopReader {
    Shop selectOneShop(Shop shop);
}
