package com.fnfcorp.sms.sale.domain;

import com.fnfcorp.sms.sale.domain.entity.Sale;
import com.fnfcorp.sms.sale.domain.entity.SaleQue;

/**
 * packageName    : com.fnfcorp.sms.sale.domain
 * fileName       : SaleStore
 * author         : yun
 * date           : 2022/12/23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/23        yun       최초 생성
 */
public interface SaleStore {
    SaleQue insertSaleQue(SaleQue saleQue);
    Sale insertSale(Sale sale);
    void deleteSaleQue(SaleQue saleQue);
}
