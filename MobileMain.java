
import java.util.ArrayList;
import java.util.Scanner;

public class MobileMain {


        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (ContactList) that holds the ArrayList of Contacts
        // The ContactList class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to ContactList
        // e.g. no ints, no .get(i) etc
        // ContactList should do everything with Contact objects only.
    //Hello test


    private static Scanner scanner = new Scanner(System.in);
    private static ContactList contactList = new ContactList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    contactList.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the contact list");
        System.out.println("\t 2 - To add an contact to the list.");
        System.out.println("\t 3 - To modify an contact in the list.");
        System.out.println("\t 4 - To remove an contact from the list.");
        System.out.println("\t 5 - To search for an contact in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addContact() {
        System.out.print("Please write contact name: ");
        contactList.addContact(scanner.nextLine());
    }

    public static void modifyContact() {
        System.out.print("Name: ");
        String contactNo = scanner.nextLine();
        System.out.print("Enter new contact: ");
        String newContact = scanner.nextLine();
        contactList.modifyContact(contactNo, newContact);
    }

    public static void removeContact() {
        System.out.print("Enter item name: ");
        String contactNo = scanner.nextLine();
        contactList.removeContact(contactNo);
    }

    public static void searchForContact() {
        System.out.print("Contact to search for: ");
        String searchContact = scanner.nextLine();
        if(contactList.onFile(searchContact)) {
            System.out.println("Found " + searchContact);
        } else {
            System.out.println(searchContact + ", not on file.");
        }
    }

    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(contactList.getContactList());

        ArrayList<String> nextArray = new ArrayList<String>(contactList.getContactList());

        String[] myArray = new String[contactList.getContactList().size()];
        myArray = contactList.getContactList().toArray(myArray);


    }

}
