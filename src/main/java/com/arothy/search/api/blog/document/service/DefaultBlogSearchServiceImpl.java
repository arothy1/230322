package com.arothy.search.api.blog.document.service;

import com.arothy.search.api.blog.document.dto.BlogDocumentQuery;
import com.arothy.search.api.blog.document.dto.BlogDocumentResponse;
import com.arothy.search.api.blog.keywordcounter.service.BlogKeywordCounterService;
import com.arothy.search.external.com.kakao.blogsearch.api.KakaoBlogSearchApi;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.KakaoBlog;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBlogSearchServiceImpl implements BlogSearchService {

    final BlogKeywordCounterService blogKeywordCounterService;
    final KakaoBlogSearchApi kakaoBlogSearchApi;

    @Override
    public BlogDocumentResponse search(BlogDocumentQuery param) {
        blogKeywordCounterService.increaseCount(param.getQuery());
        KakaoBlogResponse<List<KakaoBlog>> kakaoBlogResponse = kakaoBlogSearchApi.getBlog(param.toKakaoApiQuery());
        return BlogDocumentResponse.ofKakao(kakaoBlogResponse, param);
    }

}
