/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Comparadores.comisionesPrecioTotal;
import Utilidades.compararTitulo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Clase que contiene las listas de comisiones, clientes y pedidos que se tienen
 * registrados en los ficheros o la plataforma, junto con los métodos que
 * permiten realizar acciones o gestiones sobre los mismos.
 *
 * @author Laura
 */
public class Plataforma {

    /**
     * ArrayList que contiene todas las instancias de tipo Comision que se han
     * registrado en la plataforma.
     */
    ArrayList<Comision> comisiones = new ArrayList();
    /**
     * TreeSet que contiene todas las instancias de tipo Cliente que se han
     * registrado en la plataforma.
     */
    TreeSet<Cliente> clientes = new TreeSet();

    /**
     * ArrayList que contiene todas las instancias de tipo Pedido que se han
     * registrado en la plataforma.
     */
    ArrayList<Pedido> pedidos = new ArrayList();

    /**
     * Contructor de la clase Plataforma. Al iniciarse la plataforma se debe
     * cargar en memoria el contenido de los ficheros de datos para poder
     * realizar acciones sobre ellos.
     */
    public Plataforma() {
        clientes = Utilidades.UtilidadesFichero.cargarClientes();
        comisiones = Utilidades.UtilidadesFichero.cargarComisiones();
        pedidos = Utilidades.UtilidadesFichero.cargarPedidos();

//        clientes.add(new Cliente("Frog", "fro@gmail.com", "1111"));
//        clientes.add(new Cliente("Baku", "boom@gmail.com", "2222"));
//        clientes.add(new Cliente("Deku", "Oneforall@gmail.com", "3333"));
//        clientes.add(new Cliente("Ocha", "gravityfalls@gmail.com", "4444"));
//        clientes.add(new Cliente("Todo", "chicken@gmail.com", "5555"));
//
//        comisiones.add(new Digital("Retrato", "Retrato hasta los hombros", 20, false, "Juanita", false, false));
//        comisiones.add(new Digital("Avatar animado", "Avatar animado guiñando ojos.", 20, false, "Fulanito", true, false));
//        comisiones.add(new Tradicional("Paisaje", "Paisaje de cualquier lugar que soliciten.", 50, false, "Pajares", "Mediano", 1));
//
//        pedidos.add(new Pedido("Pedido01", "Frog", "Digital1"));
//        pedidos.add(new Pedido("Pedido02", "Ocha", "Digital2"));
//        pedidos.add(new Pedido("Pedido03", "Todo", "Tradicional3"));
//        pedidos.add(new Pedido("Pedido04", "Baku", "Digital1"));
//        pedidos.add(new Pedido("Pedido01", "Baku", "Digital1"));
    }

    /**
     * Método que obtiene el ArrayList de objetos de clase Comision almacenados
     * en la plataforma.
     *
     * @return ArrayList de Comision. Arraylist con los objetos de tipo
     * Comision.
     */
    public ArrayList<Comision> getComisiones() {
        return comisiones;
    }

    /**
     * Método para establecer el valor del ArrayList de objetos de tipo
     * Comision.
     *
     * @param comisiones ArrayList de objetos de tipo Comision.
     */
    public void setComisiones(ArrayList<Comision> comisiones) {
        this.comisiones = comisiones;
    }

    /**
     * Método para obtener el TreeSet de objetos de la clase Cliente almacenados
     * en la plataforma.
     *
     * @return TreeSet de Cliente. TreeSet con los objetos de tipo Cliente.
     */
    public TreeSet<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Método para establecer el valor del TreeSet de objetos de tipo Cliente.
     *
     * @param clientes ArrayList de objetos de tipo Cliente.
     */
    public void setClientes(TreeSet<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Método que obtiene el ArrayList de objetos de clase Pedido almacenados en
     * la plataforma.
     *
     * @return ArrayList de Pedido. Arraylist con los objetos de tipo Pedido.
     */
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Método para establecer el valor del ArrayList de objetos de tipo Pedido.
     *
     * @param pedidos ArrayList de objetos de tipo Pedido.
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * Método que agrega al ArrayList de comisiones una nueva comisión creada y
     * a su vez guarda en el fichero de objetos los nuevos datos contenidos en
     * el ArrayList tras agregar la comisión.
     *
     * @param comi tipo Comision. Abreviatura de comision. Objeto de tipo
     * Comisión que se va a incorporar al ArrayList de comisiones que existe en
     * la plataforma.
     */
    public void agregarComision(Comision comi) {
        comisiones.add(comi);
        Utilidades.UtilidadesFichero.grabarComisiones(comisiones);
    }

    /**
     * Método que agrega al ArrayList de comisiones una nueva comisión creada
     * dentro del método llamando a la Utilidad crear comisión del paquete
     * utilidades, y de la clase Teclado. A su vez guarda en el fichero de
     * objetos los nuevos datos contenidos en el ArrayList tras agregar la
     * comisión.
     */
    public void crearAgregarComision() {
        comisiones.add(Utilidades.Teclado.crearComision());
        Utilidades.UtilidadesFichero.grabarComisiones(comisiones);
    }

    /**
     * Método que busca una comisión determinada por su código en el ArrayList
     * de comisiones que están registradas en la plataforma y la elimina de
     * dicho ArrayList.
     *
     * @param codigo tipo String. Código identificador de la comisión a
     * eliminar.
     */
    public void quitarComision(String codigo) {
        for (int i = 0; i < comisiones.size(); i++) {
            if (comisiones.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Comisión encontrada. ¿Desea eliminarla?");
                boolean confirmar = Utilidades.Teclado.pedirBoolean();
                if (confirmar) {
                    comisiones.remove(comisiones.get(i));
                } else {
                    System.out.println("No se ha eliminado la comisión.");
                }
            }
        }
        Utilidades.UtilidadesFichero.grabarComisiones(comisiones);
    }

    /**
     * Método que busca una comisión determinada por su código en el ArrayList
     * de comisiones que están registradas en la plataforma y permite editar
     * algunos de sus atributos.
     *
     * @param codigo tipo String. Código identificador de la comisión a
     * eliminar.
     */
    public void editarComision(String codigo) {
        for (int i = 0; i < comisiones.size(); i++) {
            if (comisiones.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Comisión encontrada. Datos a modificar:");
                System.out.println("Introduce el título:");
                comisiones.get(i).setTitulo(Utilidades.Teclado.pedirString());
                System.out.println("Introduce la descripción:");
                comisiones.get(i).setDescripcion(Utilidades.Teclado.pedirString());
                System.out.println("Introduce el precio base:");
                comisiones.get(i).setPrecioBase(Utilidades.Teclado.pedirPrecio());
                System.out.println("¿La comisión tiene contenido NSFW?");
                comisiones.get(i).setNSFW(Utilidades.Teclado.pedirBoolean());
                System.out.println("Introduce el nombre del artista que la realiza:");
                comisiones.get(i).setArtist(Utilidades.Teclado.pedirString());
            }
            System.out.println("Cambios realizados:");
            System.out.println(comisiones.get(i).toStringCompleto());
        }
        Utilidades.UtilidadesFichero.grabarComisiones(comisiones);
    }

    /**
     * Método encargado de buscar un objeto de tipo Comisión en el ArrayList de
     * la plataforma donde están registradas mediante su código para devolver el
     * objeto cuyo código de identificación sea el introducido por parámetro.
     *
     * @param codigo tipo String. Código que identifica la comisión y que se usa
     * para realizar la búsqueda de dicho objeto dentro de la plataforma.
     *
     * @return objeto de tipo Comision.
     */
    public Comision obtenerComision(String codigo) {
        Comision com = null;
        boolean encontrado = false;
        for (int i = 0; i < comisiones.size(); i++) {
            if (comisiones.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Comisión encontrada. ¿Desea eliminarla?");
                com = comisiones.get(i);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado ninguna comisión con ese código.");
        }
        return com;
    }

    /**
     * Método que agrega un nuevo cliente a la plataforma. Añade un objeto de
     * tipo Cliente al TreeSet de clientes.
     *
     * @param clie Objeto de tipo Cliente.
     */
    public void agregarCliente(Cliente clie) {
        if (clientes.contains(clie)) {
            System.out.println("Ese nickname ya está registrado. No se pudo crear la cuenta de cliente.");
        } else {
            clientes.add(clie);
            Utilidades.UtilidadesFichero.grabarClientes(clientes);
        }

    }

    /**
     * Método que busca un cliente determinado por su nickname en el TreeSet de
     * clientes que estan registrados en la plataforma y lo elimina de dicho
     * ArrayList.
     *
     * @param nombre tipo String. Nickname o nombre identificador del cliente a
     * eliminar.
     */
    public void quitarCliente(String nombre) {
        Iterator ite = clientes.iterator();
        while (ite.hasNext()) {
            Cliente clie = (Cliente) (ite.next());
            if (clie.getNickname().equalsIgnoreCase(nombre)) {
                System.out.println("Cliente " + nombre + " encontrado. ¿Desea eliminarlo?");
                boolean eliminar = Utilidades.Teclado.pedirBoolean();
                if (eliminar) {
                    clientes.remove(clie);
                }
            }

        }
        Utilidades.UtilidadesFichero.grabarClientes(clientes);
    }

    /**
     * Método que busca un cliente determinado por su nickname en el TreeSet de
     * clientes que estan registrados en la plataforma y permite modificar sus
     * atributos.
     *
     * @param nombre tipo String. Nickname o nombre identificador del cliente a
     * modificar.
     */
    public void editarCliente(String nombre) {
        Iterator ite = clientes.iterator();
        Scanner lector = new Scanner(System.in);
        boolean encontrado = false;
        while (ite.hasNext()) {
            Cliente clie = (Cliente) (ite.next());
            if (clie.getNickname().equalsIgnoreCase(nombre)) {
                System.out.println("Cliente " + nombre + " encontrado. Alterando sus datos:");
                System.out.println("Introduce un email:");
                String em = lector.nextLine();
                clie.setEmail(em);
                System.out.println("Introduce contraseña:");
                String ps = lector.nextLine();
                clie.setPassword(ps);
                System.out.println("Datos cambiados.");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado el cliente en el registro.");
        }
        Utilidades.UtilidadesFichero.grabarClientes(clientes);
    }

    /**
     * Método encargado de buscar un objeto de tipo Cliente en el TreeSet de la
     * plataforma donde están registradas mediante su nickname para devolver el
     * objeto cuyo nickname sea el introducido por parámetro.
     *
     * @param nombre tipo String. Código que identifica al cliente y que se usa
     * para realizar la búsqueda de dicho objeto dentro de la plataforma.
     *
     * @return objeto de tipo Cliente.
     */
    public Cliente obtenerCliente(String nombre) {
        Cliente cli = null;
        Iterator ite = clientes.iterator();
        while (ite.hasNext()) {
            Cliente clie = (Cliente) (ite.next());
            if (clie.getNickname().equalsIgnoreCase(nombre)) {
                cli = clie;
            }
        }
        return cli;
    }

    /**
     * Método que agrega un nuevo pedido a la plataforma. Añade un objeto de
     * tipo Pedido al ArrayList de pedidos.
     *
     * @param ped Objeto de tipo Pedido.
     */
    public void agregarPedido(Pedido ped) {
        pedidos.add(ped);
    }

    /**
     * Método que busca un pedido determinado por su código en el ArrayList de
     * pedidos que están registrados en la plataforma y lo elimina de dicho
     * ArrayList. Al eliminarse se graban los cambios en fichero.
     *
     * @param codigo tipo String. Código identificador del pedido a eliminar.
     */
    public void quitarPedido(String codigo) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                if (pedidos.get(i).getidPedido().equalsIgnoreCase(codigo)) {
                    System.out.println("Pedido encontrado. ¿Desea eliminarlo?");
                    boolean confirmar = Utilidades.Teclado.pedirBoolean();
                    if (confirmar) {
                        pedidos.remove(pedidos.get(i));
                    } else {
                        System.out.println("No se ha eliminado el pedido.");
                    }

                }
            }
            Utilidades.UtilidadesFichero.grabarPedido(pedidos);
        }

    }

    /**
     * Método encargado de buscar un objeto de tipo Pedido en el ArrayList de la
     * plataforma donde están registradas mediante su código para devolver el
     * objeto cuyo código de identificación sea el introducido por parámetro.
     *
     * @param codigo tipo String. Código que identifica el pedido y que se usa
     * para realizar la búsqueda de dicho objeto dentro de la plataforma.
     *
     * @return objeto de tipo Pedido.
     */
    public Pedido obtenerPedido(String codigo) {
        Pedido ped = null;
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getidPedido().equalsIgnoreCase(codigo)) {
                ped = pedidos.get(i);
            }
        }
        return ped;
    }

    public void listarPedidoNombre(String nombre) {
        Pedido ped = null;
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getNicknameCliente().equalsIgnoreCase(nombre)) {
                System.out.println(pedidos.get(i).toStringCompleto());
            }
        }

    }

    /**
     * Método que muestra una lista de todas las comisiones cuyo precio base
     * corresponda con el parámetro introducido en el método.
     *
     * @param precio tipo double. Precio base que sirve de parámetro para
     * realizar la búsqueda en el ArrayList de Comisiones.
     */
    public void listarPorPrecio(double precio) {
        boolean encontrada = false;
        System.out.println("Comisiones con precio igual a " + precio + " €");
        for (int i = 0; i < comisiones.size(); i++) {
            if (comisiones.get(i).getPrecioBase() == precio) {
                encontrada = true;
                System.out.println(comisiones.get(i).toStringCompleto());
            }
        }
        if (!encontrada) {
            System.out.println("Ninguna comisión encontrada con precio de " + precio + "€");
        }
    }

    /**
     * Método que muestra una lista de todas las comisiones cuyo precio base sea
     * igual o menor al parámetro introducido en el método.
     *
     * @param precio tipo double. Precio base que sirve de límite superior para
     * realizar la búsqueda en el ArrayList de Comisiones.
     */
    public void listarPrecioMenor(double precio) {
        boolean encontrada = false;
        System.out.println("Comisiones con precio igual o inferior " + precio + " €");
        for (int i = 0; i < comisiones.size(); i++) {
            if (comisiones.get(i).getPrecioBase() <= precio) {
                encontrada = true;
                System.out.println(comisiones.get(i).toStringCompleto());
            }
        }
        if (!encontrada) {
            System.out.println("Ninguna comisión encontrada con precio menor o igual a " + precio + "€");
        }
    }
    
    /**
     * Listado de todas las comisiones por precio total final ordenados bajo el 
     * criterio de comparación de precio final ascendente, y a igualdad de precio
     * ordenar por titulo, alfabeticamente.
     */
    
    public void listarPrecioAscendente(){
        System.out.println("======= Listando comisiones por precio total de menor a mayor =======");
        ArrayList<Comision> copia = new ArrayList(comisiones);
        Collections.sort(copia, new comisionesPrecioTotal());
        Iterator it = copia.iterator();
        while(it.hasNext()){
            Comision x= ((Comision)it.next());
            System.out.println(x.toStringCompleto());
            System.out.println("  -  Precio total: " + x.calcularPrecioTotal());
        }
    
    }

    /**
     * Método que lista todas las comisiones realizadas por un artista
     * determinado y que será buscado en el Arraylist de comisiones a través de
     * su nombre de artista.
     *
     * @param nombre tipo String. Nombre del artista que realiza esa comision y
     * que sirve como parámetro de búsqueda dentro del ArrayList de comisiones.
     */
    public void listarPorArtista(String nombre) {
        boolean encontrada = false;
        System.out.println("Comisiones del artista " + nombre);
        for (int i = 0; i < comisiones.size(); i++) {
            if (comisiones.get(i).getArtist().equalsIgnoreCase(nombre)) {
                encontrada = true;
                System.out.println(comisiones.get(i).toStringCompleto());
            }
        }
        if (!encontrada) {
            System.out.println("Ninguna comisión encontrada bajo ese nombre de artista.");
        }
    }

    /**
     * Método que lista los atributos de todas las comisiones cuyo título sea
     * igual al introducido mediante parámetro en el método. Busca las
     * coincidencias en cada comisión registrada en el ArrayList de comisiones
     * de la plataforma y las muestra por pantalla.
     *
     * @param titulo tipo String. Título de la comisión o comisiones que se
     * quieren listar por pantalla.
     */
    public void listarPorTitulo(String titulo) {
        System.out.println("Listando comisiones con títutlo: " + titulo);
        if (comisiones.isEmpty()) {
            System.out.println("No hay comisiones registradas en la plataforma.");
        } else {
            boolean encontrada = false;
            for (int i = 0; i < comisiones.size(); i++) {
                if (comisiones.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println(comisiones.get(i).toStringCompleto());
                    encontrada = true;
                }
            }
            if (!encontrada) {
                System.out.println("No se han encontrado comisiones con ese titulo.");
            }
        }

    }

    /**
     * Método que lista por pantalla el contenido completo del ArrayList de
     * Pedidos, mostrando todos los pedidos que hay registrados hasta la fecha
     * con sus atributos.
     *
     */
    public void listarPedidos() {
        System.out.println("Listando pedidos registrados en la plataforma:");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println(pedidos.get(i).toStringCompleto());
            }
        }
    }

    /**
     * Método que lista por pantalla el contenido completo del ArrayList de
     * comisiones, mostrando todas las comisiones que hay registradas hasta la
     * fecha con sus atributos por orden alfabético de título.
     *
     */
    public void listarComisiones() {
        if (comisiones.isEmpty()) {
            System.out.println("No hay comisiones registradas en la plataforma.");
        } else {
            System.out.println("Listando comisiones ordenadas por Titulo.");
            Collections.sort(comisiones, new compararTitulo());
            for (int i = 0; i < comisiones.size(); i++) {
                System.out.println(comisiones.get(i).toStringCompleto());
            }

        }
    }

    /**
     * Método que lista por pantalla el contenido completo del TreeSet de
     * clientes, mostrando todos los clientes que hay registrados hasta la fecha
     * con sus atributos por orden alfabético de nombre/nickname. Se solicita al
     * usuario elegir si el orden alfabético es ascendente o descendente.
     *
     */
    public void listarClientes() {
        System.out.println("Ordenar de forma ascendente o descendente: 1. Ascendente  2. Descendente.");
        int opcion;
        do {
            opcion = Utilidades.Teclado.pedirNumero();
        } while (opcion < 1 || opcion > 2);
        if (opcion == 1) {
            Iterator it = clientes.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } else {
            Iterator it = clientes.descendingSet().iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        }

    }

    /**
     * Método que calcula el total que ha ganada la plataforma mediante los
     * recibos que se han generado por la venta o adquisición de una comisión
     * por parte de un cliente. Para ello obtiene el identificador de la
     * comisión que aparece en cada recibo, busca la comison en concreto, y
     * calcula el precio final de cada comisión sumando finalmente los todos los
     * totales para dar el resultado total ganado por la plataforma.
     *
     * @return double. Suma final de todos los precios totales de cada objeto
     * comisión referenciado en cada recibo por su código de identificación.
     */
    public double calcularTotalGanado() {
        double total = 0;
        for (int i = 0; i < pedidos.size(); i++) {
            String id = pedidos.get(i).getCodigoComision();
            for (int j = 0; j < comisiones.size(); j++) {
                if (comisiones.get(j).getCodigo().equalsIgnoreCase(id)) {
                    total += comisiones.get(j).calcularPrecioTotal();
                }
            }
        }
        return total;
    }

    public void guardarDatos() {
        Utilidades.UtilidadesFichero.grabarClientes(clientes);
        Utilidades.UtilidadesFichero.grabarComisiones(comisiones);
        Utilidades.UtilidadesFichero.grabarPedido(pedidos);
    }

    public HashMap<String, Double> mapa() {
        HashMap<String, Double> mapita = new HashMap();
        for (int i = 0; i < pedidos.size(); i++) {
            Double valor = null;
            String id = pedidos.get(i).getCodigoComision();
            for (int j = 0; j < comisiones.size(); j++) {
                if(comisiones.get(j).getCodigo().equalsIgnoreCase(id)){
                    valor = comisiones.get(j).calcularPrecioTotal();
                }
            }
            mapita.put(pedidos.get(i).getNicknameCliente(), valor);
        }
        return mapita;
    }

}
