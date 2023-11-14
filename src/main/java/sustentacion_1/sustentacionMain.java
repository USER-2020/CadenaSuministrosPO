/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sustentacion_1;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Juan Fernando Zuluaga
 */

public class sustentacionMain {

    /**
     * @param args the command line arguments
     */
    // Método para consultar y mostrar todos los usuarios
    public static void consultarTodos(List<Usuario> usuarios) {
        System.out.println("Lista de Usuarios:");
        for (Usuario u : usuarios) {
            System.out.println(u.toString());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
                
        List<Usuario> listaUsuarios = new ArrayList<>();
        
        listaUsuarios.add(new Usuario(1, "Administrador", "Juan", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(2, "Vendedor", "Ana", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));
        listaUsuarios.add(new Usuario(3, "Bodeguero", "Juanita", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(4, "Vendedor", "Anastacia", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));
        
        consultarTodos(listaUsuarios);
        
        
       
    }
    
}
