public class RegularLoan extends Loan{

    public RegularLoan(int amount, int paymentPeriod, Customer loanOwner) {
        super(amount, paymentPeriod, loanOwner);
        setPayment(amount, paymentPeriod);
    }

    public void setPayment (int amount, int period) {
        amount += ((amount*23) / 100);
        loanBasePayment = amount/period;
    }

    public void loanInfo() {
        System.out.println("\n" + getAmount() + "$ Regular Loan With 23% Loan Interest\nand "
                            + getPaymentPeriod() + " Months Payment Period for Account:");
    }

    @Override
    int lateFee() {
        return (getAmount()*6)/100;
    }
}
