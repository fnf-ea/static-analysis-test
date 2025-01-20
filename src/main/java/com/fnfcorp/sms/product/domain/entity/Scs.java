package com.fnfcorp.sms.product.domain.entity;

import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary : Scs Entity 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */
@Getter
@Builder
public class Scs{
    private Long id;
    private Long styleId;
    private Long colorId;
    private Long sizeId;
    private Long price;
}
