/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juan Zuluaga
 */
public class AuthenticationUser extends Usuario {

    private String password;

    public AuthenticationUser(String password, int id, String tipoUSer, String nombre, String apellido, String direccion, String cellphone, String email) {
        super(id, tipoUSer, nombre, apellido, direccion, cellphone, email);
        this.password = password;
    }

    public AuthenticationUser(String password) {
        this.password = password;
    }

    public AuthenticationUser() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
