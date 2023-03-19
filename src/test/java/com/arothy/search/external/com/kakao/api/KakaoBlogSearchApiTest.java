package com.arothy.search.external.com.kakao.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.arothy.search.external.com.kakao.blogsearch.api.KakaoBlogSearchApi;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.Blog;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.request.BlogSearchRequest;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoBlogSearchApiTest {

    @Autowired
    KakaoBlogSearchApi kakaoBlogSearchApi;


    @Test
    public void getBlog() {
        // Given
        String query = "java";

        // When
        KakaoBlogResponse<List<Blog>> blogResponse = kakaoBlogSearchApi.getBlog(
            BlogSearchRequest.builder().query(query).build());

        // Then
        assertNotNull(blogResponse);
    }

}