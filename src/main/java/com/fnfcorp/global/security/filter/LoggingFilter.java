package com.fnfcorp.global.security.filter;

import com.fnfcorp.global.constant.GlobalConstant;
import com.fnfcorp.global.util.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author  : yun
 * @Summary : 로깅필터 Class
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/24      yun              최초 생성
 * 2022/11/28      jongchan         함수 call 구조 변경
 *
 * </pre>
 */
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    /**
     * 로깅 Filter 수행
     *
     * @param request     HttpServletRequest
     * @param response    HttpServletResponse
     * @param filterChain FilterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        ResponseWrapper responseWrapper = new ResponseWrapper(response);

        String requestId = UUID.randomUUID().toString();
        String requestAt = LocalDateTime.now().toString();

        MDC.put(GlobalConstant.Mdc.REQUEST_ID, requestId);
        MDC.put(GlobalConstant.Mdc.REQUEST_AT, requestAt);

        responseWrapper.setHeader(GlobalConstant.HttpHeaders.X_REQUEST_ID, requestId);
        responseWrapper.setHeader(GlobalConstant.HttpHeaders.X_REQUEST_AT, requestAt);

        filterChain.doFilter(requestWrapper, responseWrapper);

        String contentType = request.getContentType();
        boolean isErrorInResponse = GlobalUtil.checkResponseError(responseWrapper);
        boolean visible = GlobalUtil.isVisible(MediaType.valueOf(contentType == null ? MediaType.APPLICATION_JSON_VALUE : contentType));

        if(isErrorInResponse){
            log.error("Request :: method [{}], remoteAddr [{}], requestURI [{}], queryString [{}])"
                    ,requestWrapper.getMethod(), requestWrapper.getRemoteAddr(), requestWrapper.getRequestURI(), requestWrapper.getQueryString());
            log.error("Request :: headers {})", GlobalUtil.getHeaders(requestWrapper));
            log.error("Request :: payload {})", GlobalUtil.getPayload(visible, requestWrapper.getInputStream()));
            log.error("Response :: headers {})", responseWrapper.getHeaderNames());
            log.error("Response :: payload {})", GlobalUtil.getPayload(visible, responseWrapper.getContentInputStream()));
        } else {
            log.debug("Request :: method [{}], remoteAddr [{}], requestURI [{}], queryString [{}])"
                    ,requestWrapper.getMethod(), requestWrapper.getRemoteAddr(), requestWrapper.getRequestURI(), requestWrapper.getQueryString());
            log.debug("Request :: headers {})", GlobalUtil.getHeaders(requestWrapper));
            log.debug("Request :: payload {})", GlobalUtil.getPayload(visible, requestWrapper.getInputStream()));
            log.debug("Response :: headers {})", responseWrapper.getHeaderNames());
            log.debug("Response :: payload {})", GlobalUtil.getPayload(visible, responseWrapper.getContentInputStream()));
        }

        responseWrapper.copyBodyToResponse();
        MDC.clear();
    }

}
