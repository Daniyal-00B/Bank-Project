package Person;

import Bank.Branch;

public class BranchManager extends Employee{


    public BranchManager(String firstName, String lastName, String birthday, long nationalCode, String address, String phoneNumber, int employeeCode, int salary, String workplace) {
        super(firstName, lastName, birthday, nationalCode, address, phoneNumber, employeeCode, salary, workplace);
    }

    //receive employee list
    public void closeAccount(){}
    public void acceptRequests(){}
}
