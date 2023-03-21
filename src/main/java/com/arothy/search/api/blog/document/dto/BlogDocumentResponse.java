package com.arothy.search.api.blog.document.dto;

import com.arothy.search.external.com.kakao.blogsearch.api.protocol.KakaoBlog;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogMeta;
import com.arothy.search.external.com.kakao.blogsearch.api.protocol.response.KakaoBlogResponse;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogDocumentResponse {

    List<BlogDocument> blogDocuments;
    BlogDocumentPagination pagination;

    public static BlogDocumentResponse ofKakao(KakaoBlogResponse<List<KakaoBlog>> kakaoBlogResponse,
        BlogDocumentQuery query) {
        List<KakaoBlog> kakaoBlogs = kakaoBlogResponse.getDocuments();
        KakaoBlogMeta kakaoBlogMeta = kakaoBlogResponse.getMeta();

        List<BlogDocument> blogDocuments = kakaoBlogs.stream()
            .map(t ->
                BlogDocument.builder().name(t.getBlogName()).title(t.getTitle()).contents(t.getContents())
                    .url(t.getUrl()).thumbnail(t.getThumbnail())
                    .datetime(t.getDatetime().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime()).build())
            .collect(Collectors.toList());

        return BlogDocumentResponse.builder()
            .blogDocuments(blogDocuments)
            .pagination(BlogDocumentPagination.builder()
                .page(query.getPage())
                .itemsPerPage(query.getItemsPerPage())
                .totalCount(kakaoBlogMeta.getTotalCount())
                .build()
            ).build();

    }

}
