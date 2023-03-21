package com.arothy.search.api.blog.keywordcounter.service;

import com.arothy.search.db.h2.searchkeyword.entity.SearchKeyword;
import com.arothy.search.db.h2.searchkeyword.repository.SearchKeywordRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogKeywordCounterServiceImpl implements BlogKeywordCounterService {

    final SearchKeywordRepository searchKeywordRepository;

    @Override
    public List<SearchKeyword> getSearchKeywords() {
        return searchKeywordRepository.findTop10ByOrderBySearchCountDesc();
    }

    @Override
    @Transactional
    public void increaseCount(String query) {
        searchKeywordRepository.findByKeyword(query)
            .ifPresentOrElse(
                SearchKeyword::increaseCount,
                () -> searchKeywordRepository.save(SearchKeyword.creationBuilder().keyword(query).build())
            );
    }
}
