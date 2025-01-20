package com.fnfcorp.global.security.filter;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * @Author  : HyeongDoYun
 * @Summary : Request 재사용 Wrapper Class
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/21      HyeongDoYun      최초 생성
 * 2022/11/28      Jongchan         ReadListener 지원하지 않도록 수정
 * </pre>
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    private ByteArrayOutputStream cachedBytes;

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * RequestInputStream 데이터 복사, 복사된 ServletInputStream 리턴
     * @return ServletInputStream
     * @throws IOException
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (cachedBytes == null)
            cacheInputStream();

        return new CachedServletInputStream();
    }

    /**
     * Reader로 호출 될 때 getInputStream()으로 리다이렉트
     * @return BufferedReader
     * @throws IOException
     */
    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    /**
     * cachedBytes에 Request InputStream 데이터 Copy
     * @throws IOException
     */
    private void cacheInputStream() throws IOException {
        cachedBytes = new ByteArrayOutputStream();
        IOUtils.copy(super.getInputStream(), cachedBytes);
    }


    /**
     * ServletInputStream 복사본 클래스
     */
    public class CachedServletInputStream extends ServletInputStream {
        private final ByteArrayInputStream input;

        public CachedServletInputStream() {
            input = new ByteArrayInputStream(cachedBytes.toByteArray());
        }

        @Override
        public boolean isFinished() {
            return input.available() == 0;
        }

        @Override
        public boolean isReady() {
            return !isFinished();
        }

        @Override
        public void setReadListener(ReadListener listener) {
            throw new UnsupportedOperationException("Unsupported ReadListener");
        }
        @Override
        public int read() {
            return input.read();
        }
    }

}
