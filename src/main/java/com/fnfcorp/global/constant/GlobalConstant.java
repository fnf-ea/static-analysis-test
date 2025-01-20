package com.fnfcorp.global.constant;

/**
 * packageName    : com.fnfcorp.global.constant
 * fileName       : GlobalConstant
 * author         : yun
 * date           : 2022/11/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/24        yun       최초 생성
 */
public class GlobalConstant {

    public static class MediaType {
        public static final String APPLICATION_WILDCARD_JSON = "application/*+json";
        public static final String APPLICATION_WILDCARD_XML = "application/*+xml";
        public static final String TEXT_WILDCARD = "text/*";
    }

    public static class HttpHeaders{
        public static final String X_REQUEST_ID = "X-Request-Id";
        public static final String X_REQUEST_AT = "X-Request-At";
    }

    public static class Mdc{
        public static final String REQUEST_ID = "requestId";
        public static final String REQUEST_AT = "requestAt";
    }





}
