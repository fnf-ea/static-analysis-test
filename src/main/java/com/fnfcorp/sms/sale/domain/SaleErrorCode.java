package com.fnfcorp.sms.sale.domain;

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
public enum SaleErrorCode implements ErrorCode {
    SALE_ITEM_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "SALE-501", "판매 아이템을 찾을수 없습니다."),
    SALE_SOLD_OUT(HttpStatus.INTERNAL_SERVER_ERROR, "SALE-502", "매진되었습니다."),
    SALE_SAVE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "SALE-503", "판매 정보 저장에 실패하였습니다."),
    SALEQUE_SAVE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "SALE-513", "판매대기열 정보 저장에 실패하였습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    SaleErrorCode(HttpStatus httpStatus, String code, String message) {
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
