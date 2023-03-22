package com.arothy.search.api.blog.document.controller;

import com.arothy.search.api.blog.document.dto.BlogDocumentQuery;
import com.arothy.search.api.blog.document.dto.BlogDocumentResponse;
import com.arothy.search.api.blog.document.service.BlogSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "블로그 검색")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = BlogDocumentResponse.class)))
    })
    @GetMapping
    public BlogDocumentResponse search(@ModelAttribute @Valid BlogDocumentQuery blogDocumentQuery) {
        return blogSearchService.getBlogDocuments(blogDocumentQuery);
    }

}
