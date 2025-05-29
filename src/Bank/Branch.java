package Bank;

import Account.Account;
import Person.BranchManager;
import Person.Employee;
import Person.Teller;

import java.util.ArrayList;

public class Branch {
    private int branchNumber;
    private BranchManager branchManager;
    private Employee branchAssistant;
    private static int branchCount = 0;
    
    public Branch(){
        setBranchNumber();
        setbranchManager();
        setBranchAssistant();
        
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

    public void setbranchManager() {
        branchManager = new BranchManager();
    }

    public Employee getBranchAssistant() {
        return branchAssistant;
    }

    public void setBranchAssistant() {
        
    }

    public void displayCustomerList(){}
    public void addEmployee(){}
    public void removeEmployee(){}
    public void searchEmployee(){}
}
