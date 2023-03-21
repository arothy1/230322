package com.arothy.search.db.h2.searchkeyword.repository;

import com.arothy.search.db.h2.searchkeyword.entity.SearchKeyword;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchKeywordRepository extends JpaRepository<SearchKeyword, Long> {

    List<SearchKeyword> findTop10ByOrderBySearchCountDesc();

    Optional<SearchKeyword> findByKeyword(String keyword);
}
