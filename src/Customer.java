import java.util.ArrayList;
import java.util.Locale;

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
        createAccount(bankCode, branchCode);
    }
    public void userMenu(){
        System.out.print("    \n$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^^^^^( Customer Menu )^^^^^^^^^^^^^^\n");
            System.out.print("""
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

    public void createAccount(int bankCode, int branchCode){
        System.out.print("""
                
                ****( Account Type )****
                1. Active Account
                2. Current Account
                3. Short Term Account
                Choose a Number (0 for Exit):""" + " ");
        int choice = InputUtil.nextInt();
        long accountUniCode = (getId()%1000000)*100+accountList.size();
        switch (choice){
            case 1 -> accountList.add(new ActiveAccount(bankCode, branchCode, accountUniCode, getFullName()));
            case 2 -> accountList.add(new CurrentAccount(bankCode, branchCode, accountUniCode, getFullName()));
            case 3 -> accountList.add(new ShortTermAccount(bankCode, branchCode, accountUniCode, getFullName()));
            case 0 -> {}
            default -> {
                System.out.println("Invalid Choice! Try Again");
                createAccount(bankCode, branchCode);
            }
        }
        System.out.println("\nYour Account Successfully Created!\n");
        Menu.bankList.get(bankCode).customerList.add(getId());
        Menu.bankList.get(bankCode).branchList.get(branchCode).accountList.add(accountList.getLast());
        accountList.getLast().displayAccountInfo();
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
    public void closeAccount(){
        displayAccountList();
        System.out.print("\nWhich Account Do You Wanna Close (Choose in [] Number)? ");
        String choice = InputUtil.next();
        int selectedAccount;
        try {
            selectedAccount = Integer.parseInt(choice)-1;
            if (accountList.get(selectedAccount)==null) System.out.println("\nInvalid Choice");
        } catch (Exception _) {
            System.out.println("\nInvalid Choice");
            return;
        }
        if (accountList.get(selectedAccount).getBalance()!=0) {
            System.out.print("\nYou Have " + accountList.get(selectedAccount).getBalance() + "$ in This Account" +
                    " by Closing This Account Your Money Will be Gone!\n" +
                    "Continue? (Y or N): ");
            String yesOrNo = InputUtil.next();
            yesOrNo = yesOrNo.toUpperCase();
            if (yesOrNo.equals("Y")) {
                System.out.println("Your Selected Account Closed...");
            } else {
                System.out.println("Account Does not Closed");
                return;
            }
        }
        accountList.remove(selectedAccount);
        accountList.add(selectedAccount, null);
    }
    public void displayAccountList(){
        if (accountList.isEmpty()) {
            System.out.println("You Have No Account");
            return;
        }
        int counter=0;
        for (int i=0 ; i<accountList.size() ; i++) {
            if (accountList.get(i)==null) continue;
            System.out.println("\n[" + (i+1) + "]*************************");
            accountList.get(i).displayAccountInfo();
            counter++;
        }
        if (counter==0) System.out.println("\nYour Account List is Empty");
    }
    public void statusReport(){}
    public void searchAccount(){
        System.out.print("\nPlease Enter Your Account Bank Name or Account Type\nSearch: ");
        String search = InputUtil.nextLine().toLowerCase(Locale.ROOT);
        System.out.println();
        int resultCount = 0;
        if (search.contains("account")) {
            for (Account i : accountList) {
                if (i==null) continue;
                if (i.getType().equalsIgnoreCase(search.trim())) {
                    i.displayAccountInfo();
                    resultCount++;
                }
            }
        }
        else {
            for (Account i : accountList) {
                if (i.getBankName().equalsIgnoreCase(search.trim())) {
                    i.displayAccountInfo();
                    resultCount++;
                }
            }
        }
        if (resultCount==0) System.out.print("\nYou have No Account in This Type");
        System.out.println("\nNumber of Results: " + resultCount + "\n");
    }
    public void loan(){
        mails.add("Your Loan Request Send to Bank");
    }
    public void customerInfo() {
        System.out.println("\n" + getFullName() + "\nAddress: " + getAddress()
                            + "\nID: " + getId() + "\n---------------------------------------");
    }

    public void setId(int unicode) {
        id = 4000000 + unicode + 1;
    }
    public int getId() {
        return id;
    }
}