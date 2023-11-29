/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import model.AuthenticationUser;

/**
 *
 * @author Juan Zuluaga
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MenuGUI menu = new MenuGUI();
        menu.setVisible(false);
        AutenticacionUserGUI authGUI = new AutenticacionUserGUI();
        authGUI.setVisible(true);
        
    }
    
}
