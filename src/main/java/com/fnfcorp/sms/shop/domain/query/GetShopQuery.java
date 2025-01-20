package com.fnfcorp.sms.shop.domain.query;

import com.fnfcorp.sms.shop.domain.entity.Shop;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

/**
 * @Author : yun
 * @Summary : 매장 조회 요청 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */
@Builder(builderClassName = "Builder")
@Getter
public class GetShopQuery {
    @NotEmpty(message = "shopId는 필수 입니다.")
    private Long shopId;
    private Long userId;

    public static Builder Builder(Long shopId) {
        return builder().shopId(shopId);
    }

    public Shop toEntity(){
        return Shop.builder()
                .id(shopId)
                .build();
    }
}
