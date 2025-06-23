public class BranchManager extends Employee {
    private int bankCode, branchCode;
    public BranchManager(String workPlace, int bankCode, int branchCode, int employeeUniCode){
        super(workPlace,1, bankCode, branchCode, employeeUniCode);
        this.bankCode = bankCode;
        this.branchCode = branchCode;
    }
    @Override
    public void userMenu(){
        System.out.print("\n$$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^^^( Branch Manager Menu )^^^^^^^^^^^^\n" + getWorkplace());
            System.out.print("""
                    
                    1. See Mail Box
                    2. Accept Requests
                    3. Receive Employee List
                    4. See Bank's Customer List
                    5. Close Account
                    6. Remove Employee
                    Choose a Number (0 for Logout):""" + " "
                    );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> acceptRequests();
                case "3" -> receiveEmployeeList();
                case "4" -> seeCustomerList();
                case "5" -> closeAccount();
                case "6" -> removeEmployee();
                case "0" -> {
                    System.out.println("You Are Logged Out...\n");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }while (true);
    }
    public void acceptRequests() {}
    public void receiveEmployeeList(){
        Menu.bankList.get(bankCode).branchList.get(branchCode).displayEmployeeList();
    }
    public void seeCustomerList() {
        Menu.bankList.get(bankCode).displayCustomerList();
    }
    public void closeAccount() {}
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
