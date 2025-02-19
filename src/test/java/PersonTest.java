import static org.junit.jupiter.api.Assertions.*;
import com.insha.blog.Person;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testValidPersonCreation() {
        // Create a valid Person instance
        
        Person person = new Person("1", "John", "Doe", 30, "Male");

        assertNotNull(person);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    public void testPersonWithBlankFirstName() {
        // Try creating a person with blank first name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("1", "", "Doe", 30, "Male");
        });
        assertEquals("First name cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testPersonWithNullFirstName() {
        // Try creating a person with null first name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("1", null, "Doe", 30, "Male");
        });
        assertEquals("First name cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testPersonWithBlankLastName() {
        // Try creating a person with blank last name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("1", "John", "", 30, "Male");
        });
        assertEquals("Last name cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testPersonWithNullLastName() {
        // Try creating a person with null last name
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("1", "John", null, 30, "Male");
        });
        assertEquals("Last name cannot be null or blank", exception.getMessage());
    }

    @Test
    public void testPersonWithNegativeAge() {
        // Try creating a person with a negative age
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("1", "John", "Doe", -5, "Male");
        });
        assertEquals("Age cannot be negative", exception.getMessage());
    }
}
