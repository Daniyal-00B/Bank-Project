public abstract class Person {
    private String firstName, lastName;
    private String birthday;
    private String nationalCode;
    private String address;
    private String phoneNumber;

    public Person(int type) {
        switch (type) {
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
        if (InputUtil.hasNext()) {
            birthday = InputUtil.next();
        } else {
            birthday = "";
        }
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode() {
        System.out.print("National Code: ");
        if (InputUtil.hasNext()) {
            nationalCode = InputUtil.next();
        } else {
            nationalCode = "";
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        System.out.print("Address: ");
        if (InputUtil.hasNext()) {
            address = InputUtil.nextLine();
        } else {
            address = "";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        System.out.print("Phone Number: ");
        if (!InputUtil.hasNext()) {
            phoneNumber = "";
            return;
        }

        String temp = InputUtil.next();

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
        if (InputUtil.hasNext()) {
            firstName = InputUtil.nextLine();
        } else {
            firstName = "";
        }
    }

    public void setLastName() {
        System.out.print("Last Name: ");
        if (InputUtil.hasNext()) {
            lastName = InputUtil.nextLine();
        } else {
            lastName = "";
        }
    }
}