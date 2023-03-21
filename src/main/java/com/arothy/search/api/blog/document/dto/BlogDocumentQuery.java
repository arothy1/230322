package com.arothy.search.api.blog.document.dto;

import com.arothy.search.common.validator.Enum;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.request.KakaoBlogSearchRequest;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class BlogDocumentQuery {

    String query;
    @Min(1) @Max(50)
    Integer page = 1;
    @Min(1) @Max(50)
    Integer itemsPerPage = 10;

//    @Enum(enumClass = BlogDocumentSort.class)
    BlogDocumentSort sort = BlogDocumentSort.ACCURACY;

    public KakaoBlogSearchRequest toKakaoApiQuery() {
        return KakaoBlogSearchRequest.builder()
            .query(query)
            .page(page)
            .sort(sort.kakaoBlogSort)
            .size(itemsPerPage)
            .build();
    }

}
