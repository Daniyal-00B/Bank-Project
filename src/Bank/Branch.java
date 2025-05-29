package Bank;

import Account.Account;
import Person.AssistantManager;
import Person.BranchManager;
import Person.Teller;

import java.util.ArrayList;

public class Branch {
    private int branchNumber;
    private BranchManager branchManager;
    private AssistantManager assistantManager;
    private static int branchCount = 0;
    
    public Branch(String bankName){
        setBranchNumber();
        String workPlace = bankName + " Branch: " + branchNumber;
        setBranchManager(workPlace);
        setAssistantManager(workPlace);
    }

    ArrayList<Teller> tellerList = new ArrayList<>();
    ArrayList<Account> accountList = new ArrayList<>();


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

    public void displayCustomerList(){}
    public void addEmployee(){}
    public void removeEmployee(){}
    public void searchEmployee(){}
}
