/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package letschat;
import javax.swing.*;
/**
 *
 * @author katlego
 */
public class LetsChat {
    private static AccountCreate account = new AccountCreate();
    private static LoginLogic loginManager = new LoginLogic();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showMainMenu();
    }
    
    // display the main menu
    public static void showMainMenu() {
        String menu = """
                      1. Login
                      2. Create Account
                      3. Exit
                      """;
        
        try {
            int selection = Integer.parseInt(JOptionPane.showInputDialog(menu, "Enter a value"));
            
            switch (selection) {
                case 1: 
                    handleLogin();
                    break;
                case 2:
                    handleAccountCreation();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid selection");
                    showMainMenu(); // Return to menu for invalid input
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
            showMainMenu(); // Return to menu for invalid input
        }
    }
    
    // Handle login process
    private static void handleLogin() {
        // Check if an account exists first
        if (!account.isAccountCreated()) {
            JOptionPane.showMessageDialog(null, "No account exists yet. Please create an account first.");
            showMainMenu();
            return;
        }
        
        // Get username input
        String username = JOptionPane.showInputDialog("Enter your username: ");
        if (username == null) {
            showMainMenu(); // User cancelled
            return;
        }
        
        // Get password input
        String password = JOptionPane.showInputDialog("Enter your password: ");
        if (password == null) {
            showMainMenu(); // User cancelled
            return;
        }
        
        // Pass login credentials to LoginLogic for processing
        boolean loginSuccess = loginManager.processLogin(username, password, account);
        
        if (loginSuccess) {
            JOptionPane.showMessageDialog(null, "Welcome back " + username);
        }
        
        showMainMenu();
    }
    
    // Handle account creation process
    private static void handleAccountCreation() {
        // Prompt user to create a username
        String username = JOptionPane.showInputDialog(null, 
                "Create a username (Must include '_' and be <= 5 characters):");
        
        if (username == null) {
            showMainMenu(); // User cancelled
            return;
        }
        
        // Prompt user to create a password
        String password = JOptionPane.showInputDialog(null, 
                "Create a password (Min 8 chars, 1 uppercase, 1 number, 1 special char):");
        
        if (password == null) {
            showMainMenu(); // User cancelled
            return;
        }
        
        // Confirm password
        String confirmPassword = JOptionPane.showInputDialog(null, "Confirm your password:");
        
        if (confirmPassword == null) {
            showMainMenu(); // User cancelled
            return;
        }
        
        // Prompt for cellphone number
        String cellphone = JOptionPane.showInputDialog(null, 
                "Enter your cellphone number (Format: +CountryCodeXXXXXXXXXX):");
        
        if (cellphone == null) {
            showMainMenu(); // User cancelled
            return;
        }
        
        // Pass collected data to AccountCreate for processing
        boolean accountCreated = account.processAccountCreation(username, password, confirmPassword, cellphone);
        
        if (accountCreated) {
            JOptionPane.showMessageDialog(null, "Account created successfully! Welcome " + username);
        }
        
        showMainMenu();
    }
}