import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI {

    private JFrame frame;
    private JPanel topPanel;
    private JLabel outputLabel;

    public static void RUN() {
        SwingUtilities.invokeLater(() -> new GUI().showGUI());
    }

    public void showGUI() {
        frame = new JFrame("Bank Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());


        ImageIcon backgroundIcon = new ImageIcon("background.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundLabel);


        topPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        topPanel.setBorder(new EmptyBorder(10, 40, 50, 40));
        topPanel.setOpaque(false);


        outputLabel = new JLabel(" ", SwingConstants.CENTER);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 40));
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setOpaque(false);

        backgroundLabel.add(topPanel, BorderLayout.SOUTH);
        backgroundLabel.add(outputLabel, BorderLayout.CENTER);

        showMainMenu();

        frame.setVisible(true);
    }


    private void showMainMenu() {
        topPanel.removeAll();

        showOutput("MAIN MENU");
        JButton btnCreateBank = new JButton("Create Bank");
        JButton btnLogin = new JButton("Login/Sign Up");
        JButton btnATM = new JButton("ATM");
        JButton btnAdvanceTime = new JButton("Advance Time");

        btnCreateBank.addActionListener(_ -> Menu.createBank());
        btnLogin.addActionListener(_ -> Menu.login_signup());
        btnATM.addActionListener(_ -> showATMMenu());
        btnAdvanceTime.addActionListener(_ -> handleAdvanceTime());

        topPanel.add(btnCreateBank);
        topPanel.add(btnLogin);
        topPanel.add(btnATM);
        topPanel.add(btnAdvanceTime);

        topPanel.revalidate();
        topPanel.repaint();
    }


    private void showATMMenu() {
        String number = JOptionPane.showInputDialog("Enter Your Account Number:");
        int accountIndex = Menu.checkAccount(number);
        if (accountIndex==-1) {
            showOutput("Invalid Number");
            return;
        }
        Account account = Menu.customers.get((accountIndex/100)-1).accountList.get(accountIndex%100);
        String password = JOptionPane.showInputDialog("Enter Your Password:");
        if (!account.getPassword().equals(password)) {
            showOutput("Wrong Password");
            return;
        }

        topPanel.removeAll();

        showOutput("ATM");
        JButton btnBalance = new JButton("Check Balance");
        JButton btnTransport = new JButton("Money Transport");
        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnBack = new JButton("Back");

        btnBalance.addActionListener(_ -> {
            account.setBalance(account.getBalance()-1);
            String massage = "You Have " + account.getBalance() + "$ in Your Account";
            showOutput(massage);
        });
        btnTransport.addActionListener(_ -> {
            String input = JOptionPane.showInputDialog("Destination Account Number:");
            int distAccountIndex = Menu.checkAccount(input);
            if (distAccountIndex==-1) {
                showOutput("Invalid Number");
                return;
            }
            Account distAccount = Menu.customers.get((accountIndex/100)-1).accountList.get(accountIndex%100);
            if (distAccount==account) {
                showOutput("This is Your Account");
                return;
            }
            String massage = "Transfer Amount (Maximum is " + (account.getBalance()-5) + "$):";
            String inputAmount = JOptionPane.showInputDialog(massage);
            try {
                int amount = Integer.parseInt(inputAmount);
                if (amount > account.getBalance()-5 || amount < 0) {
                    showOutput("Invalid Input");
                    return;
                }
                //show last agreement and final info
                account.setBalance(account.getBalance()-amount);
                distAccount.setBalance(distAccount.getBalance()+amount);
                massage = "Operation Successful Your Current Balance is " + account.getBalance() + "$";
                showOutput(massage);
            } catch (NumberFormatException _) {
                showOutput("Invalid Input");
            }
        });
        btnDeposit.addActionListener(_ -> {
            String massage = "Deposit Amount ($):";
            String input = JOptionPane.showInputDialog(massage);
            try {
                int amount = Integer.parseInt(input);
                if (amount < 0) {
                    showOutput("Invalid Input");
                    return;
                }
                account.setBalance(account.getBalance()+amount);
                massage = "Operation Successful Your Current Balance is " + account.getBalance() + "$";
                showOutput(massage);
            } catch (NumberFormatException _) {
                showOutput("Invalid Input");
            }
        });
        btnWithdraw.addActionListener(_ -> {
            String massage = "Withdraw Amount (Maximum is " + (account.getBalance()-5) + "$):";
            String input = JOptionPane.showInputDialog(massage);
            try {
                int amount = Integer.parseInt(input);
                if (amount > account.getBalance()-5 || amount < 0) {
                    showOutput("Invalid Input");
                    return;
                }
                account.setBalance(account.getBalance()-amount);
                massage = "Operation Successful Your Current Balance is " + account.getBalance() + "$";
                showOutput(massage);
            } catch (NumberFormatException _) {
                showOutput("Invalid Input");
            }
        });
        btnBack.addActionListener(_ -> showMainMenu());

        topPanel.add(btnBalance);
        topPanel.add(btnTransport);
        topPanel.add(btnDeposit);
        topPanel.add(btnWithdraw);
        topPanel.add(btnBack);

        topPanel.revalidate();
        topPanel.repaint();
    }

    private void handleAdvanceTime() {
        String input = JOptionPane.showInputDialog("Enter Number of Months to Advance:");
        try {
            int months = Integer.parseInt(input);
            if (months < 1) {
                showOutput("Invalid Input");
                return;
            }
            Menu.advanceTime(months);
            showOutput(months + " Months After Now");
        } catch (NumberFormatException e) {
            showOutput("Invalid Input");
        }
    }

    private void showOutput(String message) {
        outputLabel.setText(message);
    }
}
