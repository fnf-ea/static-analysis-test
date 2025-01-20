package com.fnfcorp.sms.sale.api;

import com.fnfcorp.global.exception.BusinessException;
import com.fnfcorp.sms.sale.api.request.GetSaleDetailListRequest;
import com.fnfcorp.sms.sale.api.request.GetSaleQueDetailListRequest;
import com.fnfcorp.sms.sale.api.request.SaveSaleListRequest;
import com.fnfcorp.sms.sale.api.request.SaveSaleQueRequest;
import com.fnfcorp.sms.sale.api.response.GetSaleDetailListResponse;
import com.fnfcorp.sms.sale.api.response.GetSaleQueDetailListResponse;
import com.fnfcorp.sms.sale.api.response.SaveSaleListResponse;
import com.fnfcorp.sms.sale.api.response.SaveSaleQueResponse;
import com.fnfcorp.sms.sale.application.SaleFacade;
import com.fnfcorp.sms.sale.domain.info.FailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueDetailInfo;
import com.fnfcorp.sms.sale.domain.info.SaleQueInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author : yun
 * @Summary : 판매 컨트롤러
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun        최초 생성
 * </pre>
 */
@RestController
@RequiredArgsConstructor
public class SaleController {
    private final SaleFacade saleFacade;

    /**
     * 판매대기열 저장
     *
     * @param request
     * @return SaleDto.SaveSaleQueueResponse
     */
    @PostMapping("/v1/sale/que")
    public ResponseEntity<SaveSaleQueResponse> saveSaleQue(@RequestBody @Valid SaveSaleQueRequest request) throws BusinessException {

        SaleQueInfo info = saleFacade.saveSaleQue(request);

        SaveSaleQueResponse response = SaveSaleQueResponse.of(info);

        return ResponseEntity.ok(response);
    }

    /**
     * 판매대기열 조회
     *
     * @param request 판매대기열 조회 조건
     * @return List < SaleVo >
     */
    @GetMapping("/v1/sale/que")
    public ResponseEntity<GetSaleQueDetailListResponse> getSaleQueDetailList(@Valid GetSaleQueDetailListRequest request) {

        List<SaleQueDetailInfo> list = saleFacade.getSaleQueDetailList(request);

        List<GetSaleQueDetailListResponse.Item> items =
                list.stream()
                        .map(GetSaleQueDetailListResponse.Item::of)
                        .collect(Collectors.toList());

        GetSaleQueDetailListResponse response = GetSaleQueDetailListResponse
                .builder()
                .items(items)
                .build();

        return ResponseEntity.ok(response);
    }


    /**
     * 판매 저장
     *
     * @param request 판매저장 요청
     * @return SaleDto.SaveSaleResponse
     */
    @PostMapping("/v1/sale/history")
    public ResponseEntity<SaveSaleListResponse> saveSaleList(@RequestBody @Valid SaveSaleListRequest request) {
        //1.판매 저장
        List<FailInfo> list = saleFacade.saveSaleList(request);

        SaveSaleListResponse response = SaveSaleListResponse.of(request.getItems().size(), list);

        return ResponseEntity.ok(response);
    }


    /**
     * 판매 조회
     *
     * @param request 판매조회검색 조건
     * @return List[SaleVo.SaleDetailInfo]
     */
    @GetMapping("/v1/sale/history")
    public ResponseEntity<GetSaleDetailListResponse> getSaleDetailList(@Valid GetSaleDetailListRequest request) {

        List<SaleDetailInfo> detailInfoList = saleFacade.getSaleDetailList(request);

        List<GetSaleDetailListResponse.Item> items =
                detailInfoList
                        .stream()
                        .map(GetSaleDetailListResponse.Item::of)
                        .collect(Collectors.toList());

        GetSaleDetailListResponse response = GetSaleDetailListResponse
                .builder()
                .items(items)
                .build();

        return ResponseEntity.ok(response);
    }

}
