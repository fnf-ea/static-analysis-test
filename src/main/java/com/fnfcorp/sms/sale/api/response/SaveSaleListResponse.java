package com.fnfcorp.sms.sale.api.response;

import com.fnfcorp.sms.sale.domain.info.FailInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

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
@Builder
@Getter
public class SaveSaleListResponse {
    int reqCnt;
    int successCnt;
    int failCnt;
    List<FailInfo> failItems;

    public static SaveSaleListResponse of(int reqCnt, List<FailInfo> failItems) {
        return SaveSaleListResponse.builder()
                .reqCnt(reqCnt)
                .successCnt(reqCnt - failItems.size())
                .failCnt(failItems.size())
                .failItems(failItems)
                .build();
    }
}
