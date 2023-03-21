package com.arothy.search.db.h2.searchkeyword.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "search_keyword")
@Getter
@DynamicUpdate
@NoArgsConstructor
public class SearchKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "keyword", unique = true)
    String keyword;

    @Column(name = "search_count")
    Integer searchCount;

    public void increaseCount() {
        searchCount++;
    }

    @Builder(builderMethodName = "creationBuilder")
    public SearchKeyword(String keyword) {
        this.keyword = keyword;
        this.searchCount = 1;
    }
}
