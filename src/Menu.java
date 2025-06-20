import java.util.ArrayList;

public class Menu {
    public static ArrayList<Bank> bankList = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void MainMenu() {
        int choice;
        String Menu = """
                
                ***********(<<  BANK PROJECT  >>)***********
                1. Create Bank
                2. Login/Sign Up
                Choose a Number (0 for Exit):""" + " ";

        do {
            System.out.print(Menu);
            choice = InputUtil.nextInt();
            switch (choice) {
                case 1 -> createBank();
                case 2 -> login_signup();
                case 0 -> System.out.println("Program Ended...");
                default -> System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
        InputUtil.closeScanner();
    }

    static void createBank() {
        String choice = "+";
        if (!bankList.isEmpty()) {
            showAllBanks();
            System.out.print("Select a Bank for Create a Branch or Enter (+) Symbol for Add (0 for Exit): ");
            choice = InputUtil.next();
        }
        switch (choice) {
            case "+" -> {
                System.out.print("Enter the Bank Name: ");
                String bankName;
                do {
                    bankName = InputUtil.nextLine();
                    if (bankName.isEmpty()) System.out.print("Bank Name Can Not Be Empty!\nEnter the Bank Name: ");
                } while (bankName.isEmpty());
                int bankUniCode = bankList.size();
                bankList.add(new Bank(bankName, bankUniCode));
                System.out.println("\nCreating The First Branch for Bank");
                bankList.get(bankUniCode).createBranch();
            }
            case "0" -> {}
            default -> {
                int selectedBank = 0;
                try {
                    selectedBank = Integer.parseInt(choice);
                } catch (Exception _) {
                    System.out.println("Invalid Choice!");
                }
                selectedBank -= 1;
                if (selectedBank < 0 || selectedBank >= bankList.size())
                    System.out.println("Your Selected Bank Does Not Exist");
                else
                    bankList.get(selectedBank).createBranch();
            }
        }
    }

    static void login_signup() {
        if (bankList.isEmpty()) {
            System.out.println("Please Create a Bank First");
            return;
        }
        System.out.print("Please Enter Your Code or Press + for Sign Up (0 for Exit): \n");
        //############################################ TEST #####################################################
        for (Employee employee : bankList.get(1).branchList.getFirst().employeeList) {
            System.out.println(employee.getEmployeeCode());
        }
        //############################################ TEST #####################################################
        String choice = InputUtil.next();
        switch (choice) {
            case "+" -> signUp();
            case "0" -> {}
            default -> login(choice);
        }
    }

    static void login(String input) {
        int code;
        try {
            code = Integer.parseInt(input);
        } catch (Exception _) {
            System.out.println("Code Must Be Number!");
            return;
        }
        Person user;
        int type = code/1000000;
        try {
            if (type == 4){
                user = customers.get(code%100);
            }
            else {
                code%=1000000;
                int bankCode = (code/10000)-1;
                code%=10000;
                int branchCode = (code/100)-1;
                int employeeUniCode = code%100;
                user = bankList.get(bankCode).branchList.get(branchCode).employeeList.get(employeeUniCode);
            }
        } catch (Exception _) {
            System.out.println("Incorrect Code! Try Again");
            return;
        }
        user.userMenu();
    }

    static void signUp() {
        showAllBanks();
        System.out.print("Select a Bank: ");
        int selectedBank = InputUtil.nextInt() -1;
        if (selectedBank < 0 || selectedBank >= bankList.size()) {
            System.out.println("Invalid Choice! Try Again");
        }
        bankList.get(selectedBank).displayBranchList();
        System.out.print("Please Select a Branch: ");
        int selectedBranch = InputUtil.nextInt() -1;
        if (selectedBranch < 0 || selectedBranch >= bankList.get(selectedBank).branchList.size()) {
            System.out.println("Invalid Choice! Try Again");
        }
        System.out.print("\n[1] Employee\n[2] Customer\nPlease Select Your Role: ");
        int type;
        do {
            type = InputUtil.nextInt();
        } while (type != 1 && type != 2);
        if (type == 1) {
            String workPlace = bankList.get(selectedBank).getBankName();
            bankList.get(selectedBank).branchList.get(selectedBranch).addTeller(workPlace, selectedBank, selectedBranch);
        } else {
            int uniCode = customers.size();
            customers.add(new Customer(selectedBank, selectedBranch, uniCode));
        }
    }
    public static void showAllBanks() {
        System.out.println("\n***** All Banks List *****");
        for (int i = 0; i < bankList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + bankList.get(i).getBankName());
        }
    }
}