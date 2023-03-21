package com.arothy.search.api.blog.document.service;

import com.arothy.search.api.blog.document.dto.BlogDocumentQuery;
import com.arothy.search.api.blog.document.dto.BlogDocumentResponse;

public interface BlogSearchService {

    BlogDocumentResponse search(BlogDocumentQuery query);

}
