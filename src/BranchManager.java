public class BranchManager extends Employee {

    public BranchManager(String workPlace, int bankCode, int branchCode, int employeeUniCode){
        super(workPlace,1, bankCode, branchCode, employeeUniCode);
    }
    @Override
    public void userMenu(){
        System.out.print("\n$$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^^^( Branch Manager Menu )^^^^^^^^^^^^\n" + getWorkplace());
            System.out.print("""
                    
                    1. See Mail Box
                    2. Requests
                    3. See Employee List
                    4. See Customer List
                    5. Search Employee
                    6. Remove Employee
                    Choose a Number (0 for Logout):""" + " "
                    );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> requests();
                case "3" -> receiveEmployeeList();
                case "4" -> seeCustomerList();
                case "5" -> searchEmployee();
                case "6" -> removeEmployee();
                case "0" -> {
                    System.out.println("You Are Logged Out...\n");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }while (true);
    }
    public void requests() {
        if (mails.isEmpty()) {
            System.out.println("\nThere is No Request");
        } else {
            mails.getFirst();
        }
    }
    public void receiveEmployeeList(){
        Menu.bankList.get(BankCode).branchList.get(BranchCode).displayEmployeeList();
    }
    public void seeCustomerList() {
        Menu.bankList.get(BankCode).displayCustomerList();
    }
    public void closeAccount() {
        System.out.print("\nEnter Account Number to Close: ");
        String accountNumber = InputUtil.nextLine();
        int accountIndex = Menu.checkAccount(accountNumber);
        if (accountIndex==-1)
            System.out.println("\nInvalid Number Try Again");
        else {
            Account account = Menu.customers.get((accountIndex/100)-1).accountList.get(accountIndex%100);
            for (int i=0;  i<Menu.bankList.get(BankCode).branchList.get(BranchCode).accountList.size(); i++) {
                if (Menu.bankList.get(BankCode).branchList.get(BranchCode).accountList.get(i).getNumber().equals(account.getNumber())) {
                    System.out.println("\nAccount Owner: " + Menu.bankList.get(BankCode).branchList.get(BranchCode).accountList.get(i).getOwnerName());
                    Menu.bankList.get(BankCode).branchList.get(BranchCode).accountList.get(i).displayAccountInfo();
                    System.out.print("Close This Account? (Y/N): ");
                    String accept = InputUtil.next();
                    if (!(accept.equalsIgnoreCase("Y"))) {
                        System.out.println("Account Does not Closed");
                        return;
                    }
                    Menu.customers.get((accountIndex/100)-1).accountList.remove(accountIndex%100);
                    Menu.customers.get((accountIndex/100)-1).accountList.add(accountIndex%100, null);
                    Menu.bankList.get(BankCode).branchList.get(BranchCode).accountList.remove(i);
                    System.out.println("\nAccount Closed...");
                    return;
                }
            }
            System.out.println("\nThe Account Does Not Exist in This Branch");
        }
    }
    public void removeEmployee() {
        receiveEmployeeList();
        System.out.print("\nEnter an Employee Code to Remove: ");
        int code;
        try {
            code = Integer.parseInt(InputUtil.next());
            System.out.print("Are You Sure? (Y/N): ");
            String accept = InputUtil.next();
            if (accept.equalsIgnoreCase("Y")) {
                code%=1000000;
                int bankCode = (code/10000)-1;
                code%=10000;
                int branchCode = (code/100)-1;
                int employeeUniCode = (code%100)-1;
                String name = Menu.bankList.get(bankCode).branchList.get(branchCode).employeeList.get(employeeUniCode).getFullName();
                System.out.println("\n" + name + " Removed From Employee List");
                Menu.bankList.get(bankCode).branchList.get(branchCode).employeeList.remove(employeeUniCode);
                Menu.bankList.get(bankCode).branchList.get(branchCode).employeeList.add(employeeUniCode,null);
            } else {
                System.out.println("\nEmployee NOT Removed...");
            }
        } catch (Exception _) {
            System.out.println("\nInvalid Code");
        }
    }
}
