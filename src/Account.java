public abstract class Account {
    private String number;
    private long balance;
    private String type;

    public Account(){}
    public void moneyTransport(){}
    public void deposit(){}
    public void withdraw(){}

    //**************************  (SETTERS)  ************************
    public void setNumber(String number) {
        this.number = number;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public void setType(String type) {
        this.type = type;
    }

    //**************************  (SETTERS)  ************************
    public String getNumber() {
        return number;
    }
    public long getBalance() {
        return balance;
    }
    public String getType() {
        return type;
    }
}
