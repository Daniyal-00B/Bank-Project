package Bank;

import Person.Customer;
import Person.Employee;
import java.util.ArrayList;

public class Bank {
    private String bankName;
    ArrayList<Branch> branchList = new ArrayList<>();
    ArrayList<Employee> employeeList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void createBranch(){}
    public void addEmployee(){}
    public void displayBranchList(){}
    public void displayCustomerList(){}

}