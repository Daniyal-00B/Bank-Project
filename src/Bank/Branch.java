package Bank;

import Account.Account;
import Person.AssistantManager;
import Person.BranchManager;
import Person.Employee;
import Person.Teller;
import java.util.ArrayList;

public class Branch extends Bank{
    private int branchNumber;
    private BranchManager branchManager;
    private AssistantManager assistantManager;
    private static int branchCount = 0;
    private String branchFullName;
    ArrayList<Teller> tellerList = new ArrayList<>();
    ArrayList<Account> accountList = new ArrayList<>();
    
    public Branch(String bankName){
        setBranchNumber();
        branchFullName = bankName + " Branch: " + branchNumber;
        setBranchManager(branchFullName);
        addEmployee(branchManager);
        setAssistantManager(branchFullName);
        addEmployee(assistantManager);
    }



    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber() {
        branchCount++;
        branchNumber = branchCount;
    }

    public BranchManager getbranchManager() {
        return branchManager;
    }

    public void setBranchManager(String workPlace) {
        branchManager = new BranchManager(workPlace);

    }

    public AssistantManager getBranchAssistant() {
        return assistantManager;
    }

    public void setAssistantManager(String workPlace) {
        assistantManager = new AssistantManager(workPlace);
    }

    public void removeEmployee(){}
    public void searchEmployee(){}

    public String getBranchFullName() {
        return branchFullName;
    }

}
