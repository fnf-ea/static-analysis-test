package com.fnfcorp.global.exception;

import lombok.Builder;
import lombok.Getter;

/**
 * @Author  : HyeongDoYun
 * @Summary : ErrorResponse Class
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/17      Jongchan        최초 생성
 * 2022/11/18      Jongchan        클래스,메소드 접근한정자 변경
 * </pre>
 */
@Getter
class ErrorResponse {
    private final String code;
    private final String message;
    private final String detail;
    private final String path;

    @Builder
    protected ErrorResponse(ErrorCode errorCode, String detail, String path) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.detail = detail;
        this.path = path;
    }

}
