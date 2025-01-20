package com.fnfcorp.sms.sale.domain;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.sms.sale.domain.command.RemoveSaleQueCommand;
import com.fnfcorp.sms.sale.domain.command.SaveSaleCommand;
import com.fnfcorp.sms.sale.domain.command.SaveSaleQueCommand;
import com.fnfcorp.sms.sale.domain.entity.Sale;
import com.fnfcorp.sms.sale.domain.entity.SaleQue;
import com.fnfcorp.sms.sale.domain.info.SaleDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueInfo;
import com.fnfcorp.sms.sale.domain.query.GetSaleDetailListQuery;
import com.fnfcorp.sms.sale.domain.query.GetSaleQueDetailListQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : yun
 * @Summary : 판매 도메인 서비스
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/29          yun        최초 생성
 * </pre>
 */
@Slf4j
@Service("SaleServiceImpl")
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    @Qualifier("SaleReaderImpl")
    private final SaleReader saleReader;

    @Qualifier("SaleStoreImpl")
    private final SaleStore saleStore;

    /**
     * 판매 대기열 정보 저장
     *
     * @param command 판매대기열 정보
     * @return
     * @throws BusinessException
     */

    @Override
    public SaleQueInfo saveSaleQue(SaveSaleQueCommand command) {
        try{
            SaleQue saleQue = saleStore.insertSaleQue(command.toEntity());
            return SaleQueInfo.of(saleQue);
        }catch (Exception e){
            log.error(SaleErrorCode.SALEQUE_SAVE_FAIL.getMessage(), e.getMessage());
            throw new BusinessException(SaleErrorCode.SALEQUE_SAVE_FAIL);
        }
    }

    /**
     * 판매 대기열 정보 목록 조회
     *
     * @param query
     * @return List<SaleQueDetailInfo>
     */
    @Override
    public List<SaleQueDetailInfo> getSaleQueDetailList(GetSaleQueDetailListQuery query) {
        return saleReader.selectSaleQueDetailList(query);
    }

    /**
     * 판매 정보 저장
     *
     * @param command
     * @return
     * @throws BusinessException
     */
    @Transactional
    @Override
    public SaleInfo saveSale(SaveSaleCommand command) {
        try{
            Sale sale = saleStore.insertSale(command.toEntity());
            return SaleInfo.of(sale);
        }
        catch (Exception e){
            log.error(SaleErrorCode.SALE_SAVE_FAIL.getMessage(), e.getMessage());
            throw new BusinessException(SaleErrorCode.SALE_SAVE_FAIL);
        }
    }

    /**
     * 판매 정보 조회
     *
     * @param query
     * @return List<SaleDetailInfo>
     */
    @Override
    public List<SaleDetailInfo> getSaleDetailList(GetSaleDetailListQuery query) {
        return saleReader.selectSaleDetailList(query);
    }

    /**
     * 판매 대기열 정보 삭제
     *
     * @param command
     */
    @Transactional
    @Override
    public void removeSaleQue(RemoveSaleQueCommand command) {
        saleStore.deleteSaleQue(command.toEntity());
    }
}
