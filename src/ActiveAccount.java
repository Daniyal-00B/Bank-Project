public class ActiveAccount extends Account{
    public ActiveAccount(int bankCode, int branchCode, long accountUniCode, String ownerName) {
        super(bankCode, branchCode, accountUniCode, "Active Account", ownerName);
    }
    public void bankOperation() {
        String choice;
        for (int i = 0; true ; i++){
            System.out.print("Enter Your Password: ");
            choice = InputUtil.next();
            if (choice.equals(getPassword())) break;
            System.out.println("Incorrect");
            if (i==2) return;
        }
        do {
            System.out.print("\n$$$$$$$$  " + getBankName() + "  $$$$$$$$\n1. Get Balance\n2. Money Transport" +
                             "\n3. Deposit\n4. Withdraw\nChoose a Number (0 for Exit): ");
            choice = InputUtil.next();
            switch (choice) {
                case "1" -> {
                    setBalance(getBalance()-0.1);
                    System.out.printf("\nYour Balance is %.1f$\n" , getBalance());
                }
                case "2" -> {
                    moneyTransport();
                }
                case "3" -> deposit();
                case "4" -> withdraw();
                case "0" -> {}
                default -> System.out.println("\nInvalid Choice");
            }
        } while (!(choice.equals("0")));
    }
}
