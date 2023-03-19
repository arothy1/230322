package com.arothy.search.external.com.kakao.blogsearch.api.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KakaoBlogSearchInterceptor implements RequestInterceptor {

    @Value("${kakao-api.key}")
    String kakaoApiKey;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", kakaoApiKey);
        template.header("Content-Type", "application/json; charset=UTF-8");
    }

}
