import java.util.ArrayList;

public class Bank {
    private String bankName;
    private int bankCode;
    public ArrayList<Branch> branchList = new ArrayList<>();
    public ArrayList<Integer> customerList = new ArrayList<>();

    public Bank(String bankName, int bankCode) {
        setBankName(bankName);
        this.bankCode = bankCode;
        System.out.println("Bank Created!🎉🎉🎉\n");
    }
    public void createBranch(){
        branchList.add(new Branch(getBankName(), bankCode, branchList.size()));
        System.out.println("New Branch Created!🎉");
    }
    public void displayBranchList(){
        System.out.println("\n***** Branches List *****");
        for (int i=0; i<branchList.size();i++)
            System.out.println("["+ (i+1) + "] " + branchList.get(i).getBranchFullName());
    }
    public void displayCustomerList(){
        for (Integer i : customerList) {
            Menu.customers.get(i%100-1).customerInfo();
        }
    }

    //**************************  (SETTERS)  ************************
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    //**************************  (GETTERS)  ************************
    public String getBankName() {
        return bankName;
    }
}