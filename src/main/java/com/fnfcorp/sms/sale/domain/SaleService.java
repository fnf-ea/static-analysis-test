package com.fnfcorp.sms.sale.domain;

import com.fnfcorp.sms.sale.domain.command.RemoveSaleQueCommand;
import com.fnfcorp.sms.sale.domain.command.SaveSaleCommand;
import com.fnfcorp.sms.sale.domain.command.SaveSaleQueCommand;
import com.fnfcorp.sms.sale.domain.info.SaleDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueInfo;
import com.fnfcorp.sms.sale.domain.query.GetSaleDetailListQuery;
import com.fnfcorp.sms.sale.domain.query.GetSaleQueDetailListQuery;

import java.util.List;

/**
 * packageName    : com.fnfcorp.sms.sale.domain
 * fileName       : SaleService
 * author         : yun
 * date           : 2022/12/23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/12/23        yun       최초 생성
 */
public interface SaleService {
    SaleQueInfo saveSaleQue(SaveSaleQueCommand command);
    List<SaleQueDetailInfo> getSaleQueDetailList(GetSaleQueDetailListQuery query);
    SaleInfo saveSale(SaveSaleCommand command);
    List<SaleDetailInfo> getSaleDetailList(GetSaleDetailListQuery query);
    void removeSaleQue(RemoveSaleQueCommand command);
}
