package com.fnfcorp.sms.product.domain;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.global.exception.CommonErrorCode;
import com.fnfcorp.sms.product.domain.entity.Scs;
import com.fnfcorp.sms.product.domain.info.ScsInfo;
import com.fnfcorp.sms.product.domain.query.GetScsQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author : yun
 * @Summary : 상품 Service
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Slf4j
@Service("ProductServiceImpl")
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Qualifier("ProductReaderImpl")
    private final ProductReader productReader;

    @Override
    public ScsInfo getScs(GetScsQuery query) {
        Scs scs = productReader.selectOneScs(query.toEntity());
        if (scs == null) {
            log.error(ProductErrorCode.ITEM_NOT_FOUND.getMessage());
            throw new BusinessException(ProductErrorCode.ITEM_NOT_FOUND);
        }
        return ScsInfo.of(scs);
    }


}
