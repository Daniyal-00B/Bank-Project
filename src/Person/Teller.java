package Person;

public class Teller extends Employee{
    private int salary;

    public void acceptRequests(){}

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
