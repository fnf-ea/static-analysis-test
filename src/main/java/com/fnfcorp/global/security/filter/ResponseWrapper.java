package com.fnfcorp.global.security.filter;

import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @Author  : HyeongDoYun
 * @Summary : Response 재사용 Wrapper Class
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/21      HyeongDoYun     최초 생성
 * </pre>
 */
public class ResponseWrapper extends ContentCachingResponseWrapper {
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }
}