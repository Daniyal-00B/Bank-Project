public class ActiveAccount extends Account{
    private ActiveLoan loan;

    public ActiveAccount(int bankCode, int branchCode, long accountUniCode, String ownerName) {
        super(bankCode, branchCode, accountUniCode, "Active Account", ownerName);
    }
}
