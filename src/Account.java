public abstract class Account {
    private String number;
    private String password;
    private double balance;
    private String type;
    private String bankName;
    private String ownerName;
    public int bankCode, branchCode;

    public Account(int bankCode, int branchCode, long accountUniCode, String type, String ownerName){
        setType(type);
        setNumber(bankCode, branchCode, accountUniCode);
        setPassword();
        setBankName(bankCode);
        setBalance();
        setOwnerName(ownerName);
        this.bankCode = bankCode;
        this.branchCode = branchCode;
    }
    public void moneyTransport() {
        System.out.print("\nEnter Destination Account Number: ");
        String accountNumber = InputUtil.nextLine();
        int accountIndex = Menu.checkAccount(accountNumber);
        if (accountIndex==-1)
            System.out.println("\nInvalid Number Try Again");
        else {
            Account distAccount = Menu.customers.get((accountIndex/100)-1).accountList.get(accountIndex%100);
            if (distAccount.getNumber().equals(getNumber())) {
                System.out.println("\nThis is Your Account Number😒");
                return;
            }
            double transferAmount;
            do {
                System.out.print("Transfer Amount ($): ");
                transferAmount = InputUtil.nextDouble();
                if (transferAmount <= getBalance()-5 && transferAmount > 0) break;
                System.out.println("Maximum Transfer Amount is " + (getBalance()-5) + "$");
            } while (true);
            System.out.println("\nSource Account:\n   " + getBankName() + "\n   " + getNumber()
                             + "\nDestination Account:\n   " + distAccount.getBankName() + "\n   " + distAccount.getOwnerName()
                             + "\n   " + distAccount.getNumber());
            System.out.print("Continue? (Y/N): ");
            String accept = InputUtil.next();
            if (accept.equalsIgnoreCase("Y")) {
                setBalance(getBalance()-transferAmount);
                distAccount.setBalance(distAccount.getBalance()+transferAmount);
                setBalance(getBalance()-0.1);
                System.out.printf("\nMoney Successfully Transferred\nYour Remaining Balance is %.1f$\n" , getBalance());
            }
            else {
                System.out.println("\nMoney Transfer Cancelled...");
            }
        }
    }
    public void deposit() {}
    public void withdraw() {}
    public void displayAccountInfo() {
        System.out.println("Account Info:\n" +
                bankName +
                "\nNumber: " + getNumber() +
                "\nBalance: " + getBalance() +
                "$\nType: " + getType() + "\n-----------------------------");
    }
    abstract void bankOperation();

    //**************************  (SETTERS)  **************************
    public void setNumber(int bankCode, int branchCode, long accountUniCode) {
        number = (bankCode+1001) + " " + (branchCode+1001) + " " + getType().length()*493 + " " + (accountUniCode+1001);
    }
    public void setPassword() {
        do {
            System.out.print("Please Choose a 4 Digit Password (0-9): ");
            password = InputUtil.next();
        }while (password.length()!=4);
    }
    public void setBalance() {
        System.out.print("Please Charge Your Account ($): ");
        balance = InputUtil.nextInt();
    }
    public void setBalance(double money) {
        balance = money;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setBankName(int bankCode) {
        bankName = Menu.bankList.get(bankCode).getBankName();
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    //**************************  (GETTERS)  **************************
    public String getNumber() {
        return number;
    }
    public String getPassword() {
        return password;
    }
    public double getBalance() {
        return balance;
    }
    public String getType() {
        return type;
    }
    public String getBankName() {
        return bankName;
    }
    public String getOwnerName() {
        return ownerName;
    }
}
