package com.fnfcorp.global.security;

import com.fnfcorp.global.constant.GlobalConstant;
import com.fnfcorp.global.exception.ExceptionHandlerFilter;
import com.fnfcorp.global.security.filter.LoggingFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : yun
 * @Summary : Spring Security Configuration Class
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/11/25       yun             최초 생성
 * </pre>
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfiguration {
    /**
     * SpringSecurity Filter 설정
     * Request -> ExceptionHandlerFitler -> LoggingFilter -> ...
     * @param httpSecurity HttpSecurity
     * @return SecurityFilterChain(Bean)
     * @throws Exception Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .cors(cors->cors.configurationSource(corsConfigurationSource()))
                .addFilterBefore(loggingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(exceptionHandlerFilter(), LoggingFilter.class)
                .build();
    }
    /**
     * Request,Response 로깅을 위한 LoggingFilter 생성
     *
     * @return LoggingFilter(Bean)
     */
    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }
    /**
     * 서블릿에러 로깅을 위한 ExceptionHandlerFilter 생성
     *
     * @return ExceptionHandlerFilter(Bean)
     */
    @Bean
    public ExceptionHandlerFilter exceptionHandlerFilter() {
        return new ExceptionHandlerFilter();
    }
    /**
     * Spring Security Cors 관련 설정 정의
     *
     * @return CorsConfigurationSource(Bean)
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList(HttpMethod.HEAD.name(), HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name()));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.addExposedHeader(HttpHeaders.AUTHORIZATION);
        configuration.addExposedHeader(GlobalConstant.HttpHeaders.X_REQUEST_ID);
        configuration.addExposedHeader(GlobalConstant.HttpHeaders.X_REQUEST_AT);
        configuration.addExposedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("*", configuration);
        return source;
    }
}
