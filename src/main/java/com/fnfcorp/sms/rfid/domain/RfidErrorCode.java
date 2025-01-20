package com.fnfcorp.sms.rfid.domain;

import com.fnfcorp.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @Author : yun
 * @Summary : Rfid 도메인 비즈니스 에러코드
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2023/01/18          yun       최초 생성
 * </pre>
 */
public enum RfidErrorCode implements ErrorCode {
    ITEM_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "RFID-501", "RFID 정보가 존재하지 않습니다."),
    STATUS_NOT_FOR_SALE(HttpStatus.INTERNAL_SERVER_ERROR, "RFID-502", "RFID 가 판매가능 상태가 아닙니다."),
    LOCATION_DIFF(HttpStatus.INTERNAL_SERVER_ERROR, "RFID-503", "RFID 와 매장위치가 다릅니다."),
    CODE_LENGTH_DIFF(HttpStatus.INTERNAL_SERVER_ERROR, "RFID-504", "RFID 코드 길이가 다릅니다."),
    CODE_VALID_NUMBER_DIFF(HttpStatus.INTERNAL_SERVER_ERROR, "RFID-505", "RFID 코드 검증번호가 다릅니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    RfidErrorCode(HttpStatus httpStatus, String code, String message) {
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
