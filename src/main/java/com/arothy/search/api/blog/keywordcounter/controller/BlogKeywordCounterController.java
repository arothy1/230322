package com.arothy.search.api.blog.keywordcounter.controller;

import com.arothy.search.api.blog.keywordcounter.dto.BlogKeywordResponse;
import com.arothy.search.api.blog.keywordcounter.service.BlogKeywordCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/keyword/counter")
@RequiredArgsConstructor
public class BlogKeywordCounterController {

    final BlogKeywordCounterService blogKeywordCounterService;

    @GetMapping
    public BlogKeywordResponse getPopulars() {
        return BlogKeywordResponse.ofSearchKeywords(blogKeywordCounterService.getSearchKeywords());
    }

}
