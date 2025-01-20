package com.fnfcorp.sms.sale.application;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.global.exception.ErrorCode;
import com.fnfcorp.sms.member.domain.MemberService;
import com.fnfcorp.sms.member.domain.command.ModifyMemberMileageCommand;
import com.fnfcorp.sms.member.domain.info.MemberInfo;
import com.fnfcorp.sms.member.domain.query.GetMemberQuery;
import com.fnfcorp.sms.product.domain.ProductService;
import com.fnfcorp.sms.product.domain.query.GetScsQuery;
import com.fnfcorp.sms.rfid.domain.RfidService;
import com.fnfcorp.sms.rfid.domain.command.ConfirmRfidStatusForSaleCommand;
import com.fnfcorp.sms.rfid.domain.info.RfidInfo;
import com.fnfcorp.sms.rfid.domain.query.GetRfidQuery;
import com.fnfcorp.sms.rfid.domain.query.ValidateRfidForSaleQuery;
import com.fnfcorp.sms.sale.api.request.GetSaleDetailListRequest;
import com.fnfcorp.sms.sale.api.request.GetSaleQueDetailListRequest;
import com.fnfcorp.sms.sale.api.request.SaveSaleListRequest;
import com.fnfcorp.sms.sale.api.request.SaveSaleQueRequest;
import com.fnfcorp.sms.sale.domain.SaleService;
import com.fnfcorp.sms.sale.domain.command.RemoveSaleQueCommand;
import com.fnfcorp.sms.sale.domain.command.SaveSaleCommand;
import com.fnfcorp.sms.sale.domain.command.SaveSaleQueCommand;
import com.fnfcorp.sms.sale.domain.info.FailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueInfo;
import com.fnfcorp.sms.sale.domain.query.GetSaleDetailListQuery;
import com.fnfcorp.sms.sale.domain.query.GetSaleQueDetailListQuery;
import com.fnfcorp.sms.shop.domain.ShopService;
import com.fnfcorp.sms.shop.domain.query.GetShopQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HyeongDo Yun
 * @Summary : SaleFacade
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26      HyeongDo Yun     최초 생성
 * </pre>
 */
@Slf4j
@Service("SaleFacade")
@RequiredArgsConstructor
public class SaleFacade {
    @Qualifier("SaleServiceImpl")
    private final SaleService saleService;

    @Qualifier("RfidServiceImpl")
    private final RfidService rfidService;

    @Qualifier("ProductServiceImpl")
    private final ProductService productService;

    @Qualifier("ShopServiceImpl")
    private final ShopService shopService;

    @Qualifier("MemberServiceImpl")
    private final MemberService memberService;
    private final TransactionTemplate transactionTemplate;

    /**
     * 판매대기열 저장
     *
     * @param request
     * @return SaleQueInfo
     */
    @Transactional
    public SaleQueInfo saveSaleQue(SaveSaleQueRequest request) {
        //1.Rfid 기본 정보 조회
        RfidInfo rfidInfo = rfidService.getRfid(
                GetRfidQuery
                        .Builder(request.getRfidCode())
                        .build());

        //2.Rfid Validation
        rfidService.validateRfidStateForSale(
                ValidateRfidForSaleQuery
                        .Builder(rfidInfo, request.getShopId())
                        .build());

        //3.상품정보 조회
        productService.getScs(
                GetScsQuery
                        .Builder(rfidInfo.getScsId())
                        .build());

        //4.매장 정보 조회
        shopService.getShop(
                GetShopQuery
                        .Builder(request.getShopId())
                        .build());

        //5.대기열 저장
        SaleQueInfo saleQueInfo = saleService.saveSaleQue(
                SaveSaleQueCommand
                        .Builder(rfidInfo.getRfidId(),
                                request.getShopId(),
                                rfidInfo.getScsId(),
                                LocalDate.now()
                        ).build());

        return saleQueInfo;
    }

    /**
     * 판매대기열 목록 조회
     *
     * @param request GetSaleQueListRequest
     * @return SaleQueDetailInfo
     */
    public List<SaleQueDetailInfo> getSaleQueDetailList(GetSaleQueDetailListRequest request) {
        return saleService.getSaleQueDetailList(
                GetSaleQueDetailListQuery.builder()
                        .startDate(request.getStartDate())
                        .endDate(request.getEndDate())
                        .shopId(request.getShopId())
                        .build());
    }

    /**
     * 판매 등록
     *
     * @param request
     * @return List<ErrorInfo>
     */
    public List<FailInfo> saveSaleList(@Valid SaveSaleListRequest request) {
        List<FailInfo> failInfoList = new ArrayList<>();
        for (SaveSaleListRequest.SaveSaleItem item : request.getItems()) {
            transactionTemplate.executeWithoutResult(s -> {
                try {
                    saveSaleItem(item);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    failInfoList.add(
                            FailInfo.builder()
                                    .id(item.getSaleQueId())
                                    .message("" + e.getMessage())
                                    .build());
                    s.setRollbackOnly();//롤백호출함수 호출
                }
            });
        }

        return failInfoList;
    }

    public void saveSaleItem(SaveSaleListRequest.SaveSaleItem item) {
        saleService.saveSale(SaveSaleCommand
                .Builder(item.getRfidId(), item.getScsId()
                        , item.getShopId(), item.getActualPrice()
                        , LocalDate.now())
                .memberId(item.getMemberId())
                .useMileage(item.getUseMileage())
                .build());

        if (item.getMemberId() != null) {
            //2.고객정보 조회
            MemberInfo memberInfo = memberService.getMember(
                    GetMemberQuery.builder()
                            .id(item.getMemberId())
                            .build());

            //3 마일리지 적립/사용
            memberService.modifyMemberMileage(
                    ModifyMemberMileageCommand.builder()
                            .memberId(memberInfo.getId())
                            .actualPrice(item.getActualPrice())
                            .useMileage(item.getUseMileage())
                            .build());
        }
        //4.Rfid 판매 완료 상태로 확정
        rfidService.confirmRfidStateForSale(
                ConfirmRfidStatusForSaleCommand
                        .Builder(item.getRfidId())
                        .build());
        //5.판매대기열 삭제
        saleService.removeSaleQue(
                RemoveSaleQueCommand
                        .builder()
                        .saleQueId(item.getSaleQueId())
                        .build());
    }

    /**
     * 판매 목록 상세 조회
     *
     * @param request
     * @return List<SaleDetailInfo>
     */
    public List<SaleDetailInfo> getSaleDetailList(GetSaleDetailListRequest request) {
        return saleService.getSaleDetailList(
                GetSaleDetailListQuery.builder()
                        .startDate(request.getStartDate())
                        .endDate(request.getEndDate())
                        .shopId(request.getShopId())
                        .build());
    }
}
