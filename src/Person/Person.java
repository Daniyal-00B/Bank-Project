package Person;

public abstract class Person {
    private String firstName, lastName;
    private String birthday;
    private long nationalCode;
    private String address;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String birthday, long nationalCode, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        setBirthday(birthday);
        setNationalCode(nationalCode);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public String getLastName() {
        return lastName;
    }

    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}