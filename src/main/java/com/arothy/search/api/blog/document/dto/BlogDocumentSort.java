package com.arothy.search.api.blog.document.dto;

import com.arothy.search.external.com.kakao.blogsearch.api.protocol.request.KakaoBlogSort;
import java.util.Arrays;

public enum BlogDocumentSort {

    ACCURACY(KakaoBlogSort.accuracy),
    RECENCY(KakaoBlogSort.recency);

    final KakaoBlogSort kakaoBlogSort;

    BlogDocumentSort(KakaoBlogSort kakaoBlogSort) {
        this.kakaoBlogSort = kakaoBlogSort;
    }

}
