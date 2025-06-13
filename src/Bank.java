import java.util.ArrayList;

public class Bank {
    private String bankName;
    private int bankCode;
    public ArrayList<Branch> branchList = new ArrayList<>();
    public ArrayList<Employee> employeeList = new ArrayList<>();
    public ArrayList<Customer> customerList = new ArrayList<>();

    public Bank(){}
    public Bank(String bankName, int bankCode) {
        setBankName(bankName);
        branchList.add(new Branch(bankName, bankCode));
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void createBranch(){
        System.out.println("New Branch Created!🎉");

        branchList.add(new Branch(getBankName(), bankCode));
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
        for (int i=0;i<employeeList.size();i++) {
            //System.out.println("[" + (i+1) + "] " + employeeList.get(i).fullName);
        }
    }
    public void displayCustomerList(){}

}