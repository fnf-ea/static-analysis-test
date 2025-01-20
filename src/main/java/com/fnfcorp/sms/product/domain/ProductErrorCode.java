package com.fnfcorp.sms.product.domain;

import com.fnfcorp.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @Author : yun
 * @Summary :
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2023/01/30          yun       최초 생성
 * </pre>
 */
public enum ProductErrorCode implements ErrorCode {
    ITEM_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "PRDT-501", "상품 아이템을 찾을수 없습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ProductErrorCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

