package com.fnfcorp.global.util;

import com.fnfcorp.global.constant.GlobalConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * @Author          : jongchan
 * @Summary         : Global Util 클래스
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 22. 11. 28.      jongchan        최초 생성
 */
public class GlobalUtil {

    private GlobalUtil() {
    }

    /**
     * Response 에러 여부 체크
     *
     * @param response
     * @return boolean
     */
    public static boolean checkResponseError(HttpServletResponse response) {
        HttpStatus.Series series = HttpStatus.Series.resolve(response.getStatus());
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series)) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 로깅 할 수 있는 MediaType 체크
     *
     * @param mediaType
     * @return boolean
     */
    public static boolean isVisible(MediaType mediaType) {
        final List<MediaType> visibleTypes = Arrays.asList(
                MediaType.valueOf(GlobalConstant.MediaType.TEXT_WILDCARD),
                MediaType.APPLICATION_FORM_URLENCODED,
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML,
                MediaType.valueOf(GlobalConstant.MediaType.APPLICATION_WILDCARD_JSON),
                MediaType.valueOf(GlobalConstant.MediaType.APPLICATION_WILDCARD_XML)
        );

        return visibleTypes.stream()
                .anyMatch(visibleType -> visibleType.includes(mediaType));
    }

    /**
     * Header 정보 획득
     *
     * @param request
     * @return HashMap<String, String>
     */
    public static HashMap<String, String> getHeaders(HttpServletRequest request) {
        HashMap<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        return headers;
    }

    /**
     * Payload 정보 획득
     *
     * @param visible
     * @param inputStream
     * @return HashMap<String, String>
     */
    public static String getPayload(boolean visible, InputStream inputStream) throws IOException {
        if (visible) {
            return StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        } else {
            return "Invisible MediaType";
        }
    }

}
