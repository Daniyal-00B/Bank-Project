public class CurrentAccount extends Account {
    private RegularLoan loan;

    public CurrentAccount(int bankCode, int branchCode, long accountUniCode, String ownerName) {
        super(bankCode, branchCode, accountUniCode, "Current Account", ownerName);
    }
}
