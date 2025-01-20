package com.fnfcorp.sms.sale.domain;

import com.fnfcorp.sms.sale.domain.info.SaleDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueDetailInfo;
import com.fnfcorp.sms.sale.domain.query.GetSaleDetailListQuery;
import com.fnfcorp.sms.sale.domain.query.GetSaleQueDetailListQuery;

import java.util.List;

/**
 * packageName    : com.fnfcorp.sms.sale.domain
 * fileName       : SaleReader
 * author         : yun
 * date           : 2022/12/23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/23        yun       최초 생성
 */
public interface SaleReader {
    List<SaleQueDetailInfo> selectSaleQueDetailList(GetSaleQueDetailListQuery query);

    List<SaleDetailInfo> selectSaleDetailList(GetSaleDetailListQuery query);
}
