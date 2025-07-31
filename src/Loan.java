public class Loan {
    private int amount;
    private int paymentPeriod;
    private Customer loanOwner;


    public void setPaymentPeriod(int paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }
    public void setAmount(int amountOfLoan) {
        this.amount = amountOfLoan;
    }
    public void setLoanOwner (Customer loanOwner) {
        this.loanOwner = loanOwner;
    }

    public int getPaymentPeriod() {
        return paymentPeriod;
    }
    public int getAmount() {
        return amount;
    }
    public Customer getLoanOwner() {
        return loanOwner;
    }
}
