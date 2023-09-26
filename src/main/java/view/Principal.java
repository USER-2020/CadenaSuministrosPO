/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
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

        //ADD users quemados 
        // Agregar usuarios a la lista (esto es solo un ejemplo, puedes tener más usuarios)
        listaUsuarios.add(new Usuario(1, Usuario.TipoUsuario.Administrador, "Juan", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(2, Usuario.TipoUsuario.Vendedor, "Ana", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));
        listaUsuarios.add(new Usuario(3, Usuario.TipoUsuario.Bodeguero, "Juanita", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(4, Usuario.TipoUsuario.Vendedor, "Anastacia", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));
        listaUsuarios.add(new Usuario(5, Usuario.TipoUsuario.Vendedor, "Fernando", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(6, Usuario.TipoUsuario.Vendedor, "Felipe", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));
        listaUsuarios.add(new Usuario(7, Usuario.TipoUsuario.Bodeguero, "Julian", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(8, Usuario.TipoUsuario.Vendedor, "Wilson", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));
        listaUsuarios.add(new Usuario(9, Usuario.TipoUsuario.Vendedor, "Paquita", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(10, Usuario.TipoUsuario.Vendedor, "MAuricio", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));
        listaUsuarios.add(new Usuario(11, Usuario.TipoUsuario.Bodeguero, "Betty", "Perez", "123 Calle Principal", "123456789", "juan@example.com"));
        listaUsuarios.add(new Usuario(12, Usuario.TipoUsuario.Vendedor, "Pedro", "López", "456 Calle Secundaria", "987654321", "ana@example.com"));

        //Productos normales 
        listaProductos.add(new Product("Descripción 1", "Nombre 1", 1, "Rojo", "imagen1.jpg", "Marca A", "Material X", 10.0f, 20.0f, 5.0f));
        listaProductos.add(new Product("Descripción 2", "Nombre 2", 2, "Azul", "imagen2.jpg", "Marca B", "Material Y", 12.0f, 25.0f, 6.0f));
        listaProductos.add(new Product("Descripción 3", "Nombre 3", 3, "Verde", "imagen3.jpg", "Marca C", "Material Z", 15.0f, 30.0f, 7.0f));
        listaProductos.add(new Product("Descripción 4", "Nombre 4", 4, "Amarillo", "imagen4.jpg", "Marca D", "Material X", 11.0f, 22.0f, 5.5f));
        listaProductos.add(new Product("Descripción 5", "Nombre 5", 5, "Blanco", "imagen5.jpg", "Marca E", "Material Y", 14.0f, 28.0f, 6.0f));
        listaProductos.add(new Product("Descripción 6", "Nombre 6", 6, "Negro", "imagen6.jpg", "Marca F", "Material Z", 13.0f, 26.0f, 5.8f));

        //Lista de productos Electricos
        listaProductos.add(new ElectricProducts("Carga 1", "Calibre 1", "Descripción 1", "Nombre 1", 7, "Rojo", "imagen1.jpg", "10.0f", "Material X", 20.0f, 5.0f, 8.0f));
        listaProductos.add(new ElectricProducts("Carga 2", "Calibre 2", "Descripción 2", "Nombre 2", 8, "Azul", "imagen2.jpg", "12.0f", "Material Y", 25.0f, 6.0f, 9.0f));
        listaProductos.add(new ElectricProducts("Carga 3", "Calibre 3", "Descripción 3", "Nombre 3", 9, "Verde", "imagen3.jpg", "15.0f", "Material Z", 30.0f, 7.0f, 10.0f));
        listaProductos.add(new ElectricProducts("Carga 4", "Calibre 4", "Descripción 4", "Nombre 4", 10, "Amarillo", "imagen4.jpg", "11.0f", "Material X", 22.0f, 5.5f, 8.5f));

        //lista de herrajes 
        listaProductos.add(new HerrajesProducts("Tipo 1", "Descripción 1", "Nombre 1", 11, "Rojo", "imagen1.jpg", "Nombre 1", "Material X", 10.0f, 20.0f, 5.0f));
        listaProductos.add(new HerrajesProducts("Tipo 2", "Descripción 2", "Nombre 2", 12, "Azul", "imagen2.jpg", "Nombre 2", "Material Y", 12.0f, 25.0f, 6.0f));
        listaProductos.add(new HerrajesProducts("Tipo 3", "Descripción 3", "Nombre 3", 13, "Verde", "imagen3.jpg", "Nombre 3", "Material Z", 15.0f, 30.0f, 7.0f));
        listaProductos.add(new HerrajesProducts("Tipo 4", "Descripción 4", "Nombre 4", 14, "Amarillo", "imagen4.jpg", "Nombre 4", "Material X", 11.0f, 22.0f, 5.5f));
        listaProductos.add(new HerrajesProducts("Tipo 5", "Descripción 5", "Nombre 5", 15, "Blanco", "imagen5.jpg", "Nombre 5", "Material Y", 14.0f, 28.0f, 6.0f));

        //Scanner funcion para leer datos de teclado
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú de Usuarios" );
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Mostrar Usuarios");
            System.out.println("3. Agregar Productos");
            System.out.println("4. Mostrar Productos");
            System.out.println("5. Borrar Usuario por Id");
            System.out.println("6. Borrar Producto por Id");
            System.out.println("7. Organizar Usuarios por Id");
            System.out.println("8. Organizar Productos por Id");
            System.out.println("9. Buscar Usuarios por Id");
            System.out.println("10. Buscar Productos por Id");
            System.out.println("11. Salir");
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
                        System.out.println("ID: " + u.getId() + ", Nombre: " + u.getNombre() + " " + u.getApellido() + ", Tipo: " + u.getTipoUSer());
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
                                    productoExistenteElectrico = true;
                                    break;
                                }
                            }

                            if (productoExistenteElectrico) {
                                System.out.println("El producto con el mismo número de serie o nombre ya existe en la lista.");
                            } else {
                                System.out.println("Poder de carga: ");
                                String cargaE = scanner.next();
                                System.out.println("Calibre: ");
                                String calibreE = scanner.next();
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
                                    productoExistenteHerraje = true;
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
                    System.out.print("Ingrese el ID del usuario que desea eliminar: ");
                    int idBuscadoRemove = scanner.nextInt();
                    boolean usuarioEncontradoDlete = false;

                    // Iterar a través de la lista de usuarios
                    for (Usuario usuario : listaUsuarios) {
                        if (usuario.getId() == idBuscadoRemove) {
                            // Remover el usuario de la lista
                            listaUsuarios.remove(usuario);
                            usuarioEncontradoDlete = true;
                            System.out.println("Usuario eliminado correctamente.");
                            break; // Salir del bucle una vez que se ha eliminado el usuario
                        }
                    }

                    // Verificar si se encontró el usuario
                    if (!usuarioEncontradoDlete) {
                        System.out.println("No se encontró ningún usuario con el ID ingresado.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el ID del producto que desea eliminar: ");
                    int idProductoRemove = scanner.nextInt();
                    boolean productoEncontradoDlete = false;

                    // Iterar a través de la lista de productos
                    for (Product producto : listaProductos) {
                        if (producto.getNumeroSerial() == idProductoRemove) {
                            // Remover el producto de la lista
                            listaProductos.remove(producto);
                            productoEncontradoDlete = true;
                            System.out.println("Producto eliminado correctamente.");
                            break; // Salir del bucle una vez que se ha eliminado el producto
                        }
                    }

                    // Verificar si se encontró el producto
                    if (!productoEncontradoDlete) {
                        System.out.println("No se encontró ningún producto con el número de serie ingresado.");
                    }
                    break;
                case 7:
                    System.out.println("Ordenando Usuarios... ");
                    Collections.sort(listaUsuarios);
                    break;
                case 8:
                    System.out.println("Ordenando Productos... ");
                    Collections.sort(listaProductos);
                    break;
                case 9:
                    System.out.print("Ingrese el ID del usuario que desea buscar: ");
                    int idBuscado = scanner.nextInt();
                    boolean usuarioEncontrado = false;

                    for (Usuario usuario : listaUsuarios) {
                        if (usuario.getId() == idBuscado) {
                            System.out.println("Usuario encontrado:");
                            System.out.println("ID: " + usuario.getId());
                            System.out.println("Nombre: " + usuario.getNombre());
                            System.out.println("Apellido: " + usuario.getApellido());
                            System.out.println("Tipo de Usuario: " + usuario.getTipoUSer());
                            System.out.println("Dirección: " + usuario.getDireccion());
                            System.out.println("Número de Teléfono: " + usuario.getCellphone());
                            System.out.println("Correo Electrónico: " + usuario.getEmail());
                            usuarioEncontrado = true;
                            break; // Salir del bucle una vez que se encuentra el usuario
                        }
                    }

                    if (!usuarioEncontrado) {
                        System.out.println("No se encontro a ningun usuario registrado con ese ID");
                    }
                    break;
                case 10:
                    System.out.print("Ingrese el Id del producto que desea buscar: ");
                    int idProductoBuscado = scanner.nextInt();
                    boolean productoEncontrado = false;

                    for (Product producto : listaProductos) {
                        if (producto.getNumeroSerial() == idProductoBuscado) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Número de Serial: " + producto.getNumeroSerial());
                            System.out.println("Nombre: " + producto.getNombre());
                            System.out.println("Descripción: " + producto.getDescripcion());
                            System.out.println("Color: " + producto.getColor());

                            // Verificar si el producto es una instancia de ElectricProducts
                            if (producto instanceof ElectricProducts) {
                                ElectricProducts electricProduct = (ElectricProducts) producto;
                                // Acceder a los campos específicos de ElectricProducts
                                System.out.println("Poder de carga: " + electricProduct.getCarga());
                                System.out.println("Calibre: " + electricProduct.getCalibre());
                                // Continuar con otros campos específicos de ElectricProducts
                            } // Verificar si el producto es una instancia de HerrajesProducts
                            else if (producto instanceof HerrajesProducts) {
                                HerrajesProducts herrajesProduct = (HerrajesProducts) producto;
                                // Acceder a los campos específicos de HerrajesProducts
                                System.out.println("Tipo de elemento: " + herrajesProduct.getTipoElemento());
                                // Continuar con otros campos específicos de HerrajesProducts
                            }

                            productoEncontrado = true;
                            break; // Salir del bucle una vez que se encuentra el producto
                        }
                    }

                    if (!productoEncontrado) {
                        System.out.println("No se encontró ningún producto con el ID ingresado.");
                    }

                case 11:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

    }

}
