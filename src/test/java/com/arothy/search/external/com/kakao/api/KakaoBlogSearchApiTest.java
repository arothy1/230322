package com.arothy.search.external.com.kakao.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.arothy.search.external.com.kakao.blogsearch.api.KakaoBlogSearchApi;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.Blog;
import java.util.Map;
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
        String query = "arothy";

        // When
        Blog blog = kakaoBlogSearchApi.getBlog(Map.of("query", query));

        // Then
        assertNotNull(blog);
    }

}