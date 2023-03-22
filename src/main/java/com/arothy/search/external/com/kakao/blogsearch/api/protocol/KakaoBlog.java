package com.arothy.search.external.com.kakao.blogsearch.api.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Getter;

@Getter
public class KakaoBlog {

    String title;
    String contents;
    String url;
    @JsonProperty("blogname")
    String blogName;
    String thumbnail;
    Date datetime;

}
