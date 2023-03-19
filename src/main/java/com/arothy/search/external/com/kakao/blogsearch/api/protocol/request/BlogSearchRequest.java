package com.arothy.search.external.com.kakao.blogsearch.api.protocol.request;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class BlogSearchRequest {

    String query;

    @Default
    Sort sort = Sort.accuracy;

    @Size(min = 1, max = 50)
    Integer page;

    @Default
    @Size(min = 1, max = 50)
    Integer size = 10;

}
