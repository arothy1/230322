package com.arothy.search.api.blog.keywordcounter.service;

import com.arothy.search.db.h2.searchkeyword.entity.SearchKeyword;
import java.util.List;

public interface BlogKeywordCounterService {

    List<SearchKeyword> getSearchKeywords();

    void increaseCount(String keyword);
}
