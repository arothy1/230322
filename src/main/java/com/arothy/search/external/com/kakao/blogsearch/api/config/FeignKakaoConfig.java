package com.arothy.search.external.com.kakao.blogsearch.api.config;

import com.arothy.search.external.com.kakao.blogsearch.api.KakaoBlogSearchApi;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignKakaoConfig {

    @Value("${kakao-api.url}")
    String kakaoApiUrl;

    @Bean
    public KakaoBlogSearchApi kakaoBlogSearchApi(@Autowired KakaoBlogSearchInterceptor kakaoBlogSearchInterceptor) {
        return Feign.builder()
            .contract(new SpringMvcContract())
            .client(new OkHttpClient())
            .retryer(Retryer.NEVER_RETRY)
            .options(new Request.Options(1000, TimeUnit.MILLISECONDS, 1000, TimeUnit.MILLISECONDS, false))
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .logger(new Slf4jLogger("kakaoBlogSearchApi"))
            .logLevel(Logger.Level.HEADERS)
            .requestInterceptor(kakaoBlogSearchInterceptor)
            .target(KakaoBlogSearchApi.class, kakaoApiUrl);
    }


}
