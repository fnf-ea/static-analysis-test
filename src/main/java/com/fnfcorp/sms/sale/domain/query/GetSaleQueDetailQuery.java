package com.fnfcorp.sms.sale.domain.query;

import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary :
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Getter
@Builder(builderClassName = "Builder")
public class GetSaleQueDetailQuery {
    private Long saleQueId;
}
