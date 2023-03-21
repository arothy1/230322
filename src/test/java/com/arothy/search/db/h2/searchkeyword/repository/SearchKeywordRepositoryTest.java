package com.arothy.search.db.h2.searchkeyword.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.arothy.search.db.h2.searchkeyword.entity.SearchKeyword;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchKeywordRepositoryTest {

    @Autowired
    SearchKeywordRepository repository;

    @Test
    void testFindTop10ByOrderBySearchCountDesc() {
        // given
        List<String> keyword = List.of("t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9", "t10");
        List<SearchKeyword> searchKeywords = keyword.stream()
            .map(t -> SearchKeyword.creationBuilder().keyword(t).build()).collect(
                Collectors.toList());
        repository.saveAll(searchKeywords);
        searchKeywords.get(1).increaseCount();  //t2.increaseCount
        searchKeywords.get(1).increaseCount();
        repository.save(searchKeywords.get(1));

        // when
        List<SearchKeyword> found = repository.findTop10ByOrderBySearchCountDesc();

        // then
        assertThat(found.get(0).getSearchCount()).isEqualTo(3);
        assertThat(found.get(0).getKeyword()).isEqualTo("t2");
        assertThat(found.get(1).getSearchCount()).isEqualTo(1);
    }

}