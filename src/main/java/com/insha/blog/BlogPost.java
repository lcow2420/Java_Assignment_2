package com.insha.blog;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import lombok.ToString;
import lombok.extern.jackson.Jacksonized;


@Getter
@ToString
@EqualsAndHashCode
@Jacksonized
@Builder
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    public BlogPost(String id, String authorId, String postContent) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (authorId == null) {
            throw new IllegalArgumentException("Author ID cannot be null");
        }
        if (postContent == null || postContent.isBlank()) {
            throw new IllegalArgumentException("Post content cannot be null or blank");
        }

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}
