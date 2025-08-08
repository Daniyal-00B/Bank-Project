public class ActiveLoan extends Loan {

    public ActiveLoan(int amount, int paymentPeriod, Customer loanOwner) {
        super(amount, paymentPeriod, loanOwner);
        setPayment(amount, paymentPeriod);
    }

    public void setPayment (int amount, int period) {
        amount = (amount*6) / 100;
        loanPayment = amount/period;
    }
}
