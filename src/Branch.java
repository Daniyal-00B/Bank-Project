import java.util.ArrayList;

public class Branch extends Bank{
    private int branchNumber;
    private BranchManager branchManager;
    private AssistantManager assistantManager;
    private static int branchCount = 0;
    private String branchFullName;
    ArrayList<Teller> tellerList = new ArrayList<>();
    ArrayList<Account> accountList = new ArrayList<>();
    
    public Branch(String bankName, int bankCode){
        setBranchNumber();
        branchFullName = bankName + " Branch: " + branchNumber;
        setBranchManager(branchFullName, bankCode, getBranchNumber()-1);
        addEmployee(branchManager);
        setAssistantManager(branchFullName, bankCode, getBranchNumber()-1);
        addEmployee(assistantManager);
    }
    public void addTeller(String workPlace, int type, int bankCode, int branchCode){
        tellerList.add(new Teller(workPlace, type, bankCode, branchCode));
    }
    public void removeEmployee(){}
    public void searchEmployee(){}

    //**************************  (SETTERS)  ************************
    public void setBranchNumber() {
        branchCount++;
        branchNumber = branchCount;
    }
    public void setBranchManager(String workPlace, int bankCode, int branchCode) {
        branchManager = new BranchManager(workPlace, bankCode, branchCode);

    }
    public void setAssistantManager(String workPlace, int bankCode, int branchCode) {
        assistantManager = new AssistantManager(workPlace, bankCode, branchCode);
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
    public Teller getLastTeller(){
        return tellerList.getLast();
    }
}
