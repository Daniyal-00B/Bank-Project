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

    public void createBranch(){}
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void displayBranchList(){
        for (int i=0; i<branchList.size();i++)
            System.out.println("["+ (i+1) + "] " + branchList.get(i).getBranchFullName());
    }
    public void displayEmployeeList(){
        for (int i=0;i<employeeList.size();i++)
            System.out.println("jsdks2");
    }
    public void displayCustomerList(){}

}