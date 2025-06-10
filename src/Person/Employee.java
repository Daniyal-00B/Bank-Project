package Person;

public class Employee extends Person {
    private long employeeCode;
    private long salary;
    private String workplace;
    private static int employeeCounter = 0;

    public Employee(String workplace, int type, int bankCode, int branchCode){
        super(type);
        setEmployeeCode(type, bankCode, branchCode);
        setSalary();
        setWorkplace(workplace);
    }

    // mail
    public void history(){}
    public void handlingRequests(){}

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary() {
        System.out.print("Salary: ");
        salary = scanner.nextInt();
    }

    public long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int type, int bankCode, int branchCode) {
        employeeCounter++;
        bankCode++;
        branchCode++;
        employeeCode = ((type*10+bankCode)*10+branchCode)*10+employeeCounter;
    }

    //    public void printInfo(){
        public String fullName = getFirstName() + " " + getLastName();
    //}

    public void resetEmployee(){
        this.workplace = "";
        this.salary = 0;
        this.employeeCode = 0;
    }
}