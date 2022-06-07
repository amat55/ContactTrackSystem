package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("791 296 549");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\nShutting Down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }
        }
    }

    public static void addNewContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact number: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name= " + name + " , phone=" + number);
        } else
            System.out.println("Contact " + name + " already in file");
    }

    public static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else
            System.out.println("Error updating recording");
    }

    public static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else
            System.out.println("Error deleting contact");
    }


    public static void queryContact() {
        System.out.println("Enter existing contact name:  ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " Number: " + existingContactRecord.getPhoneNumber());

    }

    public static void startPhone() {
        System.out.println("Phone is starting...");
    }

    public static void printActions() {
        System.out.println("\nAvailable Actions\n");
        System.out.print("\n0 - shutdown\n" +
                "1 - print Contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update existing an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - query if an existing contact exist\n" +
                "6 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }

}
