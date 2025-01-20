package com.fnfcorp.sms.product.domain.query;

import com.fnfcorp.sms.product.domain.entity.Scs;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

/**
 * @Author : yun
 * @Summary : 상품 조회 요청 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/26          yun        최초 생성
 * </pre>
 */

@Builder(builderClassName = "Builder")
@Getter
public class GetScsQuery {
    @NotEmpty(message = "scsId는 필수입니다.")
    private Long scsId;

    public static Builder Builder(long scsId) {
        return builder().scsId(scsId);
    }

    public Scs toEntity() {
        return Scs.builder()
                .id(scsId)
                .build();
    }
}
