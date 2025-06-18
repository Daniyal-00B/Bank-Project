public class BranchManager extends Employee {
    public BranchManager(String workPlace, int bankCode, int branchCode){
        super(workPlace,1, bankCode, branchCode);
    }
    @Override
    public void userMenu(){
        System.out.println("\n$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^( Branch Manager Menu )^^^^^^^^^^");
            System.out.println("""
                    1. See Mail Box
                    2. Accept Requests
                    3. Receive Employee List
                    4. Close Account
                    Choose a Number (0 for Logout):""" + " "
                    );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> acceptRequests();
                case "3" -> receiveEmployeeList();
                case "4" -> closeAccount();
                case "0" -> {
                    System.out.println("You Are Logged Out...\n");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }while (true);
    }
    public void acceptRequests(){}
    public void receiveEmployeeList(){}
    public void closeAccount(){}
}
