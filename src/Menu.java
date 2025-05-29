import Bank.Bank;

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
                case 1 -> System.out.println(" ");
                case 2 -> {
                    System.out.print("Enter the Bank Name: ");
                    scanner.nextLine();
                    String bankName = scanner.nextLine();
                    bankList.add(new Bank(bankName));
                    System.out.println("Bank Created!🎉\n");
                }
                case 0 -> System.out.println("Program Ended...");
                default -> System.out.println("Invalid Choice!");
            }
        }while (choice != 0);
        scanner.close();
    }


}
