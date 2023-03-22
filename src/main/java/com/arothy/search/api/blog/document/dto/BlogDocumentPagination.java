package com.arothy.search.api.blog.document.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogDocumentPagination {

    Integer page;
    Integer itemsPerPage;
    Integer totalCount;

}
