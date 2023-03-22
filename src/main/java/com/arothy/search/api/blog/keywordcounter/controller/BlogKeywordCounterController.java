package com.arothy.search.api.blog.keywordcounter.controller;

import com.arothy.search.api.blog.keywordcounter.dto.BlogKeywordResponse;
import com.arothy.search.api.blog.keywordcounter.service.BlogKeywordCounterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/keyword/counter")
@RequiredArgsConstructor
public class BlogKeywordCounterController {

    final BlogKeywordCounterService blogKeywordCounterService;

    @Operation(summary = "인기 검색어 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = BlogKeywordResponse.class)))
    })
    @GetMapping
    public BlogKeywordResponse getPopulars() {
        return BlogKeywordResponse.ofSearchKeywords(blogKeywordCounterService.getSearchKeywords());
    }

}
