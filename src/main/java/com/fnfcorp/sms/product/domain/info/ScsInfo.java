package com.fnfcorp.sms.product.domain.info;

import com.fnfcorp.sms.product.domain.entity.Scs;
import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary : 상품 정보
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun       최초 생성
 * </pre>
 */

@Getter
@Builder
public class ScsInfo {
    private long id;
    private long styleId;
    private long colorId;
    private long sizeId;
    public static ScsInfo of(Scs scs){
        return ScsInfo.builder()
                .id(scs.getId())
                .styleId(scs.getStyleId())
                .colorId(scs.getColorId())
                .sizeId(scs.getSizeId())
                .build();
    }
}
