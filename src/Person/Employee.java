package Person;
import Bank.Branch;
public class Employee extends Person {
    private int employeeCode;
    private int salary;
    private String workplace;

    public Employee(String firstName, String lastName, String birthday, long nationalCode, String address, String phoneNumber, int employeeCode, int salary, String workplace) {
        super(firstName, lastName, birthday, nationalCode, address, phoneNumber);
        setEmployeeCode(employeeCode);
        setSalary(salary);
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }
}