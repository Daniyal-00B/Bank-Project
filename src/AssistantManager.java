public class AssistantManager extends Employee{
    public AssistantManager(String workPlace, int bankCode, int branchCode){
        super(workPlace, 2, bankCode, branchCode);
    }
    @Override
    public void userMenu(){
        System.out.println("\n$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^( Assistant Manager Menu )^^^^^^^^^^");
            System.out.println("""
                    1. See Mail Box
                    2. Accept Requests
                    Choose a Number (0 for Logout):""" + " "
            );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> acceptRequests();
                case "0" -> {
                    System.out.println("You Are Logged Out...\n");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }while (true);
    }
    public void acceptRequests(){}
}
