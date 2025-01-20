package com.fnfcorp.sms.product.domain;

import com.fnfcorp.sms.product.domain.entity.Scs;

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
public interface ProductReader {
    Scs selectOneScs(Scs scs);
}
