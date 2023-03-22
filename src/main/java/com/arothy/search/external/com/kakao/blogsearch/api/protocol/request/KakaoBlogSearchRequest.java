package com.arothy.search.external.com.kakao.blogsearch.api.protocol.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
public class KakaoBlogSearchRequest {

    @NotEmpty
    String query;

    @Default
    KakaoBlogSort sort = KakaoBlogSort.accuracy;

    @Size(min = 1, max = 50)
    Integer page;

    @Default
    @Size(min = 1, max = 50)
    Integer size = 10;

}
