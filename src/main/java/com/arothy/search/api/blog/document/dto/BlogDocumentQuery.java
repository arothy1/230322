package com.arothy.search.api.blog.document.dto;

import com.arothy.search.external.com.kakao.blogsearch.api.protocol.request.KakaoBlogSearchRequest;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class BlogDocumentQuery {

    @NotNull @NotEmpty
    String query;
    @Min(1) @Max(50)
    Integer page = 1;
    @Min(1) @Max(50)
    Integer itemsPerPage = 10;

    BlogDocumentSort sort = BlogDocumentSort.ACCURACY;
    boolean increaseSearchCount = false;

    public KakaoBlogSearchRequest toKakaoApiQuery() {
        return KakaoBlogSearchRequest.builder()
            .query(query)
            .page(page)
            .sort(sort.kakaoBlogSort)
            .size(itemsPerPage)
            .build();
    }

}
