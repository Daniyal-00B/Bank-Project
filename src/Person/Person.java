package Person;

import java.util.Scanner;

public abstract class Person {
    private String firstName, lastName;
    private String birthday;
    private String nationalCode;
    private String address;
    private String phoneNumber;
    Scanner scanner = new Scanner(System.in);

    public Person(int type){
        switch (type){
            case 1 -> System.out.println("\nBranch Manager Info:");
            case 2 -> System.out.println("\nAssistant Manager Info:");
            case 3 -> System.out.println("\nPlease Enter Your Info:");
        }
        setFirstName();
        setLastName();
        setBirthday();
        setNationalCode();
        setAddress();
        setPhoneNumber();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday() {
        System.out.print("Birthday: ");
        if (scanner.hasNext()) {
            birthday = scanner.next();
            scanner.nextLine();
        } else {
            birthday = "";
        }
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode() {
        System.out.print("National Code: ");
        if (scanner.hasNext()) {
            nationalCode = scanner.next();
            scanner.nextLine();
        } else {
            nationalCode = "";
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        System.out.print("Address: ");
        if (scanner.hasNextLine()) {
            address = scanner.nextLine();
        } else {
            address = "";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        System.out.print("Phone Number: ");
        if (!scanner.hasNext()) {
            phoneNumber = "";
            return;
        }

        String temp = scanner.next();
        scanner.nextLine();

        try {
            Long.parseLong(temp);
        } catch (Exception _) {
            System.out.println("Phone Number Must be Number");
            setPhoneNumber();
            return;
        }

        if (temp.length() == 11 && temp.charAt(0) == '0') {
            phoneNumber = temp;
        } else {
            System.out.println("Invalid Format! Try Again");
            setPhoneNumber();
        }
    }

    public void setFirstName() {
        System.out.print("First Name: ");
        if (scanner.hasNextLine()) {
            firstName = scanner.nextLine();
        } else {
            firstName = "";
        }
    }

    public void setLastName() {
        System.out.print("Last Name: ");
        if (scanner.hasNextLine()) {
            lastName = scanner.nextLine();
        } else {
            lastName = "";
        }
    }
}
