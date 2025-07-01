import java.util.ArrayList;

public abstract class Person {
    private String firstName, lastName;
    private String birthday;
    private String nationalCode;
    private String address;
    private String phoneNumber;
    public ArrayList<String> mails = new ArrayList<>();

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
    abstract void userMenu();
    public void mailBox(){
        if (mails.isEmpty())
            System.out.println("\nYour Mail Box is Empty");
        else {
            for (int i=mails.size()-1 ; i>=0 ; i--)
                System.out.println("\n------------------------------------------------------------\n"
                                  + mails.get(i) +
                                   "\n------------------------------------------------------------");
        }
    }
    public void addMail(String massage) {
        mails.add(massage);
    }

    //**************************  (SETTERS)  ************************
    public void setFirstName() {
        System.out.print("First Name: ");
        firstName = InputUtil.nextLine();
    }
    public void setLastName() {
        System.out.print("Last Name: ");
        lastName = InputUtil.nextLine();
    }
    public void setBirthday() {
        System.out.print("Birthday: ");
        if (InputUtil.hasNext()) {
            birthday = InputUtil.next();
        } else {
            birthday = "";
        }
    }
    public void setNationalCode() {
        System.out.print("National Code: ");
        if (InputUtil.hasNext()) {
            nationalCode = InputUtil.next();
        } else {
            nationalCode = "";
        }
    }
    public void setAddress() {
        System.out.print("Address: ");
        if (InputUtil.hasNext()) {
            address = InputUtil.nextLine();
        } else {
            address = "";
        }
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

    //**************************  (GETTERS)  ************************
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getNationalCode() {
        return nationalCode;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}