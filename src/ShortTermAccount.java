public class ShortTermAccount extends Account{
    public ShortTermAccount(int bankCode, int branchCode, long accountUniCode, String ownerName) {
        super(bankCode, branchCode, accountUniCode, "Short Term Account", ownerName);
    }
    public void bankOperation() {
        System.out.println("Short Term Account Operations");
    }
}
