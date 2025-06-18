public class Teller extends Employee{
    public Teller(String workPlace, int type, int bankCode, int branchCode){
        super(workPlace, type, bankCode, branchCode);
    }
    @Override
    public void userMenu(){
        System.out.println("\n$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^( Teller Menu )^^^^^^^^^^");
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
