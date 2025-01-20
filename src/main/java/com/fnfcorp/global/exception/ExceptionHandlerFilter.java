package com.fnfcorp.global.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnfcorp.global.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author  : hyeongdoYun
 * @Summary :공통 필터(서블릿 등) 익셉션 Handler 클래스
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/24      hyeongdoYun      최초 생성
 * </pre>
 */

@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    /**
     * 필터 Exception 처리용 필터 수행
     *
     * @param request     HttpServletRequest
     * @param response    HttpServletResponse
     * @param filterChain FilterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            filterChain.doFilter(request, response);
        } catch (RuntimeException ex) {
            log.error("RuntimeException", ex);
            setErrorResponse(CommonErrorCode.RUNTIME_EXCEPTION_IN_FILTER, request, response, ex);
        } catch (ServletException servletException) {
            log.error("ServletException", servletException);
            setErrorResponse(CommonErrorCode.SERVLET_EXCEPTION_IN_FILTER, request, response, servletException);
        } catch (Exception e) {
            log.error("Exception", e);
            setErrorResponse(CommonErrorCode.EXCEPTION_IN_FILTER, request, response, e);
        }

    }

    /**
     * 공통 에러 응답 리턴 메소드
     *
     * @param errorCode ErrorCode 공통에러코드
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @param ex        Throwable
     */
    private void setErrorResponse(ErrorCode errorCode, HttpServletRequest request, HttpServletResponse response, Throwable ex) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode, ex.getMessage(), request.getRequestURI());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(errorResponse);
            log.info("setErrorResponse : {}", json);

            response.setHeader(GlobalConstant.HttpHeaders.X_REQUEST_ID, MDC.get(GlobalConstant.Mdc.REQUEST_ID));
            response.setHeader(GlobalConstant.HttpHeaders.X_REQUEST_AT, MDC.get(GlobalConstant.Mdc.REQUEST_AT));
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().write(json);
        } catch (IOException e) {
            log.error("IOException", e);
        }
    }
}
