package Bank;

import Person.BranchManager;
import Person.Customer;
import Person.Employee;
import java.util.ArrayList;

public class Bank {
    private String bankName;
    public ArrayList<Branch> branchList = new ArrayList<>();
    public ArrayList<Employee> employeeList = new ArrayList<>();
    public ArrayList<Customer> customerList = new ArrayList<>();

    public Bank(){}
    public Bank(String bankName) {
        this.bankName = bankName;
        branchList.add(new Branch(bankName));
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void createBranch(){
        branchList.add(new Branch(getBankName()));
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void displayBranchList(){
        for (int i=0; i<branchList.size();i++)
            System.out.println("["+ (i+1) + "] " + branchList.get(i).getBranchFullName());
    }
    public void displayEmployeeList(){
        System.out.println(employeeList.size());
        for (int i=0;i<employeeList.size();i++)
            System.out.println("[" + i + "] " + employeeList.get(i).fullName);
    }
    public void displayCustomerList(){}

}