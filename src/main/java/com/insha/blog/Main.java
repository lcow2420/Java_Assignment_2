package com.insha.blog;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        
        try {
            // Read person.json from resources
            InputStream personFile = Main.class.getClassLoader().getResourceAsStream("person.json");
            InputStream blogPostsFile = Main.class.getClassLoader().getResourceAsStream("blogPosts.json");

            if (personFile == null || blogPostsFile == null) {
                System.err.println("Error: JSON files not found in the resources folder.");
                return;
            }

            // Read JSON files into corresponding lists
            List<Person> persons = objectMapper.readValue(personFile, new TypeReference<List<Person>>() {});
            List<BlogPost> blogPosts = objectMapper.readValue(blogPostsFile, new TypeReference<List<BlogPost>>() {});

            // Create Blog instance
            Blog blog = new Blog(persons, blogPosts);

            // Example: Get blog posts by authors of age 26
            List<String> postsByAge = blog.getPostsByAuthorAge(26);
            System.out.println("Blog posts by authors aged 26: " + postsByAge);

            // Total number of blog posts
            System.out.println("Total blog posts: " + blogPosts.size());

            // Total number of unique contributors
            long totalContributors = persons.stream().map(Person::getId).distinct().count();
            System.out.println("Total contributors: " + totalContributors);

        } catch (IOException e) {
            System.err.println("Error reading JSON files: " + e.getMessage());
        }
    }
}
