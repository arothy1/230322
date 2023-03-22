package com.arothy.search.api.blog.document.controller;

import com.arothy.search.api.blog.document.dto.BlogDocumentQuery;
import com.arothy.search.api.blog.document.dto.BlogDocumentResponse;
import com.arothy.search.api.blog.document.service.BlogSearchService;
import com.arothy.search.common.exception.GeneralException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/documents")
@RequiredArgsConstructor
public class BlogDocumentSearchController {

    final BlogSearchService blogSearchService;

    @GetMapping
    public BlogDocumentResponse getBlogDocuments(@ModelAttribute @Valid BlogDocumentQuery blogDocumentQuery) {
        return blogSearchService.search(blogDocumentQuery);
    }

}
