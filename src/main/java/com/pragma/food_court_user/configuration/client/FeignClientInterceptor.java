package com.pragma.food_court_user.configuration.client;

import com.pragma.food_court_user.configuration.security.jwt.JwtTokenUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    private final JwtTokenUtil jwtTokenUtil;

    public FeignClientInterceptor(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = jwtTokenUtil.generateTokenFeign();
        requestTemplate.header("Authorization", "Bearer " + token);
    }
}
