public class RegularLoan extends Loan{

    public RegularLoan(int amount, int paymentPeriod, Customer loanOwner) {
        super(amount, paymentPeriod, loanOwner);
        setPayment(amount, paymentPeriod);
    }

    public void setPayment (int amount, int period) {
        amount = (amount*23) / 100;
        loanPayment = amount/period;
    }
}
