package Person;

public class Teller extends Employee{
    public Teller(){
        super("",3);
    }
    private int salary;

    public void acceptRequests(){}

    public long getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
