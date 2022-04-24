/*
 * Name: Justin Winstead
 * Date: March 20, 2022
 * Course ID: CS-320/T4514
 * Description: The Contact class stores information pertaining to an individual contact that a user has.
 * It also sanitizes all inputs that it receives when creating a Contact.
 */

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private static AtomicLong idGenerator = new AtomicLong();

    /*
     * Contact Constructor
     * Generates contact ID number for each Contact and sanitizes all other inputs received using other methods
     */
    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        this.contactId = String.valueOf(idGenerator.getAndIncrement());
        this.firstName = errorHandleNames(firstName);
        this.lastName = errorHandleNames(lastName);
        this.phoneNumber = errorHandlePhoneNumber(phoneNumber);
        this.address = errorHandleAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = errorHandleNames(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = errorHandleNames(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = errorHandlePhoneNumber(phoneNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = errorHandleAddress(address);
    }

    // Method to ensure any potential name inputs aren't null or of excessive length
    public String errorHandleNames(String name) {
        if (name == null || name.isBlank()) {
            name = "placeholder";
        }

        else if (name.length() > 10) {
            name = name.substring(0, 10);
        }

        return name;
    }

    // Method to ensure any potential phoneNumber inputs aren't null, an incorrect length, or containing non-integer characters
    public String errorHandlePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() != 10) {
            phoneNumber = "5551112222"; // Use an invalid phone number as a placeholder
        }

        // Check if the string entered consists of integers rather than other characters
        try {
            Integer.parseInt(phoneNumber);
        }

        // Catch error thrown when parseInt encounters non-integer phone numbers
        catch (NumberFormatException nfe) {
            phoneNumber = "5551112222"; // use an invalid phone number as a placeholder
        }

        return phoneNumber;
    }

    // Method to ensure any potential name inputs aren't null or of excessive length
    public String errorHandleAddress(String address) {
        if (address == null || address.isBlank()) {
            address = "placeholder";
        }

        else if (address.length() > 30) {
            address = address.substring(0, 30);
        }

        return address;
    }
}
