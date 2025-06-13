import java.util.ArrayList;

public class Menu {
    public static ArrayList<Bank> bankList = new ArrayList<>();
    public static int bankCounter = 0;

    public static void MainMenu() {
        int choice;
        String Menu = """
                
                ***********(<<  BANK PROJECT  >>)***********
                1. Create Bank
                2. Login/Sign Up
                Choose a Number:""" + " ";

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
                System.out.println("\nCreating The First Branch for Bank");
                bankList.add(new Bank(bankName, bankCounter));
                bankCounter++;
                System.out.println("Bank Created!🎉\n");
            }
            case "0" -> {}
            default -> {
                int selectedBank = 0;
                try {
                    selectedBank = Integer.parseInt(choice);
                } catch (Exception _) {
                    System.out.println("Invalid Choice!🤬");
                }
                selectedBank -= 1;
                if (selectedBank < 0 || selectedBank >= bankList.size())
                    System.out.println("Your Selected Bank Does Not Exist");
                else
                    bankList.get(selectedBank).createBranch();
            }
        }
    }

    static void showAllBanks() {
        System.out.println("\n***** All Banks List *****");
        for (int i = 0; i < bankList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + bankList.get(i).getBankName());
        }
    }

    static void login_signup() {
        if (bankList.isEmpty()) {
            System.out.println("Please Create a Bank First");
            return;
        }
        System.out.print("Please Enter Your Code or Press + for Sign Up (0 for Exit): \n");
        for (Employee employee : bankList.getFirst().branchList.getFirst().employeeList) {
            System.out.println(employee.getEmployeeCode());
        }
        String choice = InputUtil.next();
        switch (choice) {
            case "+" -> signUp();
            case "0" -> {}
            default -> login(choice);
        }
    }

    static void signUp() {
        showAllBanks();
        System.out.print("Select a Bank: ");
        int selectedBank = InputUtil.nextInt() - 1;
        if (selectedBank < 0 || selectedBank >= bankList.size()) {
            System.out.println("Invalid Choice! Try Again");
            signUp();
        }
        bankList.get(selectedBank).displayBranchList();
        System.out.print("Please Select a Branch: ");
        int selectedBranch = InputUtil.nextInt() - 1;
        if (selectedBranch < 0 || selectedBranch >= bankList.get(selectedBank).branchList.size()) {
            System.out.println("Invalid Choice! Try Again");
            signUp();
        }
        System.out.print("\n[1] Employee\n[2] Customer\nPlease Select Your Role: ");
        int type;
        do {
            type = InputUtil.nextInt();
        } while (type != 1 && type != 2);
        if (type == 1) {
            String workPlace = bankList.get(selectedBank).getBankName();
            bankList.get(selectedBank).branchList.get(selectedBranch).addTeller(workPlace, 3, selectedBank, selectedBranch);
            bankList.get(selectedBank).branchList.get(selectedBranch).addEmployee(bankList.get(selectedBank).branchList.get(selectedBranch).getLastTeller());
        } else {
            System.out.println("customer sign up %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }

    static void login(String employeeCode) {
        String[] part = employeeCode.split("\\.");
        int employeeType = Integer.parseInt(part[0]);
        int employeeBank = Integer.parseInt(part[1]) - 1;
        int employeeBranch = Integer.parseInt(part[2]) - 1;
        int employeeCount = Integer.parseInt(part[3]) - 1;
        if (part.length == 4 &&
                employeeType < 3 && employeeType > 0 &&
                employeeBank < bankList.size() && employeeBank >= 0 &&
                employeeBranch < bankList.get(employeeBank).branchList.size() && employeeBranch >= 0 &&
                employeeCount < bankList.get(employeeBank).branchList.get(employeeBranch).employeeList.size() && employeeCount >= 0
        ) {
            Employee employee = bankList.get(employeeBank).branchList.get(employeeBranch).employeeList.get(employeeCount);
            if (employee.getEmployeeCode().equals(employeeCode)) {
                System.out.println("Hi " + employee.fullName);
                employee.userMenu();
            } else {
                System.out.println("invalid");
            }
        } else {
            System.out.println("invalid EmployeeCode");
        }
    }
}