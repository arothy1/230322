package com.arothy.search.api.blog.document.service;

import com.arothy.search.api.blog.document.dto.BlogDocumentQuery;
import com.arothy.search.api.blog.document.dto.BlogDocumentResponse;
import com.arothy.search.external.com.kakao.blogsearch.api.KakaoBlogSearchApi;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.KakaoBlog;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBlogSearchServiceImpl implements BlogSearchService {

    final KakaoBlogSearchApi kakaoBlogSearchApi;

    @Override
    public BlogDocumentResponse search(BlogDocumentQuery query) {
        KakaoBlogResponse<List<KakaoBlog>> kakaoBlogResponse = kakaoBlogSearchApi.getBlog(query.toKakaoApiQuery());
        return BlogDocumentResponse.ofKakao(kakaoBlogResponse, query);
    }
}
