package Person;
import Bank.Branch;
public class Employee {
    private int employeeCode;
    private int salary;
    private Branch workplace;
    // mail
    public void history(){}
    public void handlingRequests(){}

    public Branch getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Branch workplace) {
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