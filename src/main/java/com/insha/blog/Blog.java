package com.insha.blog;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@EqualsAndHashCode
@Getter
@ToString
public class Blog {
    private final List<Person> authors;
    private final List<BlogPost> posts;

    public Blog(List<Person> authors, List<BlogPost> posts) {
        this.authors = authors;
        this.posts = posts;
    }

    public List<String> getPostsByAuthorAge(Integer age) {
        // Map authors by their ID
        Map<String, Integer> authorAgeMap = authors.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getAge() != null)
                .collect(Collectors.toMap(Person::getId, Person::getAge));

        // Filter posts where the author's age matches the given age
        return posts.stream()
                .filter(post -> authorAgeMap.getOrDefault(post.getAuthorId(), -1).equals(age))
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}
