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
    public void closeAccount(int accountIndex) {
        Menu.customers.get((accountIndex/100)-1).accountList.remove(accountIndex%100);
        Menu.customers.get((accountIndex/100)-1).accountList.add(accountIndex%100, null);
        System.out.println("\nAccount Closed...");
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
                int employeeUniCode = (code%100)-1;
                String name = Menu.bankList.get(BankCode).branchList.get(BranchCode).employeeList.get(employeeUniCode).getFullName();
                System.out.println("\n" + name + " Removed From Employee List");
                long employeeCode = Menu.bankList.get(BankCode).branchList.get(BranchCode).employeeList.get(employeeUniCode).getEmployeeCode();
                for (int i=0 ; i<Menu.bankList.get(BranchCode).employeesList.size(); i++){
                    if (Menu.bankList.get(BranchCode).employeesList.get(i)==null) continue;
                    if (employeeCode == Menu.bankList.get(BranchCode).employeesList.get(i).getEmployeeCode()) {
                        Menu.bankList.get(BranchCode).employeesList.remove(i);
                        break;
                    }
                }
                Menu.bankList.get(BankCode).branchList.get(BranchCode).employeeList.remove(employeeUniCode);
                Menu.bankList.get(BankCode).branchList.get(BranchCode).employeeList.add(employeeUniCode,null);
            } else {
                System.out.println("\nEmployee NOT Removed...");
            }
        } catch (Exception _) {
            System.out.println("\nInvalid Code");
        }
    }
}
