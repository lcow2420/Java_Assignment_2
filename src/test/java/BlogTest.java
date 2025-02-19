import com.insha.blog.Blog;
import com.insha.blog.BlogPost;
import com.insha.blog.Person;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlogTest {

    @Test
    void testGetPostsByAuthorAge() {
        Person author1 = new Person("1", "Insha", "Hayat", 26, "Female");
        Person author2 = new Person("2", "Bob", "Johnson", 25, "Male");
        BlogPost post1 = new BlogPost("101", "1", "First post");
        BlogPost post2 = new BlogPost("102", "2", "Second post");
        BlogPost post3 = new BlogPost("103", "1", "Another post by Alice");

        Blog blog = new Blog(List.of(author1, author2), List.of(post1, post2, post3));

        List<String> postsBy30 = blog.getPostsByAuthorAge(26);
        assertEquals(List.of("101", "103"), postsBy30);

        List<String> postsBy25 = blog.getPostsByAuthorAge(25);
        assertEquals(List.of("102"), postsBy25);

        List<String> postsBy40 = blog.getPostsByAuthorAge(40);
        assertEquals(List.of(), postsBy40);
    }

    @Test
    void testMissingAuthor() {
        BlogPost post1 = new BlogPost("101", "99", "Orphan post");
        Blog blog = new Blog(List.of(), List.of(post1));

        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(List.of(), result);
    }

    @Test
    void testEmptyData() {
        Blog blog = new Blog(List.of(), List.of());
        assertEquals(List.of(), blog.getPostsByAuthorAge(30));
    }
}
