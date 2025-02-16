import org.junit.jupiter.api.Test;
import com.insha.blog.BlogPost;
import static org.junit.jupiter.api.Assertions.*;

public class BlogPostTest {

    @Test
    public void testValidBlogPostCreation() {
        // Valid inputs
        String id = "1";
        String authorId = "author123";
        String postContent = "This is a blog post content.";

        BlogPost blogPost = new BlogPost(id, authorId, postContent);

        assertNotNull(blogPost);
        assertEquals(id, blogPost.getId());
        assertEquals(authorId, blogPost.getAuthorId());
        assertEquals(postContent, blogPost.getPostContent());
    }

    @Test
    public void testNullIdThrowsException() {
        // Null ID should throw IllegalArgumentException
        String id = null;
        String authorId = "author123";
        String postContent = "This is a blog post content.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlogPost(id, authorId, postContent);
        });

        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    public void testNullAuthorIdThrowsException() {
        // Null Author ID should throw IllegalArgumentException
        String id = "1";
        String authorId = null;
        String postContent = "This is a blog post content.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlogPost(id, authorId, postContent);
        });

        assertEquals("Author ID cannot be null", exception.getMessage());
    }

    @Test
    public void testBlankPostContentThrowsException() {
        // Blank post content should throw IllegalArgumentException
        String id = "1";
        String authorId = "author123";
        String postContent = "   "; // Blank space

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlogPost(id, authorId, postContent);
        });

        assertEquals("Post content cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testNullPostContentThrowsException() {
        // Null post content should throw IllegalArgumentException
        String id = "1";
        String authorId = "author123";
        String postContent = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlogPost(id, authorId, postContent);
        });

        assertEquals("Post content cannot be null or blank", exception.getMessage());
    }
}
