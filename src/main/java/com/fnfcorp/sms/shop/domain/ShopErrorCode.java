package com.fnfcorp.sms.shop.domain;

import com.fnfcorp.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @Author : yun
 * @Summary :
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2023/01/18          yun       최초 생성
 * </pre>
 */
public enum ShopErrorCode implements ErrorCode {
    ITEM_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "SHOP-501", "매장 정보를 찾을수 없습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ShopErrorCode(HttpStatus httpStatus, String code, String message) {
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
