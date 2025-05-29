package Person;
import Bank.Branch;
public class Employee extends Person {
    private int employeeCode;
    private long salary;
    private String workplace;
    private static int employeeCounter = 0;

    public Employee(String workplace, int type){
        super(type);
        setEmployeeCode();
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

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode() {
        employeeCode++;
        employeeCode = employeeCounter;
    }

//    public void printInfo(){
        public String fullName = getFirstName() + " " + getLastName();
    //}
}