public class ShortTermAccount extends Account{
    private double sumOfBalance;
    int lastTimeProfit = 0;
    private RegularLoan loan;

    public ShortTermAccount(int bankCode, int branchCode, long accountUniCode, String ownerName) {
        super(bankCode, branchCode, accountUniCode, "Short Term Account", ownerName);
        sumOfBalance = 0;
    }
    public void setProfit(int time, int advanceTime) {
        while (advanceTime!=0) {
            time++;
            if (getBalance() > 100) {
                sumOfBalance += getBalance();
            }
            if ((time/12) > lastTimeProfit) {
                double percentageOfProfit = (sumOfBalance*5)/100;
                double balance = getBalance() + percentageOfProfit;
                setBalance(balance);
                sumOfBalance = 0;
                lastTimeProfit++;
            }
            advanceTime--;
        }
    }
}
