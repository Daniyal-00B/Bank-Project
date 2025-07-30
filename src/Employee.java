import java.util.Locale;

abstract class Employee extends Person {
    private long employeeCode;
    private long salary;
    private String workplace;
    int BankCode, BranchCode;

    public Employee(String workplace, int type, int bankCode, int branchCode, int employeeUniCode) {
        super(type);
        setEmployeeCode(type, bankCode, branchCode, employeeUniCode);
        setSalary();
        setWorkplace(workplace);
        BankCode = bankCode;
        BranchCode = branchCode;
    }
    abstract void requests();
    public void userMenu(){};
    public void history() {}
    public void employeeInfo() {
        System.out.println(getFullName() +
                "\nAddress: " + getAddress() + "\nEmployee Code: " + getEmployeeCode() +
                "\nBirthday: " + getBirthday() + "\nNational Code: " + getNationalCode() +
                "\nPhone Number: " + getPhoneNumber() + "\nSalary: " + getSalary() + "$" +
                "\n-----------------------------------------------");
    }
    public void searchEmployee() {
        System.out.print("\nEnter Employee's Name: ");
        String search = InputUtil.nextLine().toLowerCase(Locale.ROOT);
        for (Employee i : Menu.bankList.get(BankCode).branchList.get(BranchCode).employeeList) {
            if (search.equalsIgnoreCase(i.getFullName().trim())) {
                System.out.println();
                i.employeeInfo();
                return;
            }
        }
        System.out.println("\nEmployee Not Found");
    }


    //**************************  (SETTERS)  ************************
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    public void setSalary() {
        System.out.print("Salary ($): ");
        salary = InputUtil.nextInt();
    }
    public void setEmployeeCode(int type, int bankCode, int branchCode, int employeeUniCode) {
        bankCode++;
        branchCode++;
        employeeCode = (long)type*1000000 + (long)bankCode*10000 + (long)branchCode*100 + employeeUniCode+1;
    }

    //**************************  (GETTERS)  ************************
    public String getWorkplace() {
        return workplace;
    }
    public long getSalary() {
        return salary;
    }
    public long getEmployeeCode() {
        return employeeCode;
    }
}