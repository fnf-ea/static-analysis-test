package com.fnfcorp.global.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : HyeongDoYun
 * @Summary : 공통 Exception Handler 클래스
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/17      HyeongDoYun        최초 생성
 * 2022/11/21      HyeongDoYun     404 NoHandlerFoundException 핸들러 추가
 * </pre>
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * BusinessException 핸들링
     *
     * @param e       BusinessException
     * @param request ServletWebRequest
     * @return ResponseEntity<ErrorResponse>  공용 에러 응답 클래스
     */
    @ExceptionHandler(value = BusinessException.class)
    protected ResponseEntity<ErrorResponse> businessExceptionHandler(BusinessException e, ServletWebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(e.getErrorCode())
                .detail(e.getDetail())
                .path(request.getRequest().getRequestURI()).build();
        return new ResponseEntity<>(errorResponse, e.getErrorCode().getHttpStatus());
    }

    /**
     * Exception 핸들링
     *
     * @param e       Exception
     * @param request ServletWebRequest
     * @return ResponseEntity<ErrorResponse>  공용 에러 응답 클래스
     */
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ErrorResponse> exceptionHandler(Exception e, ServletWebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(CommonErrorCode.EXCEPTION_ERROR)
                .detail(e.getMessage())
                .path(request.getRequest().getRequestURI()).build();

        return new ResponseEntity<>(errorResponse, CommonErrorCode.EXCEPTION_ERROR.getHttpStatus());
    }

    /**
     * Bind Validation Exception 핸들링
     *
     * @param e       Exception
     * @param request ServletWebRequest
     * @return ResponseEntity<ErrorResponse>  공용 에러 응답 클래스
     */

    @ExceptionHandler(value = BindException.class)
    protected ResponseEntity<ErrorResponse> bindExceptionHandler(BindException e, ServletWebRequest request) {
        HashMap<String, ArrayList<FieldError>> errorMap = new HashMap<>();

        StringBuilder builder = new StringBuilder();

        for (FieldError fieldError : e.getFieldErrors()) {
            if (errorMap.containsKey(fieldError.getField())) {
                errorMap.get(fieldError.getField()).add(fieldError);
            } else {
                ArrayList<FieldError> fieldErrors = new ArrayList<>();
                fieldErrors.add(fieldError);
                errorMap.put(fieldError.getField(), fieldErrors);
            }
        }

        //TODO: 하나의 Request 에 대한 Error 가 다양할 경우에 대한 응답 체계 논의 필요 (임시로 comma 와 semicolone 처리)
        for (Map.Entry<String, ArrayList<FieldError>> entry : errorMap.entrySet()) {
            builder.append("에러필드:");
            builder.append(entry.getKey());
            builder.append(",입력된값:");

            if (entry.getValue().get(0).getRejectedValue() == null) {
                builder.append("null");
            } else {
                builder.append(entry.getValue().get(0).getRejectedValue());
            }

            builder.append(",원인:");
            for (FieldError fieldError : entry.getValue()) {
                builder.append(fieldError.getDefaultMessage());
            }
            builder.append(";");
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(CommonErrorCode.INVALID_PARAMETER)
                .detail(builder.toString())
                .path(request.getRequest().getRequestURI()).build();

        return new ResponseEntity<>(errorResponse, CommonErrorCode.INVALID_PARAMETER.getHttpStatus());
    }


    /**
     * 404 NoHandlerFoundException 핸들링
     *
     * @param e       NoHandlerFoundException
     * @param request ServletWebRequest
     * @return ResponseEntity<ErrorResponse>  공용 에러 응답 클래스
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    protected ResponseEntity<ErrorResponse> noHandlerFoundExceptionHandler(NoHandlerFoundException e, ServletWebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder().errorCode(CommonErrorCode.NOT_FOUND).detail(e.getMessage()).path(request.getRequest().getRequestURI()).build();
        return new ResponseEntity<>(errorResponse, CommonErrorCode.NOT_FOUND.getHttpStatus());
    }

}
