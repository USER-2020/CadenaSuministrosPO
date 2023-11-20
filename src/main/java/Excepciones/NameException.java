/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Liliana Aguirre
 */
public class NameException extends Exception {

    public NameException (){
        
    }
    public NameException(String message) {
        super(message);
    }

    public void verificarName(String name) throws NameException {
        String regex = "^[a-zA-Z0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new NameException("El campo debe ser alfanumerico");
        }
    }
}
