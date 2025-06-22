public class CurrentAccount extends Account {
    public CurrentAccount(int bankCode, int branchCode, long accountUniCode, String ownerName) {
        super(bankCode, branchCode, accountUniCode, "Current Account", ownerName);
    }
    public void bankOperation() {
        System.out.println("Current Account Operations");
    }
}
