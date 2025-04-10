/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letschat;
import javax.swing.*;

/**
 *
 * @author katlego
 */
public class AccountCreate {
     private String username;
     private String password;
     private String cellphone;
     private boolean accountCreated = false;
    
    // New method to process account creation with data from main class
    public boolean processAccountCreation(String inputUsername, String inputPassword, 
                                         String confirmPassword, String inputCell) {
        
        // Validate username format
        if (!isValidUsername(inputUsername)) {
            JOptionPane.showMessageDialog(null, 
                    "Invalid username! It must contain '_' and be no more than 5 characters.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate password complexity
        if (!isValidPassword(inputPassword)) {
            JOptionPane.showMessageDialog(null, 
                    "Invalid password! Must be at least 8 characters long and include a capital letter, a number, and a special character.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Check if passwords match
        if (!inputPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, 
                    "Passwords do not match! Try again.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate phone number
        if (!isValidPhoneNumber(inputCell)) {
            JOptionPane.showMessageDialog(null, 
                    "Invalid phone number! Must start with + and contain a valid country code and up to 10 digits.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Save valid details
        this.username = inputUsername;
        this.password = inputPassword;
        this.cellphone = inputCell;
        this.accountCreated = true;
        
        return true;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }
    
    // Getter for password
    public String getPassword() {
        return password;
    }
    
    // Check if account has been created
    public boolean isAccountCreated() {
        return accountCreated;
    }

    // Method to verify login credentials
    public boolean login(String inputUsername, String inputPassword) {
        return this.username != null && this.password != null &&
               this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
    
    // Username validation helper method
    private boolean isValidUsername(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Password validation helper method
    private boolean isValidPassword(String password) {
        return password != null &&
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&      // Has uppercase
               password.matches(".*\\d.*") &&        // Has number
               password.matches(".*[!@#$%^&*()_+=<>?/{}|~`-].*"); // Has special character
    }

    // Cellphone validation helper method
    private boolean isValidPhoneNumber(String number) {
        if (number == null || !number.startsWith("+")) return false;
        String digits = number.substring(1); // Remove +
        return digits.matches("\\d{1,13}") && digits.length() <= 13;
    }
}