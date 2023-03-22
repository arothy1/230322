package com.arothy.search.external.com.kakao.blogsearch.api.protocol.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class KakaoBlogMeta {

    Integer totalCount;
    Integer pageableCount;
    Boolean isEnd;

}
