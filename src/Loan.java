public abstract class Loan {
    private int amount;
    private int paymentPeriod;
    private Customer loanOwner;
    protected int loanBasePayment;
    private int currentPayment;
    public int remainMonths;


    public Loan (int amount, int paymentPeriod, Customer loanOwner) {
        setAmount(amount);
        setLoanOwner(loanOwner);
        setPaymentPeriod(paymentPeriod);
        reSetCurrentPayment();
        remainMonths = getPaymentPeriod();
    }

    abstract int lateFee();
    public abstract void loanInfo();
    public void payment(int time, int advanceTime) {
        while (advanceTime!=0) {
            time++;
            if (currentPayment==0) currentPayment=loanBasePayment;
            else {
                int fee = lateFee();
                if (remainMonths<=0) currentPayment += fee;
                else {
                    currentPayment += (loanBasePayment + fee);
                    String massage = "You Have Not Paid the Installment for Month " + time
                            + " Therefore a " + fee + "$ Late Fee Applies to You\nDate: " + time;
                    getLoanOwner().addMail(massage);
                }
            }
            time++;
            remainMonths--;
            advanceTime--;
        }
    }

    public void setPaymentPeriod(int paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }
    public void setAmount(int amountOfLoan) {
        this.amount = amountOfLoan;
    }
    public void setLoanOwner (Customer loanOwner) {
        this.loanOwner = loanOwner;
    }
    public void reSetCurrentPayment() {
        currentPayment = 0;
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
    public int getCurrentPayment() {
        return currentPayment;
    }

}
