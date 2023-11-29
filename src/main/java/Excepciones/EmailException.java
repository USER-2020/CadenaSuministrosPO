/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Juan Zuluaga
 */
public class EmailException extends Exception{

    public EmailException() {
    }

    public EmailException(String message) {
        super(message);
    }
    
    public void verificarEmail(String email) throws EmailException{
        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            throw new EmailException("El email ingresado es incorrecto, verifique de nuevo");
        }
    }
}
