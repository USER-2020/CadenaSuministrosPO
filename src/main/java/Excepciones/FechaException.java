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
public class FechaException extends Exception {

    public FechaException() {
    }

    public FechaException(String message) {
        super(message);
    }

    public void verificarDate(String fecha) throws FechaException {
        String fechaPattern = "^\\d{2}-\\d{2}-\\d{4}$";
        Pattern pattern = Pattern.compile(fechaPattern);
        Matcher matcher = pattern.matcher(fecha);
        if (!matcher.matches()) {
            throw new FechaException("el formato de fecha debe coincidir con la siguinte estructura: 02-02-2222");
        }
    }
}
