/*
 * Name: Justin Winstead
 * Date: March 20, 2022
 * Course ID: CS-320/T4514
 * Description: Tests to demonstrate the functionality of the ContactService class
 */


import org.junit.jupiter.api.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {

    ContactService contactService = ContactService.getService(); // create the instance of the ContactService class to be used for testing

    @Test
    @DisplayName("Test to check ContactService and Contact List are created")
    @Order(1)
    void testContactServiceClass() {
        assertTrue(contactService instanceof ContactService);
        assertTrue(contactService.getContactList() instanceof LinkedList<Contact>);
    }

    @Test
    @DisplayName("Test to add Contact and verify Contact information")
    @Order(2)
    void testContactAdder() {
        contactService.contactAdder( "Justin", "Winstead", "1234567890", "123 Alphabet Blvd.");

        assertEquals("Justin", contactService.getContactList().get(0).getFirstName());
        assertEquals("Winstead", contactService.getContactList().get(0).getLastName());
        assertEquals("1234567890", contactService.getContactList().get(0).getPhoneNumber());
        assertEquals("123 Alphabet Blvd.", contactService.getContactList().get(0).getAddress());

    }

    @Test
    @DisplayName("Test for search functionality")
    @Order(3)
    void testSearchFunction() {
        contactService.contactAdder( "Julio", "Darwin", "0987654321", "456 Number St.");
        contactService.contactAdder( "Nitsuj", "Daetsniw", "1029384756", "789 Consonant Way");

        // ensure that basicSearch functions properly with a contactId in contactList and a contactId that is not
        assertEquals(1 ,contactService.basicSearch("1"));
        assertEquals(-1 ,contactService.basicSearch("100"));
    }

    @Test
    @DisplayName("Test for contact deleting functionality")
    @Order(4)
    void testDeleteFunction() {
        // perform a search to verify Contact is in the contactList and delete that Contact
        assertEquals(0 ,contactService.basicSearch("0"));
        contactService.deleteContact("0");

        // perform a search to verify Contact has been deleted
        assertEquals(-1 ,contactService.basicSearch("0"));

        // displaying contactList for visual verification that the right Contact was deleted
        contactService.displayContacts();
    }

    @Test
    @DisplayName("Test to update first name valid ID")
    @Order(5)
    void testUpdateFirstNameValid() {
        contactService.updateFirstName("1", "Paul");

        assertEquals("Paul", contactService.getContactList().get(contactService.basicSearch("1")).getFirstName());

    }

    @Test
    @DisplayName("Test to update last name with valid ID")
    @Order(6)
    void testUpdateLastNameValid() {
        contactService.updateLastName("1", "Wilson");

        assertEquals("Wilson", contactService.getContactList().get(contactService.basicSearch("1")).getLastName());
    }

    @Test
    @DisplayName("Test to update phone number with valid ID")
    @Order(7)
    void testUpdatePhoneNumberValid() {
        contactService.updatePhoneNumber("1", "1122112211");

        assertEquals("1122112211", contactService.getContactList().get(contactService.basicSearch("1")).getPhoneNumber());

    }

    @Test
    @DisplayName("Test to update address with valid ID")
    @Order(8)
    void testUpdateAddressValid() {
        contactService.updateAddress("1", "111 Street St.");

        assertEquals("111 Street St.", contactService.getContactList().get(contactService.basicSearch("1")).getAddress());

    }

    @Test
    @DisplayName("Test to update first name invalid ID")
    @Order(9)
    void testUpdateFirstNameInvalid() {
        assertEquals(-1, contactService.updateFirstName("-1", "Paul"));
    }

    @Test
    @DisplayName("Test to update last name with invalid ID")
    @Order(10)
    void testUpdateLastNameInvalid() {
        assertEquals(-1, contactService.updateLastName("-1", "Wilson"));
    }

    @Test
    @DisplayName("Test to update phone number with invalid ID")
    @Order(11)
    void testUpdatePhoneNumberInvalid() {
        assertEquals(-1, contactService.updatePhoneNumber("-1", "1122112211"));
    }

    @Test
    @DisplayName("Test to update address with invalid ID")
    @Order(12)
    void testUpdateAddressInvalid() {
        assertEquals(-1, contactService.updateAddress("-1", "111 Street St."));
    }

}