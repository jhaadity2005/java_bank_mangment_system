package ui;

import model.Transaction;
import dao.TransactionDAO;
import dao.AccountDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionUI {

    private JFrame frame;
    private JTextField textAccountId;
    private JTextField textAmount;

    public TransactionUI() {frame = new JFrame("Transaction Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel labelAccountId = new JLabel("Account ID:");
        textAccountId = new JTextField();

        JLabel labelAmount = new JLabel("Amount:");
        textAmount = new JTextField();

        JButton buttonDeposit = new JButton("Deposit");
        JButton buttonWithdraw = new JButton("Withdraw");

        panel.add(labelAccountId);
        panel.add(textAccountId);
        
        panel.add(labelAmount);
        panel.add(textAmount);

        buttonDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performTransaction("DEPOSIT");
            }
        });

        buttonWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performTransaction("WITHDRAW");
            }
        });

        panel.add(buttonDeposit);
        panel.add(buttonWithdraw);

        frame.add(panel);
        
        frame.setVisible(true);
    }

    private void performTransaction(String type) {
        int accountId;
        
        try {
            accountId = Integer.parseInt(textAccountId.getText());
            double amount = Double.parseDouble(textAmount.getText());

            AccountDAO accountDAO = new AccountDAO();
            TransactionDAO transactionDAO = new TransactionDAO();

            if (type.equals("WITHDRAW")) {
                Account account = accountDAO.getAccountById(accountId);
                account.withdraw(amount);
                accountDAO.updateAccount(account);
            } else if (type.equals("DEPOSIT")) {
                Account account = accountDAO.getAccountById(accountId);
                account.deposit(amount);
                accountDAO.updateAccount(account);
            }

            Transaction transaction = new Transaction(accountId, type, amount);
            transactionDAO.addTransaction(transaction);

            JOptionPane.showMessageDialog(frame, type + " successful!");

            clearFields();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid input!");
            
       } catch (IllegalArgumentException e) {
           JOptionPane.showMessageDialog(frame, e.getMessage());
       }
     }

     private void clearFields() {
         textAccountId.setText("");
         textAmount.setText("");
     }

     public static void main(String[] args) {
         SwingUtilities.invokeLater(TransactionUI::new);
     }
}