package Person;

public class Teller extends Employee{
    public Teller(String workPlace, int type, int bankCode, int branchCode){
        super(workPlace, type, bankCode, branchCode);
    }

    public void acceptRequests(){}
}
