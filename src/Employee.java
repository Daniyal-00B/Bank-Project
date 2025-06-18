public class Employee extends Person {
    private String employeeCode;
    private long salary;
    private String workplace;
    private static int employeeCounter = 0;

    public Employee(String workplace, int type, int bankCode, int branchCode) {
        super(type);
        setEmployeeCode(type, bankCode, branchCode);
        setSalary();
        setWorkplace(workplace);
    }
    public void userMenu(){};
    public void mailBox(){};
    public void history() {}
    public void handlingRequests() {}
    public String fullName = getFirstName() + " " + getLastName();

    //**************************  (SETTERS)  ************************
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    public void setSalary() {
        System.out.print("Salary: ");
        salary = InputUtil.nextInt();
    }
    public void setEmployeeCode(int type, int bankCode, int branchCode) {
        employeeCounter++;
        bankCode++;
        branchCode++;
        employeeCode = type + "" + bankCode + branchCode + employeeCounter;
    }

    //**************************  (GETTERS)  ************************
    public String getWorkplace() {
        return workplace;
    }
    public long getSalary() {
        return salary;
    }
    public String getEmployeeCode() {
        return employeeCode;
    }
}