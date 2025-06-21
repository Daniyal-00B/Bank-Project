public class Employee extends Person {
    private long employeeCode;
    private long salary;
    private String workplace;

    public Employee(String workplace, int type, int bankCode, int branchCode, int employeeUniCode) {
        super(type);
        setEmployeeCode(type, bankCode, branchCode, employeeUniCode);
        setSalary();
        setWorkplace(workplace);
    }
    public void userMenu(){};
    public void history() {}
    public void handlingRequests() {}
    public void employeeInfo() {
        System.out.println(getFirstName() + " " + getLastName() +
                "\nAddress: " + getAddress() + "\nCode: " + getEmployeeCode() +
                "\n-----------------------------------------------");
    }


    //**************************  (SETTERS)  ************************
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    public void setSalary() {
        System.out.print("Salary: ");
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