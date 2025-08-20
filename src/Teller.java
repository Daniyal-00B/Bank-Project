public class Teller extends Employee{

    public Teller(String workPlace, int bankCode, int branchCode, int employeeUniCode){
        super(workPlace, 3, bankCode, branchCode, employeeUniCode);
    }
    @Override
    public void userMenu(){
        System.out.print("\n$$$$$$$$$$$$$$$ (Welcome Back) $$$$$$$$$$$$$$$");
        do {
            String choice;
            System.out.println("\n^^^^^^^^^^^^^^^^( Teller Menu )^^^^^^^^^^^^^^^^\n" + getWorkplace());
            System.out.print("""
                    
                    1. See Mail Box
                    2. Accept Requests
                    3. Search Employee
                    Choose a Number (0 for Logout):""" + " "
            );
            choice = InputUtil.next();
            switch (choice){
                case "1" -> mailBox();
                case "2" -> requests();
                case "3" -> searchEmployee();
                case "0" -> {
                    System.out.println("You Are Logged Out...\n");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }while (true);
    }
    public void requests() {
        if (mails.isEmpty()) {
            System.out.println("\nThere is No Request");
        } else {
            System.out.print("\n" + mails.getFirst());
            System.out.print("\nProcess This Request (Y/N)? ");
            String accept = InputUtil.next();
            if (!(accept.equalsIgnoreCase("Y"))) return;
            int sStart = mails.getFirst().indexOf(":")+2;
            int accountIndex = Integer.parseInt(mails.getFirst().substring(sStart));
            Account account = Menu.customers.get((accountIndex / 100) - 1).accountList.get(accountIndex % 100);
            char requestType = mails.getFirst().charAt(0);
            if (requestType=='C') {
                if (account.loan!=null) {
                    String massage = "This Account Has Loan, So Can NOT be Close!\nDate: " + Menu.time;
                    account.availability=true;
                    System.out.print("\n" + massage + "\nWould You Like to Add Some Explanation About This?\nMassage: ");
                    massage += "\n" + InputUtil.next();
                    Menu.customers.get((accountIndex / 100) - 1).addMail(massage, accountIndex);
                    mails.removeFirst();
                    return;
                }
                account.displayAccountInfo();
                System.out.print("\nThis Account Can Be Close\nAccept This Request (Y/N)? ");
                do {
                    accept = InputUtil.next();
                } while (!(accept.equalsIgnoreCase("N") || accept.equalsIgnoreCase("Y")));
                String massage;
                if (accept.equalsIgnoreCase("N")) {
                    massage = "Your Account Cancellation Request for Account\n" +
                            account.getNumber() + " Has Been Rejected\nDate: " + Menu.time;
                    account.availability=true;
                }
                else {
                    massage = "Your Account " + account.getNumber() + " Has Been Closed";
                    Menu.bankList.get(BankCode).branchList.get(BranchCode).getBranchManager().closeAccount(accountIndex);
                }
                Menu.customers.get((accountIndex / 100) - 1).addMail(massage, accountIndex);
                mails.removeFirst();
            }
            else {
                System.out.println("\nLoan Request From\n" + account.getOwnerName() + "\nFor Account: " + account.getNumber());
                System.out.print("Client Full Info:");
                Menu.customers.get((accountIndex / 100) - 1).customerInfo();
                System.out.print("\nAccept (Y/N)? ");
                do {
                    accept = InputUtil.next();
                } while (!(accept.equalsIgnoreCase("N") || accept.equalsIgnoreCase("Y")));
                if (accept.equalsIgnoreCase("Y")) {
                    Menu.bankList.get(BankCode).branchList.get(BranchCode).getBranchAssistant().addMail(mails.getFirst());
                    String massage = "Your Loan Request With Code " + accountIndex + " is Being Reviewed by the Bank's Assistant\nDate: " + Menu.time;
                    Menu.customers.get((accountIndex / 100) - 1).addMail(massage, accountIndex);
                    System.out.println("\nRequest Sent to Assistant for Review");
                    mails.removeFirst();
                }
                else {
                    String massage = "Your Loan Request Rejected by Bank\nDate: " + Menu.time;
                    Menu.customers.get((accountIndex / 100) - 1).addMail(massage, accountIndex);
                    mails.removeFirst();
                }
            }
        }
    }
}
