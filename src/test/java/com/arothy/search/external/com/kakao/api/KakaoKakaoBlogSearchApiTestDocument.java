package com.arothy.search.external.com.kakao.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.arothy.search.external.com.kakao.blogsearch.api.KakaoBlogSearchApi;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.KakaoBlog;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.request.KakaoBlogSearchRequest;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogResponse;
import feign.FeignException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoBlogSearchApiTestDocument {

    @Autowired
    KakaoBlogSearchApi kakaoBlogSearchApi;

    @Test
    public void givenValidPage_whenGetBlog_thenReturnValidResponse() {
        // Given
        String query = "java";
        int page = 1;

        // When
        KakaoBlogResponse<List<KakaoBlog>> response = kakaoBlogSearchApi.getBlog(
            KakaoBlogSearchRequest.builder().query(query).page(page).build());

        // Then
        assertThat(response).isNotNull();
    }

    @Test
    public void givenInvalidPage_whenGetBlog_thenThrowInvalidArgument() {
        // Given
        String query = "java";
        int page = 51;

        // When
        Throwable thrown = catchThrowable(
            () -> kakaoBlogSearchApi.getBlog(KakaoBlogSearchRequest.builder().query(query).page(page).build()));

        // Then
        assertThat(thrown).isInstanceOf(FeignException.class);
        assertThat(thrown.getMessage()).contains("InvalidArgument");
    }

    @Test
    public void givenInvalidQuery_whenGetBlog_thenThrowMissingParameter() {
        // Given
        String query = "";

        // When
        Throwable thrown = catchThrowable(
            () -> kakaoBlogSearchApi.getBlog(KakaoBlogSearchRequest.builder().query(query).build()));

        // Then
        assertThat(thrown).isInstanceOf(FeignException.class);
        assertThat(thrown.getMessage()).contains("MissingParameter");
    }

    @Test
    public void givenInvalidQuery_whenGetBlog_thenThrowMissingParameter2() {
        // Given
        String query = null;

        // When
        Throwable thrown = catchThrowable(
            () -> kakaoBlogSearchApi.getBlog(KakaoBlogSearchRequest.builder().query(query).build()));

        // Then
        assertThat(thrown).isInstanceOf(FeignException.class);
        assertThat(thrown.getMessage()).contains("MissingParameter");
    }

}