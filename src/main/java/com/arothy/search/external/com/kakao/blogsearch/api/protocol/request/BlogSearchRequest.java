package com.arothy.search.external.com.kakao.blogsearch.api.protocol.request;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class BlogSearchRequest {

    String query;
    @Default
    Sort sort = Sort.accuracy;
    Integer page;
    Integer size;

}
