package com.insha.blog;
public class Main {

    public static void main(String[] args) {
        // Create valid BlogPost
        try {
            BlogPost blogPost1 = new BlogPost("1", "author123", "This is a blog post content.");
            System.out.println(blogPost1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating BlogPost: " + e.getMessage());
        }

        // Create invalid BlogPost with null ID
        try {
            BlogPost blogPost2 = new BlogPost(null, "author123", "This is another blog post content.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating BlogPost: " + e.getMessage());
        }

        // Create invalid BlogPost with blank content
        try {
            BlogPost blogPost3 = new BlogPost("2", "author456", "   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating BlogPost: " + e.getMessage());
        }
    }
}
