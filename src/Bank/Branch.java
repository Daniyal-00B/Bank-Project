package Bank;

import Account.Account;
import Person.BranchManager;
import Person.Employee;
import Person.Teller;

import java.util.ArrayList;

public class Branch {
    private int branchNumber;
    private BranchManager branchBoss;
    private Employee branchAssistant;
    ArrayList<Teller> tellerList = new ArrayList<>();
    ArrayList<Account> accountList = new ArrayList<>();


    public int getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(int branchNumber) {
        this.branchNumber = branchNumber;
    }

    public BranchManager getBranchBoss() {
        return branchBoss;
    }

    public void setBranchBoss(BranchManager branchBoss) {
        this.branchBoss = branchBoss;
    }

    public Employee getBranchAssistant() {
        return branchAssistant;
    }

    public void setBranchAssistant(Employee branchAssistant) {
        this.branchAssistant = branchAssistant;
    }

    public void displayCustomerList(){}
    public void addEmployee(){}
    public void removeEmployee(){}
    public void searchEmployee(){}
}
