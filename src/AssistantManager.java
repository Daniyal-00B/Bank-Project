public class AssistantManager extends Employee{
    public AssistantManager(String workPlace, int bankCode, int branchCode, int employeeUniCode){
        super(workPlace, 2, bankCode, branchCode, employeeUniCode);
    }
    @Override
    public void userMenu(){
        System.out.print("\n$$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^( Assistant Manager Menu )^^^^^^^^^^\n" + getWorkplace());
            System.out.print("""
                    
                    1. See Mail Box
                    2. Accept Requests
                    3. Search Employee
                    Choose a Number (0 for Logout):""" + " "
            );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> requests();
                case "3" -> searchEmployee();
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
            System.out.print("\nProcess This Request (Y/N)? ");
            String accept = InputUtil.next();
            if (!(accept.equalsIgnoreCase("Y"))) return;
            int sStart = mails.getFirst().indexOf(":")+2;
            int accountIndex = Integer.parseInt(mails.getFirst().substring(sStart));
            Customer customer = Menu.customers.get((accountIndex / 100) - 1);
            boolean isLoanAvailable = true;
            for (Account i : customer.accountList) {
                if (i!=null) {
                    isLoanAvailable = false;
                    return;
                }
            }
            if (!isLoanAvailable) {
                System.out.println();
            }
        }
    }
}
