import java.util.ArrayList;

public class Customer extends Person{
    private int id;
    ArrayList<Account> accountList = new ArrayList<>();

    public Customer(int bankCode, int branchCode, int uniCode){
        super(3);
        setId(uniCode);
        System.out.println("You Are Signed Up 🎉");
        System.out.println("""
                Please Fill This Form To Create Your First Account
                --------------------------------------------------""");
        createAccount();
    }
    public void userMenu(){
        System.out.println("\n$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^( Customer Menu )^^^^^^^^^^");
            System.out.println("""
                    1. See Mail Box
                    2. Create Account
                    3. Close Account
                    4. All My Accounts
                    5. Status
                    6. Search Account
                    7. Get Loan
                    Choose a Number (0 for Logout):""" + " "
            );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> createAccount();
                case "3" -> closeAccount();
                case "4" -> displayAccountList();
                case "5" -> statusReport();
                case "6" -> searchAccount();
                case "7" -> loan();
                case "0" -> {
                    System.out.println("You Are Logged Out...\n");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }while (true);
    }
    public void mailBox(){}
    public void createAccount(int bankCode, int branchCode){
        System.out.print("""
                
                Account Type
                1. Active Account
                2. Current Account
                3. Short Term Account
                Choose a Number (0 for Exit):""" + " ");
        int choice = InputUtil.nextInt();
        switch (choice){
            case 1 -> {}
            case 2 -> {}
            case 3 -> {}
            case 0 -> {}
            default -> {
                System.out.println("Invalid Choice! Try Again");
                createAccount(bankCode, branchCode);
            }
        }
    }
    public void createAccount(){
        System.out.println("""
        Please Fill This Form To Create an Account
        ------------------------------------------""");
        Menu.showAllBanks();
        System.out.print("Select a Bank: ");
        int selectedBank = InputUtil.nextInt() - 1;
        if (selectedBank < 0 || selectedBank >= Menu.bankList.size()) {
            System.out.println("Invalid Choice! Try Again");
        }
        Menu.bankList.get(selectedBank).displayBranchList();
        System.out.print("Please Select a Branch: ");
        int selectedBranch = InputUtil.nextInt() - 1;
        if (selectedBranch < 0 || selectedBranch >= Menu.bankList.get(selectedBank).branchList.size()) {
            System.out.println("Invalid Choice! Try Again");
        }
        createAccount(selectedBank, selectedBranch);
    }
    public void closeAccount(){}
    public void displayAccountList(){}
    public void statusReport(){}
    public void searchAccount(){}
    public void loan(){}

    public void setId(int unicode) {
        id = 4000 + unicode;
    }
    public int getId() {
        return id;
    }
}