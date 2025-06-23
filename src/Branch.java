import java.util.ArrayList;

public class Branch{
    private int branchNumber;
    private BranchManager branchManager;
    private AssistantManager assistantManager;
    private String branchFullName;
    public ArrayList<Employee> employeeList = new ArrayList<>();
    ArrayList<Account> accountList = new ArrayList<>();
    
    public Branch(String bankName, int bankCode, int branchCode){
        setBranchNumber(branchCode);
        setBranchFullName(bankName);
        setBranchManager(branchFullName, bankCode, getBranchNumber());
        addEmployee(branchManager);
        setAssistantManager(branchFullName, bankCode, getBranchNumber());
        addEmployee(assistantManager);
    }
    public void addTeller(String workPlace, int bankCode, int branchCode){
        employeeList.add(new Teller(workPlace, bankCode, branchCode, employeeList.size()));
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void displayEmployeeList(){
        int numberOfEmployees = 0;
        System.out.println("\nBranch Assistant");
        for (int i=1;i<employeeList.size();i++) {
            if (employeeList.get(i)==null)
                continue;
            employeeList.get(i).employeeInfo();
            numberOfEmployees++;
        }
        System.out.println("Number of Employees: " + numberOfEmployees);
    }
    public void searchEmployee(){}

    //**************************  (SETTERS)  ************************
    public void setBranchNumber(int branchCode) {
        branchNumber = branchCode;
    }
    public void setBranchManager(String workPlace, int bankCode, int branchCode) {
        branchManager = new BranchManager(workPlace, bankCode, branchCode, employeeList.size());

    }
    public void setAssistantManager(String workPlace, int bankCode, int branchCode) {
        assistantManager = new AssistantManager(workPlace, bankCode, branchCode, employeeList.size());
    }
    public void setBranchFullName(String bankName) {
        branchFullName = bankName + " Branch " + (branchNumber+1);
    }

    //**************************  (GETTERS)  ************************
    public int getBranchNumber() {
        return branchNumber;
    }
    public BranchManager getbranchManager() {
        return branchManager;
    }
    public AssistantManager getBranchAssistant() {
        return assistantManager;
    }
    public String getBranchFullName() {
        return branchFullName;
    }
}
