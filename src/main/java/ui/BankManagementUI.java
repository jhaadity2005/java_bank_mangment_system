package ui;

import model.Account;
import dao.AccountDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankManagementUI {

    private JFrame frame;
    private JTextField textAccountHolder;
    private JTextField textAccountNumber;
    private JTextField textInitialBalance;

    public BankManagementUI() {
        frame = new JFrame("Bank Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        JLabel labelAccountHolder = new JLabel("Account Holder:");
        textAccountHolder = new JTextField();
        
        JLabel labelAccountNumber = new JLabel("Account Number:");
        textAccountNumber = new JTextField();
        
        JLabel labelInitialBalance = new JLabel("Initial Balance:");
        textInitialBalance = new JTextField();
        
        JButton buttonCreateAccount = new JButton("Create Account");
        
        panel.add(labelAccountHolder);
        panel.add(textAccountHolder);
        panel.add(labelAccountNumber);
        panel.add(textAccountNumber);
        panel.add(labelInitialBalance);
        panel.add(textInitialBalance);
        
        buttonCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
        
        panel.add(buttonCreateAccount);
        
        frame.add(panel);
        frame.setVisible(true);
    }

    private void createAccount() {
        String holderName = textAccountHolder.getText();
        String accountNumber = textAccountNumber.getText();
        
        try {
            double initialBalance = Double.parseDouble(textInitialBalance.getText());
            
            AccountDAO accountDAO = new AccountDAO();
            Account newAccount = new Account(accountNumber, holderName, initialBalance);
            accountDAO.addAccount(newAccount);
            
            JOptionPane.showMessageDialog(frame, "Account created successfully!");
            clearFields();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid balance entered!");
        }
    }

    private void clearFields() {
        textAccountHolder.setText("");
        textAccountNumber.setText("");
        textInitialBalance.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankManagementUI::new);
    }
}
