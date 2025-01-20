package com.fnfcorp.sms.shop.domain.info;

import com.fnfcorp.sms.shop.domain.entity.Shop;
import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary : 매장 정보 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */
@Builder
@Getter
public class ShopInfo {
    private Long id;
    private String code;
    private String name;
    public static ShopInfo of(Shop shop) {
        return ShopInfo.builder()
                .id(shop.getId())
                .code(shop.getCode())
                .name(shop.getName())
                .build();
    }

}
