package Person;


import Bank.*;


import java.util.Scanner;

public class BranchManager extends Employee  {
    Scanner scanner = new Scanner(System.in);

    public BranchManager(String workPlace, int bankCode, int branchCode){
        super(workPlace,1, bankCode, branchCode);
    }

    public void deleteEmployee(Bank bank){
        System.out.println(bank.employeeList);
        System.out.println("Enter syntax: ");
        bank.employeeList.get(scanner.nextInt()).resetEmployee();
        System.out.println("you delete it");

    }
    //receive employee list
    public void closeAccount(){}
    public void acceptRequests(){}
}
