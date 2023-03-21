package com.arothy.search.external.com.kakao.blogsearch.api;

import com.arothy.search.external.com.kakao.blogsearch.api.protocol.KakaoBlog;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.request.KakaoBlogSearchRequest;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogResponse;
import java.util.List;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

public interface KakaoBlogSearchApi {

    @GetMapping("/v2/search/blog")
    KakaoBlogResponse<List<KakaoBlog>> getBlog(@SpringQueryMap KakaoBlogSearchRequest kakaoBlogSearchRequest);

}
