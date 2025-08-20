public class ActiveLoan extends Loan {

    public ActiveLoan(int amount, int paymentPeriod, Customer loanOwner) {
        super(amount, paymentPeriod, loanOwner);
        setPayment(amount, paymentPeriod);
    }

    public void setPayment (int amount, int period) {
        amount += ((amount*4) / 100);
        loanBasePayment = amount/period;
    }

    @Override
    public void loanInfo() {
        System.out.println("\n" + getAmount() + "$ Active Loan With 4% Loan Interest\nand "
                + getPaymentPeriod() + " Months Payment Period for Account:");
    }

    @Override
    int lateFee() {
        return (getAmount()*8)/100;
    }
}
