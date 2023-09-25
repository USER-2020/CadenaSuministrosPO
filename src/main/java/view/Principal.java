/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.ElectricProducts;
import model.HerrajesProducts;
import model.Product;
import model.Product;
import model.Usuario;

/**
 *
 * @author Liliana Aguirre
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Menu
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Product> listaProductos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú de Usuarios");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Mostrar Usuarios");
            System.out.println("3. Agregar Productos");
            System.out.println("4. Mostrar Productos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del usuario: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese nombre del usuario: ");
                    String nombre = scanner.nextLine();

                    // Verificar si ya existe un usuario con el mismo ID o nombre en la lista
                    boolean usuarioExistente = false;
                    for (Usuario usuario : listaUsuarios) {
                        if (usuario.getId() == id || usuario.getNombre().equals(nombre)) {
                            usuarioExistente = true;
                            break;
                        }
                    }

                    if (usuarioExistente) {
                        System.out.println("El usuario con el mismo ID o nombre ya existe en la lista.");
                    } else {
                        System.out.print("Ingrese apellido del usuario: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese dirección del usuario: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese número de teléfono del usuario: ");
                        String cellphone = scanner.nextLine();
                        System.out.print("Ingrese correo electrónico del usuario: ");
                        String email = scanner.nextLine();

                        // Crear un usuario con el tipo de usuario deseado (por ejemplo, TipoUsuario.OPCION1)
                        Usuario nuevoUsuario = new Usuario(id, Usuario.TipoUsuario.Administrador, nombre, apellido, direccion, cellphone, email);

                        // Verificar nuevamente si ya existe el usuario (por si acaso)
                        if (listaUsuarios.contains(nuevoUsuario)) {
                            System.out.println("El usuario ya existe en la lista.");
                        } else {
                            // Agregar el usuario a la lista
                            listaUsuarios.add(nuevoUsuario);
                            System.out.println("Usuario agregado correctamente.");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Lista de Usuarios:");
                    for (Usuario u : listaUsuarios) {
                        System.out.println("ID: " + u.getId() + ", Nombre: " + u.getNombre() + ", Tipo: " + u.getTipoUSer());
                    }
                    break;
                case 3:
                    System.out.println("Que tipo de producto quieres agregar");
                    System.out.println("1. Producto");
                    System.out.println("2. Electricos");
                    System.out.println("3. Herrajes");
                    System.out.println("Seleccione una opción: ");
                    int opcion2 = scanner.nextInt();
                    switch (opcion2) {
                        case 1:
                            System.out.println("Numero serial: ");
                            int nroS = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            System.out.println("Nombre producto: ");
                            String nameP = scanner.nextLine();

                            // Verificar si ya existe un producto con el mismo número de serie o nombre en la lista
                            boolean productoExistente = false;
                            for (Product producto : listaProductos) {
                                if (producto.getNumeroSerial() == nroS || producto.getNombre().equals(nameP)) {
                                    productoExistente = true;
                                    break;
                                }
                            }

                            if (productoExistente) {
                                System.out.println("El producto con el mismo número de serie o nombre ya existe en la lista.");
                            } else {
                                System.out.println("Descripcion producto: ");
                                String descripcionP = scanner.nextLine();
                                System.out.println("Color: ");
                                String colorP = scanner.nextLine();
                                System.out.println("Imagen: ");
                                String imgP = scanner.nextLine();
                                System.out.println("Marca: ");
                                String brandP = scanner.nextLine();
                                System.out.println("Material: ");
                                String materialP = scanner.nextLine();
                                System.out.println("Costo de produccion: ");
                                float costoProduccionP = scanner.nextFloat();
                                System.out.println("Costo de venta: ");
                                float costoVentaP = scanner.nextFloat();
                                System.out.println("Costo de almacenamiento: ");
                                float costoAlmacenamientoP = scanner.nextFloat();

                                // Crear un nuevo producto
                                Product newProduct = new Product(descripcionP, nameP, nroS, colorP, imgP, nameP, materialP, costoProduccionP, costoVentaP, costoAlmacenamientoP);

                                // Verificar nuevamente si ya existe el producto (por si acaso)
                                if (listaProductos.contains(newProduct)) {
                                    System.out.println("El producto ya existe en la lista.");
                                } else {
                                    // Agregar el producto a la lista
                                    listaProductos.add(newProduct);
                                    System.out.println("Producto agregado correctamente.");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Numero serial: ");
                            int nroSE = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            System.out.println("Nombre producto: ");
                            String nameE = scanner.nextLine();

                            // Verificar si ya existe un producto con el mismo número de serie o nombre en la lista
                            boolean productoExistenteElectrico = false;
                            for (Product producto : listaProductos) {
                                if (producto.getNumeroSerial() == nroSE || producto.getNombre().equals(nameE)) {
                                    productoExistente = true;
                                    break;
                                }
                            }

                            if (productoExistenteElectrico) {
                                System.out.println("El producto con el mismo número de serie o nombre ya existe en la lista.");
                            } else {
                                System.out.println("Poder de carga: ");
                                String cargaE = scanner.nextLine();
                                System.out.println("Calibre: ");
                                String calibreE = scanner.nextLine();
                                System.out.println("Descripcion producto: ");
                                String descripcionE = scanner.nextLine();
                                System.out.println("Color: ");
                                String colorE = scanner.nextLine();
                                System.out.println("Imagen: ");
                                String imgE = scanner.nextLine();
                                System.out.println("Marca: ");
                                String brandE = scanner.nextLine();
                                System.out.println("Material: ");
                                String materialE = scanner.nextLine();
                                System.out.println("Costo de produccion: ");
                                float costoProduccionE = scanner.nextFloat();
                                System.out.println("Costo de venta: ");
                                float costoVentaE = scanner.nextFloat();
                                System.out.println("Costo de almacenamiento: ");
                                float costoAlmacenamientoE = scanner.nextFloat();

                                // Crear un nuevo producto
                                ElectricProducts newElectrico = new ElectricProducts(cargaE, calibreE, descripcionE, nameE, nroSE, colorE, imgE, cargaE, materialE, costoProduccionE, costoVentaE, costoAlmacenamientoE);

                                // Verificar nuevamente si ya existe el producto (por si acaso)
                                if (listaProductos.contains(newElectrico)) {
                                    System.out.println("El producto ya existe en la lista.");
                                } else {
                                    // Agregar el producto a la lista
                                    listaProductos.add(newElectrico);
                                    System.out.println("Producto agregado correctamente.");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Numero serial: ");
                            int nroSH = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            System.out.println("Nombre producto: ");
                            String nameH = scanner.nextLine();

                            // Verificar si ya existe un producto con el mismo número de serie o nombre en la lista
                            boolean productoExistenteHerraje = false;
                            for (Product producto : listaProductos) {
                                if (producto.getNumeroSerial() == nroSH || producto.getNombre().equals(nameH)) {
                                    productoExistente = true;
                                    break;
                                }
                            }

                            if (productoExistenteHerraje) {
                                System.out.println("El producto con el mismo número de serie o nombre ya existe en la lista.");
                            } else {
                                System.out.println("Tipo de elemento: ");
                                String tipoElmentH = scanner.nextLine();
                                System.out.println("Descripcion producto: ");
                                String descripcionH = scanner.nextLine();
                                System.out.println("Color: ");
                                String colorH = scanner.nextLine();
                                System.out.println("Imagen: ");
                                String imgH = scanner.nextLine();
                                System.out.println("Marca: ");
                                String brandH = scanner.nextLine();
                                System.out.println("Material: ");
                                String materialH = scanner.nextLine();
                                System.out.println("Costo de produccion: ");
                                float costoProduccionH = scanner.nextFloat();
                                System.out.println("Costo de venta: ");
                                float costoVentaH = scanner.nextFloat();
                                System.out.println("Costo de almacenamiento: ");
                                float costoAlmacenamientoH = scanner.nextFloat();

                                // Crear un nuevo producto
                                HerrajesProducts newProductH = new HerrajesProducts(tipoElmentH, descripcionH, nameH, nroSH, colorH, imgH, nameH, materialH, costoProduccionH, costoVentaH, costoAlmacenamientoH);

                                // Verificar nuevamente si ya existe el producto (por si acaso)
                                if (listaProductos.contains(newProductH)) {
                                    System.out.println("El producto ya existe en la lista.");
                                } else {
                                    // Agregar el producto a la lista
                                    listaProductos.add(newProductH);
                                    System.out.println("Producto agregado correctamente.");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Saliendo del programa.");
                            scanner.close();
                            System.exit(0);

                        default:

                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de Productos:");
                    for (Product p : listaProductos) {
                        System.out.println("Producto --> " + p.toString());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

    }

}
