/*
 * Name: Justin Winstead
 * Date: March 20, 2022
 * Course ID: CS-320/T4514
 * Description: The ContactService class creates and stores Contact objects in a LinkedList.
 * This class can search for Contacts, delete Contacts, and update a Contact's information.
 */


import java.util.LinkedList;

public class ContactService {
    private static ContactService singleService;
    private LinkedList<Contact> contactList;

    /*
     * ContactService constructor
     * This method is private to ensure that only one instance of the class can be created at a given time
     * The constructor initializes the LinkedList that is used to store Contacts
     */
    private ContactService()
    {
        this.contactList = new LinkedList<Contact>();
    }

    /*
     * This method allows for the creation of a single instance of the ContactService class
     * getService is the only way to access the constructor from outside the class
     */
    public static ContactService getService() {
        if (singleService == null) {
            singleService = new ContactService();
            System.out.println("Contact service created");
        }

        return singleService;
    }

    public LinkedList<Contact> getContactList() {
        return contactList;
    }

    // Method to create and add contacts to contactList
    public void contactAdder(String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = new Contact(firstName, lastName, phoneNumber, address);

        contactList.add(contact);
    }

    // Method to display contacts in console for troubleshooting purposes
    public void displayContacts() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.print("Contact ID: " + contactList.get(i).getContactId());
            System.out.print(" First Name: " + contactList.get(i).getFirstName());
            System.out.print(" Last Name: " + contactList.get(i).getLastName());
            System.out.print(" Phone Number: " + contactList.get(i).getPhoneNumber());
            System.out.println(" Address: " + contactList.get(i).getAddress());
        }
    }

    // Method to search contactList for a Contact with the given contactId
    public int basicSearch(String contactId) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactId().equals(contactId)) {
                return i;
            }
        }

        return -1;
    }

    // Method to remove contacts from contactList
    public void deleteContact(String contactId) {
        contactList.remove(Integer.parseInt(contactId));
    }

    /*
     * Method to update a Contact's firstName given their contactId and new firstName
     * Returns -1 if the user cannot be found and 1 if the user can. This is for testing purposes.
     */
    public int updateFirstName(String contactId, String firstName) {
        try {
            contactList.get(basicSearch(contactId)).setFirstName(firstName);
        }

        catch (IndexOutOfBoundsException iobe) {
            System.out.println("Contact ID not found.");
            return -1;
        }

        return 1;
    }

    /*
     * Method to update a Contact's lastName given their contactId and new lastName
     * Returns -1 if the user cannot be found and 1 if the user can. This is for testing purposes.
     */
    public int updateLastName(String contactId, String lastName) {
        try {
            contactList.get(basicSearch(contactId)).setLastName(lastName);
        }

        catch (IndexOutOfBoundsException iobe) {
            System.out.println("Contact ID not found.");
            return -1;
        }

        return 1;
    }

    /*
     * Method to update a Contact's phoneNumber given their contactId and new phoneNumber
     * Returns -1 if the user cannot be found and 1 if the user can. This is for testing purposes.
     */
    public int updatePhoneNumber(String contactId, String phoneNumber) {
        try {
            contactList.get(basicSearch(contactId)).setPhoneNumber(phoneNumber);
        }

        catch (IndexOutOfBoundsException iobe) {
            System.out.println("Contact ID not found.");
            return -1;
        }

        return 1;
    }

    /*
     * Method to update a Contact's address given their contactId and new address
     * Returns -1 if the user cannot be found and 1 if the user can. This is for testing purposes.
     */
    public int updateAddress(String contactId, String address) {
        try {
            contactList.get(basicSearch(contactId)).setAddress(address);
        }

        catch (IndexOutOfBoundsException iobe) {
            System.out.println("Contact ID not found.");
            return -1;
        }

        return 1;
    }


}
