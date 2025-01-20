package com.fnfcorp.global.exception;

import org.springframework.http.HttpStatus;

/**
 * @Author  : HyeongDoYun
 * @Summary : 에러코드 정의 Enum 클래스
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/17      HyeongDoYun       최초 생성
 * 2022/11/21      HyeongDoYun       Not Found(404) 예외 추가
 * 2022/11/24      HyeongDoYun       Filter에서 발생하는 Exception 코드 추가
 * </pre>
 */
public enum CommonErrorCode implements ErrorCode {

    // HttpStatus 4xx
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "COMM-401", "Invalid Parameter"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMM-402", "Unauthorized"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "COMM-404", "Not Found"),


    // HttpStatus 5xx
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMM-501", "Internal Server Error"),
    SERVLET_EXCEPTION_IN_FILTER(HttpStatus.INTERNAL_SERVER_ERROR, "COMM-502", "Servlet Exception in Filter"),
    EXCEPTION_IN_FILTER(HttpStatus.INTERNAL_SERVER_ERROR, "COMM-503", "Exception in Filter"),
    RUNTIME_EXCEPTION_IN_FILTER(HttpStatus.INTERNAL_SERVER_ERROR, "COMM-504", "Runtime Exception in Filter"),
    EXCEPTION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMM-599", "Internal Exception");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    CommonErrorCode(HttpStatus httpStatus, String code, String message) {
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
