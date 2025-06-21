public abstract class Account {
    private String number;
    private String password;
    private double balance;
    private String type;
    private String bankName;

    public Account(int bankCode, int branchCode, long accountUniCode, String type){
        setType(type);
        setNumber(bankCode, branchCode, accountUniCode);
        setPassword();
        setBankName(bankCode);
        setBalance();
    }
    public void moneyTransport(){}
    public void deposit(){}
    public void withdraw(){}
    public void displayAccountInfo() {
        System.out.println("Account Info:\n" +
                bankName +
                "\nNumber: " + getNumber() +
                "\nBalance: " + getBalance() +
                "$\nType: " + getType() + "\n-----------------------------");
    }

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
    public void setType(String type) {
        this.type = type;
    }
    public void setBankName(int bankCode) {
        bankName = Menu.bankList.get(bankCode).getBankName();
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
}
