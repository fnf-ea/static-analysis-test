package com.fnfcorp.sms.shop.domain.entity;

import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary : 매장 Entity
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */

@Getter
@Builder
public class Shop {
    private Long id;
    private String code;
    private String name;
}
