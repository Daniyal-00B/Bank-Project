import java.util.ArrayList;

public class Customer{
    private int id;
    ArrayList<Account> accountList = new ArrayList<>();
    // mail
    public void createAccount(){}
    public void closeAccount(){}
    public void displayAccountList(){}
    public void statusReport(){}
    public void searchAccount(){}
    public void loan(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}