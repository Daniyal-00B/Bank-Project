import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BankGUI {

    private JLabel outputLabel;

    public static void RUN() {
        SwingUtilities.invokeLater(() -> new BankGUI().createAndShowGUI());
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Bank Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);


        ImageIcon backgroundIcon = new ImageIcon("background.jpg");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        topPanel.setBorder(new EmptyBorder(10, 40, 50, 40));
        topPanel.setOpaque(false);

        JButton btnCreateBank = new JButton("Create Bank");
        JButton btnLogin = new JButton("Login / Sign Up");
        JButton btnATM = new JButton("ATM");
        JButton btnAdvanceTime = new JButton("Advance Time");

        topPanel.add(btnCreateBank);
        topPanel.add(btnLogin);
        topPanel.add(btnATM);
        topPanel.add(btnAdvanceTime);

        outputLabel = new JLabel(" ", SwingConstants.CENTER);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 30));
        outputLabel.setForeground(Color.WHITE);
        outputLabel.setOpaque(false);

        btnCreateBank.addActionListener(e -> showOutput("Bank Created!"));
        btnLogin.addActionListener(e -> showOutput("Login / Sign Up selected"));
        btnATM.addActionListener(e -> showATMMenu());
        btnAdvanceTime.addActionListener(e -> handleAdvanceTime());

        backgroundLabel.add(topPanel, BorderLayout.SOUTH);
        backgroundLabel.add(outputLabel, BorderLayout.CENTER);

        frame.setContentPane(backgroundLabel);
        frame.setVisible(true);
    }

    private void handleAdvanceTime() {
        String input = JOptionPane.showInputDialog("Enter number of months to advance:");
        try {
            int months = Integer.parseInt(input);
            showOutput(months + " Months After Now");
        } catch (NumberFormatException e) {
            showOutput("Invalid number entered.");
        }
    }

    private void showATMMenu() {
        String accountNumber = JOptionPane.showInputDialog("Enter Your Account Number:");
        int accountIndex = Menu.checkAccount(accountNumber);
        if (accountIndex==-1)
            System.out.println("\nInvalid Number Try Again");
        else {
            Account account = Menu.customers.get((accountIndex/100)-1).accountList.get(accountIndex%100);
            account.bankOperation();
        }
    }

    private void showOutput(String message) {
        outputLabel.setText(message);
    }
}
