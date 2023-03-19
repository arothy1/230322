package com.arothy.search.external.com.kakao.blogsearch.api;

import com.arothy.search.external.com.kakao.blogsearch.api.protocol.Blog;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.request.BlogSearchRequest;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogResponse;
import java.util.List;
import java.util.Map;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

public interface KakaoBlogSearchApi {

    @GetMapping("/v2/search/blog")
    KakaoBlogResponse<List<Blog>> getBlog(@SpringQueryMap BlogSearchRequest blogSearchRequest);

}
