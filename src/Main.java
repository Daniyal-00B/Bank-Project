import Bank.Bank;
import Bank.Branch;
import Person.BranchManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Bank CentralBank = new Bank("centralBank");
        BranchManager TehranBranchBoss = new BranchManager();
        Branch TehranBranch = new Branch();
        Branch QomBranch = new Branch();

        Menu.MainMenu();

    }
}
