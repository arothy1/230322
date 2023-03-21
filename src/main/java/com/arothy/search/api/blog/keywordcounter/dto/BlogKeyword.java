package com.arothy.search.api.blog.keywordcounter.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogKeyword {

    String keyword;
    Integer count;

}
