package com.arothy.search.api.blog.keywordcounter.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlogKeywordResponse {

    List<BlogKeyword> data;

    public static BlogKeywordResponse ofSearchKeywords(List<com.arothy.search.db.h2.searchkeyword.entity.SearchKeyword> searchKeywords) {
        List<BlogKeyword> dtos = searchKeywords.stream()
            .map(t -> BlogKeyword.builder().keyword(t.getKeyword()).count(t.getSearchCount()).build())
            .collect(Collectors.toList());

        return new BlogKeywordResponse(dtos);
    }

}
