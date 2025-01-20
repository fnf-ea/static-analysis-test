package com.fnfcorp.sms.sale.domain.info;

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

@Builder
@Getter
public class FailInfo {
    private Long id;
    private String message;
}
