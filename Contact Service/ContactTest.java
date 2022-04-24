/*
 * Name: Justin Winstead
 * Date: March 20, 2022
 * Course ID: CS-320/T4514
 * Description: Tests to demonstrate the functionality of the Contact class
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactTest {

    @Test
    @DisplayName("Test for the creation of a Contact using the constructor")
    @Order(1)
    void testContactCreation() {
        Contact contact = new Contact("Justin", "Winstead", "1234567890", "123 Alphabet Blvd.");

        assertEquals("Justin", contact.getFirstName());
        assertEquals("Winstead", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Alphabet Blvd.", contact.getAddress());
    }


    @Test
    @DisplayName("Test for first name longer than 10 characters")
    @Order(2)
    void testFirstNameLong() {
        Contact contact = new Contact("Justin12345", "Winstead", "1234567890", "123 Alphabet Blvd.");

        assertEquals("Justin1234", contact.getFirstName());
    }

    @Test
    @DisplayName("Test for first name that is null")
    @Order(3)
    void testFirstNameNull() {
        Contact contact = new Contact( null, "Winstead", "1234567890", "123 Alphabet Blvd.");

        assertEquals("placeholder", contact.getFirstName());
    }

    @Test
    @DisplayName("Test for last name longer than 10 characters")
    @Order(4)
    void testLastNameLong() {
        Contact contact = new Contact( "Justin", "Winstead123", "1234567890", "123 Alphabet Blvd.");

        assertEquals("Winstead12", contact.getLastName());
    }

    @Test
    @DisplayName("Test for last name that is null")
    @Order(5)
    void testLastNameNull() {
        Contact contact = new Contact( "Justin", null, "1234567890", "123 Alphabet Blvd.");

        assertEquals("placeholder", contact.getLastName());
    }

    @Test
    @DisplayName("Test for phone number longer than 10 characters")
    @Order(6)
    void testPhoneNumberLong() {
        Contact contact = new Contact( "Justin", "Winstead", "12345678901", "123 Alphabet Blvd.");

        assertEquals("5551112222", contact.getPhoneNumber());
    }

    @Test
    @DisplayName("Test for phone number shorter than 10 characters")
    @Order(7)
    void testPhoneNumberShort() {
        Contact contact = new Contact("Justin", "Winstead", "123456789", "123 Alphabet Blvd.");

        assertEquals("5551112222", contact.getPhoneNumber());
    }

    @Test
    @DisplayName("Test for phone number that is null")
    @Order(8)
    void testPhoneNumberNull() {
        Contact contact = new Contact("Justin", "Winstead", null, "123 Alphabet Blvd.");

        assertEquals("5551112222", contact.getPhoneNumber());
    }

    @Test
    @DisplayName("Test for phone number consisting of non-integer characters")
    @Order(9)
    void testPhoneNumberLetters() {
        Contact contact = new Contact("Justin", "Winstead", "A nice day", "123 Alphabet Blvd.");

        assertEquals("5551112222", contact.getPhoneNumber());
    }

    @Test
    @DisplayName("Test for address longer than 10 characters")
    @Order(10)
    void testAddressLong() {
        Contact contact = new Contact("Justin", "Winstead", "1234567890", "1232345678901234567890123456789");

        assertEquals("123234567890123456789012345678", contact.getAddress());
    }

    @Test
    @DisplayName("Test for address that is null")
    @Order(11)
    void testAddressNull() {
        Contact contact = new Contact("Justin", "Winstead", "1234567890", null);

        assertEquals("placeholder", contact.getAddress());
    }

}