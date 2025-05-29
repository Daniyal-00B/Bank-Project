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
            for (int i = 0; i < bankList.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + bankList.get(i).getBankName());
            }
            System.out.print("Select A Bank: ");
            int select = (scanner.nextInt())-1;
            Bank selectedBank = bankList.get(select);
            selectedBank.displayBranchList();
            System.out.print("Select a Branch: ");
            select = (scanner.nextInt())-1;
            System.out.println("Welcome to " + selectedBank.branchList.get(select).getBranchFullName());
            System.out.println("[1] Employee \n[2] Customer\n");
            System.out.print("Select Your Role: ");
            select = scanner.nextInt();
            if(select==1) {
                System.out.println("Enter Your Employee Code: ");
                int employeeCode = scanner.nextInt();
//                Bank.login(employeeCode);
            }
            if(select==2) {
                System.out.print("Enter Your National Code: ");
                long nationalCode = scanner.nextLong();
//                Customer.login(nationalCode);

            }
        }else {
            System.out.println("Bank List is Empty!");
        }
    }
}

    static void createBank(){
        System.out.print("Enter the Bank Name: ");
        scanner.nextLine();
        String bankName = scanner.nextLine();
        bankList.add(new Bank(bankName));
        System.out.println("Bank Created!🎉\n");
        bankList.getFirst().displayEmployeeList();
    }
}
