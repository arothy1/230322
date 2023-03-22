package com.arothy.search.api.blog.document.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogDocument {

    String name;
    String title;
    String contents;
    String thumbnail;
    String url;
    LocalDateTime datetime;

}
