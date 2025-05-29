package Account;

public abstract class Account {
    private String number;
    private long balance;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void moneyTransport(){}
    public void deposit(){}
    public void withdraw(){}

}
