package com.arothy.search.external.com.kakao.blogsearch.api;

import com.arothy.search.external.com.kakao.blogsearch.api.protocol.Blog;
import java.util.Map;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

public interface KakaoBlogSearchApi {

    @GetMapping("/v2/search/blog")
    Blog getBlog(@SpringQueryMap Map<String, String> queryMap);

}
