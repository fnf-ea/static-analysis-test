package com.fnfcorp.sms.product.domain;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.sms.product.domain.info.ScsInfo;
import com.fnfcorp.sms.product.domain.query.GetScsQuery;

/**
 * @Author           : yun
 * @Summary         : 상품 Service
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun        최초 생성
 *</pre>
 */
public interface ProductService {
    ScsInfo getScs(GetScsQuery query) throws BusinessException;
}
