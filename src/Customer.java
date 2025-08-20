import java.util.ArrayList;
import java.util.Locale;

public class Customer extends Person{
    private int id;
    ArrayList<Account> accountList = new ArrayList<>();
    public int loanAccount;


    public Customer(int bankCode, int branchCode, int uniCode){
        super(3);
        setId(uniCode);
        loanAccount=0;
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
                    3. Close Account Request
                    4. Loan Request
                    5. Status
                    6. All My Accounts
                    7. Search Account
                    8. Loan Status
                    Choose a Number (0 for Logout):""" + " "
            );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> createAccount();
                case "3" -> closeAccount();
                case "4" -> loanRequest();
                case "5" -> statusReport();
                case "6" -> displayAccountList();
                case "7" -> searchAccount();
                case "8" -> loanStatus();
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
        System.out.print("\nEnter Account Number: ");
        String accountNumber = InputUtil.nextLine();
        int accountIndex = Menu.checkAccount(accountNumber);
        if (accountIndex==-1)
            System.out.println("\nInvalid Number Try Again");
        else {
            Account account = Menu.customers.get((accountIndex / 100) - 1).accountList.get(accountIndex % 100);
            if (!accountList.contains(account)) {
                System.out.println("\nInvalid Number Try Again");
                return;
            }
            System.out.print("\nYou Have " + account.getBalance() + "$ in This Account Are You Sure(Y/N)? ");
            String YorN = InputUtil.next();
            if (!YorN.equalsIgnoreCase("Y")) return;
            String massage = "Close Account Request From " + getFullName() + " With Code: " + accountIndex;
            Employee teller = Menu.chooseTeller(account.bankCode);
            if (teller==null) return;
            teller.addMail(massage);
            massage = "Your Close Account Request With Code " + accountIndex + " Sent to Bank";
            System.out.println(massage);
            addMail(massage);
            account.availability=false;
        }
    }
    public void displayAccountList(){
        if (accountList.isEmpty()) {
            System.out.println("You Have No Account");
            return;
        }
        int counter=0;
        for (int i=0 ; i<accountList.size() ; i++) {
            if (accountList.get(i)==null || !accountList.get(i).availability) continue;
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
    public void loanRequest(){
        System.out.print("\nPlease Check This Form\n---------------------------------------");
        customerInfo();
        System.out.print("Do You Confirm This Info (Y/N): ");
        String YorN = InputUtil.next();
        if (!YorN.equalsIgnoreCase("Y")) return;
        System.out.print("1. Regular Loan\n2. Active Loan\nChoose Loan Type: ");
        String loanType = InputUtil.next();
        if (!(loanType.equals("1") || loanType.equals("2"))) {
            System.out.println("\nInvalid Choice");
            return;
        }
        int count=0;
        for (Account i : accountList) {
            if (i==null) continue;
            if (loanType.equals("2"))
                if (!i.getType().equals("Active Account")) {
                    i.displayAccountInfo();
                    count++;
                }
            else if (i.getType().equals("Active Account")) {
                i.displayAccountInfo();
                count++;
                }
        }
        if (count==0) {
            System.out.println("\nYou Have No Account For This Type, Please Create an Account First");
            return;
        }
        System.out.print("\nEnter Account Number: ");
        String accountNumber = InputUtil.nextLine();
        int accountIndex = Menu.checkAccount(accountNumber);
        if (accountIndex==-1)
            System.out.println("\nInvalid Number Try Again");
        else {
            Account account = Menu.customers.get((accountIndex / 100) - 1).accountList.get(accountIndex % 100);
            if (!accountList.contains(account)) {
                System.out.println("\nInvalid Number Try Again");
                return;
            }
            System.out.print("Please Enter Amount of Loan ($): ");
            int amount = InputUtil.nextInt();
            String returnPeriod;
            do {
                System.out.print("Return Time (12, 24 or 36 months): ");
                returnPeriod = InputUtil.next();
            }while (!(returnPeriod.equals("12") || returnPeriod.equals("24") || returnPeriod.equals("36")));
            String massage = amount + "$ " + returnPeriod + " Months Loan Request From " + getFullName() + " With Code: " + accountIndex;
            Employee teller = Menu.chooseTeller(account.bankCode);
            if (teller==null) return;
            teller.addMail(massage);
            massage = "Your Loan Request With Code " + accountIndex + " Sent to Bank";
            System.out.println(massage);
            addMail(massage);
        }
    }
    public void customerInfo() {
        System.out.println("\n" + getFullName() + "\nAddress: " + getAddress()
                            + "\nID: " + getId() + "\nBirthday: " + getBirthday() + "\nNational Code: " + getNationalCode()
                            + "\n---------------------------------------");
    }
    public void addMail(String massage, int accountIndex) {
        String code = "Code " + accountIndex;
        for (int i=0; i<mails.size(); i++) {
            if (mails.get(i).contains(code)) {
                mails.remove(i);
                mails.add(massage);
                return;
            }
            else mails.add(massage);
        }
    }
    public void loanStatus() {
        if (loanAccount!=0) {
            Account account = Menu.customers.get((loanAccount / 100) - 1).accountList.get(loanAccount % 100);
            account.loan.loanInfo();
            System.out.println(account.getNumber());
            int payment = account.loan.getCurrentPayment();
            if (payment==0) System.out.println("You Have No Installment For This Month");
            else {
                System.out.print("You Have " + payment + "$ Installment For This Month\n" +
                        "Would You Like to Pay Your Installment (Y/N)? ");
                String yesOrNo = InputUtil.next();
                if (!(yesOrNo.equalsIgnoreCase("Y"))) return;
                boolean haveMoney = false;
                for (int i=0; i<accountList.size(); i++) {
                    if (accountList.get(i)==null || !accountList.get(i).availability || accountList.get(i).getBalance()-5 < payment) continue;
                    haveMoney = true;
                    System.out.println("[" + i + "] " + accountList.get(i).getBankName() + "\n" + accountList.get(i).getNumber());
                }
                if (!haveMoney) {
                    System.out.println("\nYou Don't Have Enough Money to Pay This Installment\nPlease Charge Your Accounts");
                    return;
                }
                System.out.print("Please Choose an Account [?]: ");
                int select;
                Account selectedAccount;
                try {
                    select = InputUtil.nextInt();
                    selectedAccount = accountList.get(select);
                }catch (Exception _) {
                    System.out.println("\nInvalid Choice");
                    return;
                }

                selectedAccount.setBalance((selectedAccount.getBalance()-payment));
                account.loan.reSetCurrentPayment();
                String massage = "\nYour Installment for Month " + Menu.time + " is Payed";
                addMail(massage);
                System.out.println(massage);
                if (account.loan.remainMonths<=0 && account.loan.getCurrentPayment()==0) {
                    System.out.println("""
                            
                            ****************************************
                            You Have Paid All Your Loan Installments
                            ****************************************""");
                    account.loan=null;
                    loanAccount=0;
                }
            }
        } else System.out.println("\nYou Don't Have Loan");
    }



    public void setId(int unicode) {
        id = 4000000 + unicode + 1;
    }
    public int getId() {
        return id;
    }

}