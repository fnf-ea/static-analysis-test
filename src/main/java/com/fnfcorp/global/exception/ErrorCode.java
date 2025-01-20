package com.fnfcorp.global.exception;

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
public interface ErrorCode {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();
}
