package com.arothy.search.external.com.kakao.blogsearch.api.protocol.response;

import lombok.Getter;

@Getter
public class KakaoBlogResponse<T> {

    KakaoBlogMeta meta;
    T documents;

}
