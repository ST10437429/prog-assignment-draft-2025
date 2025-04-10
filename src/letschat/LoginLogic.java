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
public class LoginLogic {
    private int attempts = 0;
    private static final int MAX_ATTEMPTS = 3;
    
    // Process login with data from main class
    public boolean processLogin(String username, String password, AccountCreate account) {
        if (!account.isAccountCreated()) {
            JOptionPane.showMessageDialog(null, "No account exists yet. Please create an account first.");
            return false;
        }
        
        if (attempts >= MAX_ATTEMPTS) {
            JOptionPane.showMessageDialog(null, "Too many failed attempts. Please try again later.");
            attempts = 0; // Reset for next time
            return false;
        }
        
        if (username.equals(account.getUsername())) {
            if (password.equals(account.getPassword())) {
                attempts = 0; // Reset attempts on successful login
                return true;
            } else {
                attempts++;
                if (attempts < MAX_ATTEMPTS) {
                    JOptionPane.showMessageDialog(null, 
                            "Incorrect password. Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Too many failed attempts. Please try again later.");
                }
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username does not exist");
            attempts++;
            if (attempts >= MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(null, 
                        "Too many failed attempts. Please try again later.");
            }
            return false;
        }
    }
}