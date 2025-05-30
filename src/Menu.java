import Bank.Bank;
import Person.Customer;
import Person.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static ArrayList<Bank> bankList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void MainMenu(){

        int choice;
        String Menu = """
                
                ***********(<<  BANK PROJECT  >>)***********
                1. Enter Bank
                2. Create Bank
                Choose a Number:""" + " ";

        do {
            System.out.print(Menu);
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> enterBank();
                case 2 -> createBank();
                case 0 -> System.out.println("Program Ended...");
                default -> System.out.println("Invalid Choice!");
            }
        }while (choice != 0);
        scanner.close();
    }
    static void enterBank(){
    {
        if (!bankList.isEmpty()) {
            showAllBanks();
            System.out.print("Select A Bank: ");
            int select = (scanner.nextInt()) - 1;
            int bankCode = select;
            Bank selectedBank = bankList.get(select);
            System.out.println("\n***** Branch List *****");
            selectedBank.displayBranchList();
            System.out.print("Select a Branch: ");
            select = (scanner.nextInt()) - 1;
            int branchCode = select;
            String branchFullName = selectedBank.branchList.get(select).getBranchFullName();
            System.out.println("\nWelcome to " + branchFullName);
            System.out.println("[1] Employee \n[2] Customer");
            System.out.print("Select Your Role: ");
            selectRole(branchFullName,bankCode,branchCode);

        }else {
            System.out.println("Bank List is Empty!");
        }
    }
}

    static void showAllBanks(){
        System.out.println("\n***** All Banks List *****");
        for (int i = 0; i < bankList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + bankList.get(i).getBankName());
        }
    }

    static void createBank(){
        String choice = "+";
        if (!bankList.isEmpty()){
            showAllBanks();
            System.out.print("Select a Bank for  Create a Branch or Enter (+) Symbol for Add (0 for Exit): ");
            choice = scanner.next();
        }
        switch (choice){
            case "+" -> {
                System.out.print("Enter the Bank Name: ");
                scanner.nextLine();
                String bankName = scanner.nextLine();
                bankList.add(new Bank(bankName));
                System.out.println("Bank Created!🎉\n");
            }
            case "0" -> {}
            default -> {
                int selectedBank=0;
                try {
                    selectedBank = Integer.parseInt(choice);
                }
                catch (Exception _){
                    System.out.println("Invalid Choice!🤬");
                }
                selectedBank-=1;
                if (selectedBank < 0 || selectedBank > bankList.size())
                    System.out.println("Your Selected Dose Not Exist");
                else
                    bankList.get(selectedBank).createBranch();
            }
        }
    }

    static void selectRole(String workPlace, int bankCode, int branchCode){
        int select = scanner.nextInt();
        switch (select){
            case 1 -> {
                System.out.println("Enter Your Employee Code: ");
                String employeeCode = scanner.nextLine();
                if(employeeCode.isEmpty()){
                    bankList.get(bankCode).branchList.get(branchCode).addEmployee(new Employee(workPlace,3));
                }
//                Bank.login(employeeCode);
            }
            case 2 ->{
                System.out.print("Enter Your National Code: ");
                long nationalCode = scanner.nextLong();
//                Customer.login(nationalCode);
            }
            default -> {
                System.out.println("Invalid choice! try again");
                selectRole(workPlace,bankCode,branchCode);
            }
        }
    }
}
