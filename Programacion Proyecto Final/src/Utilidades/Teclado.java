/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Clases.Cliente;
import Clases.Comision;
import Clases.Digital;
import Clases.Plataforma;
import Clases.Tradicional;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Clase teclado con las utilidades necesarias para pedir al usuario una serie
 * de datos por teclado. Aglutina las clases que requieran de preguntar al
 * usuario algun tipo de dato, pregunta, menú de creación...
 *
 * @author Laura
 */
public class Teclado {

    /**
     * Método que obtiene de teclado un número y comprueba que aquello que se
     * introduce sea efectivamente un dígito correcto y no un símbolo, letra u
     * otro caracter.
     *
     * @return int, número entero.
     */
    public static int pedirNumero() {
        int numero = 0;
        boolean esNumero = false;
        Scanner lector = new Scanner(System.in);
        while (esNumero == false) {
            try {
                numero = lector.nextInt();
                esNumero = true;
            } catch (InputMismatchException e) {
                System.out.println("Dato incorecto. Introduce un número porfavor.");
            }
        }
        return numero;
    }

    /**
     * Método que obtiene de teclado un número con decimales y comprueba que
     * aquello que se introduce sea efectivamente un dígito correcto y no un
     * símbolo, letra u otro caracter.
     *
     * @return double, número con decimales.
     */
    public static int pedirPrecio() {
        int precio = 0;
        boolean esCorrecta = false;
        Scanner lector = new Scanner(System.in);
        while (esCorrecta == false) {
            try {
                do {
                    System.out.println("Introduce un precio: (mínimo 5€)");
                    precio = lector.nextInt();
                    esCorrecta = true;
                } while (precio < 5);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorecto. Introduce un número porfavor.");
            }
        }
        return precio;
    }

    /**
     * Método que pide un string al usuario por teclado sin realizar ningún tipo
     * de comprobación acerca del texto introducido.
     *
     * @return String introducido por el usuario por teclado.
     */
    public static String pedirString() {
        String frase;
        Scanner lector = new Scanner(System.in);
        return frase = lector.nextLine();
    }

    /**
     * Método que pide al usuario que responda si o no ante una pregunta que se
     * le ha debido plantear anteriormente a la llamada del mismo y que
     * retornará un booleando según la opción elegida.
     *
     * @return boolean. True si elige 1(Si), false si elige 2(No).
     */
    public static boolean pedirBoolean() {
        boolean opcion;
        System.out.println("1. Si  2. No");
        int numero = 0;
        while (numero != 1 && numero != 2) {
            numero = Teclado.pedirNumero();
        }
        if (numero == 1) {
            opcion = true;
        } else {
            opcion = false;
        }
        return opcion;
    }

    /**
     * Método que realiza una serie de preguntas al usuario para crea una
     * instancia de la clase Comisión. Pedirá todos los atributos que componen
     * esa clase tales como título de la comisión, descripción, precio base,
     * contenido NSFW, nombre del artista que la realiza y dependiendo de si es
     * de subtipo Digital si es animada o no, si tiene correcciones o no; o si
     * es Tradicional el tamaño del soporte a usar o la zona de envío que le
     * corresponde.
     *
     * @return Objeto de la clase Comisión (subclase Tradicional o Digital).
     */
    public static Comision crearComision() {
        Scanner lector = new Scanner(System.in);
        System.out.println("========== DATOS PARA CREAR UNA NUEVA COMISIÓN ============");
        System.out.println("Título de la comisión:");
        String tit = lector.nextLine();
        System.out.println("Descripción del dibujo/producto:");
        String des = lector.nextLine();
        System.out.println("Precio base (minimo 5€):");
        int pre = pedirPrecio();
        System.out.println("¿Puede ser de contenido adulto la ilustración a encargar?");
        boolean nsfw = pedirBoolean();
        System.out.println("Artista que vende la comisión:");
        String artist = lector.nextLine();
        System.out.println("¿Ilustracion hecha por medio Digital o Tradicional? 1. Digital 2. Tradicional");
        int opcion;
        do {
            opcion = Teclado.pedirNumero();
        } while (opcion != 1 && opcion != 2);
        Comision comi;
        if (opcion == 1) {
            System.out.println("¿Es una ilustracion animada? 1.Si   2.No");
            boolean anim = pedirBoolean();
            System.out.println("¿Se enviarán los bocetos previos para hacer correcciones o solo el producto final?  1. Con correcciones   2. Solo el producto final.");
            boolean correc = pedirBoolean();
            comi = new Digital(tit, des, pre, nsfw, artist, anim, correc);
        } else {
            System.out.println("Tamaño del papel o soporte a usar: (Grande, mediano, pequeño");
            String tamano = lector.nextLine();
            System.out.println("Zona de envio que desea abarcar: 1. UE  2. Internacional.");
            int zona = 0;
            do {
                zona = Teclado.pedirNumero();
            } while (zona != 1 && zona != 2);
            comi = new Tradicional(tit, des, pre, nsfw, artist, tamano, zona);
        }
        return comi;
    }

    public static Cliente crearCliente() {
        Scanner lector = new Scanner(System.in);
        Cliente newcliente;
        System.out.println("Nuevos registro de cliente. Introduzca los siguientes valores:");
        System.out.println("Introduce tu nombre o nickname: ");
        String nick = lector.nextLine();
        System.out.println("Introduce tu email de registro: ");
        String mail = lector.nextLine();
        System.out.println("Introduce tu contraseña: ");
        String pas = lector.nextLine();
        return newcliente = new Cliente(nick, mail, pas);
    }

    public static void menu() {
        Plataforma plat = new Plataforma();
        System.out.println("================= Bienvenid@ elige una opción =================");
        int opcion;
        do {
            System.out.println("_________________________________________________________________________________________");
            System.out.println(" 1. Registrarse como cliente. \n 2. Acceder como cliente. \n 3. Administrar. \n 4. SALIR y GUARDAR.");
            Scanner lector = new Scanner(System.in);

            do {
                opcion = pedirNumero();
            } while (opcion < 1 || opcion > 4);

            switch (opcion) {
                case 1:
                    plat.agregarCliente(crearCliente());
                    break;

                case 2:
                    System.out.println("Introduce tu nickname y contraseña:");
                    String user = lector.nextLine();
                    String pass = lector.nextLine();
                    if (plat.obtenerCliente(user).getPassword().equalsIgnoreCase(pass)) {
                        System.out.println("Bienvenid@ " + user);
                        int opt = 0;
                        do {
                            System.out.println("___________________________________________________________________________________________________");
                            System.out.println("Elige una opción: 1. Ver comisiones disponibles. 2. Ver mis pedidos. 3. Editar mi cuenta. "
                                    + "4. Listar comisiones por precio final (de menor a mayor). 5. SALIR");
                            opt = pedirNumero();
                            switch (opt) {
                                case 1:
                                    plat.listarComisiones();
                                    break;
                                case 2:
                                    plat.listarPedidoNombre(user);
                                    break;
                                case 3:
                                    plat.editarCliente(user);
                                    break;
                                case 4:
                                    plat.listarPrecioAscendente();
                                    break;
                            }
                        } while (opt != 5);

                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                    break;

                case 3:
                    System.out.println("Introduce la contraseña de administrador: ");
                    String adminpass = lector.nextLine();
                    if (adminpass.equals("admin123")) {
                        int opt;
                        do {
                            System.out.println("_____________________________________________________________________");
                            System.out.println("1. Crear comisión 2. Quitar comisión 3. Editar comisión"
                                    + "\n4. Agregar cliente 5. Quitar cliente 6. Editar cliente."
                                    + "\n7. Quitar pedido 8. Listar Pedidos 9. Listar comisiones. 10. Listar clientes."
                                    + "\n11. Calcular total ganado por ventas. 12. Gastos recientes de los clientes. 13. SALIR");
                            opt = pedirNumero();
                            switch (opt) {
                                case 1:
                                    plat.crearAgregarComision();
                                    break;
                                case 2:
                                    System.out.println("Introduce el código de la comisión a eliminar:");
                                    String cod = lector.nextLine();
                                    plat.quitarComision(cod);
                                    break;
                                case 3:
                                    System.out.println("Introduce el código de la comisión a editar:");
                                    String codi = lector.nextLine();
                                    plat.editarComision(codi);
                                    break;
                                case 4:
                                    plat.agregarCliente(Utilidades.Teclado.crearCliente());
                                    break;
                                case 5:
                                    System.out.println("Nombre/nickname del cliente a eliminar:");
                                    String name = lector.nextLine();
                                    plat.quitarCliente(name);
                                    break;
                                case 6:
                                    System.out.println("Nombre/nickname del cliente a eliminar:");
                                    String namee = lector.nextLine();
                                    plat.editarCliente(namee);
                                    break;
                                case 7:
                                    System.out.println("Introduce el código del pedido a eliminar: ");
                                    String code = lector.nextLine();
                                    plat.quitarPedido(code);
                                    break;
                                case 8:
                                    plat.listarPedidos();
                                    break;
                                case 9:
                                    plat.listarComisiones();
                                    break;
                                case 10:
                                    plat.listarClientes();
                                    break;
                                case 11:
                                    System.out.println("Total ganado al cobrar los pedidos registrados:");
                                    System.out.println(plat.calcularTotalGanado() + " €");
                                    break;
                                case 12:
                                    Set keys = plat.mapa().keySet();
                                    Iterator it = keys.iterator();
                                    while (it.hasNext()) {
                                        String key = (String) it.next();
                                        Double value = plat.mapa().get(key);
                                        System.out.println("Cliente " + key + " ha gastado recientemente " + value);
                                    }
                                    break;
                            }

                        } while (opt != 13);

                    } else {
                        System.out.println("Contraseña incorrecta.");
                    }
                    break;

                case 4:
                    plat.guardarDatos();
                    System.out.println("Ha salido de la plataforma.");
                    break;
            }
        } while (opcion != 4);

    }
}
