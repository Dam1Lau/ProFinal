/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Utilidades.UtilidadesFichero;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Clase que contiene las lstas de comisiones, clientes y pedidos que se tienen
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

        clientes.add(new Cliente("Fro", "fro@gmail.com", "1234"));
        clientes.add(new Cliente("Bak", "boom@gmail.com", "4567"));
        clientes.add(new Cliente("Dek", "Oneforall@gmail.com", "8888"));
        clientes.add(new Cliente("Och", "gravityfalls@gmail.com", "9999"));
        clientes.add(new Cliente("Todo", "chicken@gmail.com", "9876"));
        
        comisiones.add(new Digital(false,false,"Retrato","Retrato hasta los hombros",20,false,"Juanita"));
        comisiones.add(new Digital(true,false,"Avatar animado","Avatar animado guiñando ojos.",10,false,"Fulanito"));
        comisiones.add(new Tradicional("Mediano",1,"Paisaje","Paisaje de cualquier lugar que soliciten.",50,false,"Pajares"));
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
     * de comisiones que estan registradas en la plataforma y la elimina de
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
     * de comisiones que estan registradas en la plataforma y permite editar
     * algunos de sus atributos. * dicho ArrayList.
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
                System.out.println("¿La comision tiene contenido NSFW?");
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
        clientes.add(clie);
        Utilidades.UtilidadesFichero.grabarClientes(clientes);
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

    }

    /**
     * Método encargado de buscar un objeto de tipo Cliente en el TreeSet de la
     * plataforma donde están registradas mediante su nickname para devolver el
     * objeto cuyo nickname sea el introducido por parámetro.
     *
     * @param nickname tipo String. Código que identifica al cliente y que se
     * usa para realizar la búsqueda de dicho objeto dentro de la plataforma.
     *
     * @return objeto de tipo Cliente.
     */
    public Cliente obtenerCliente(String nickname) {
        Cliente cli = null;
        return cli;
    }

    /**
     * Método que agrega un nuevo cpedido a la plataforma. Añade un objeto de
     * tipo Cliente al ArrayList de pedidos.
     *
     * @param ped Objeto de tipo Pedido.
     */
    public void agregarPedido(Pedido ped) {

    }

    /**
     * Método que busca un pedido determinado por su código en el ArrayList de
     * pedidos que estan registrados en la plataforma y lo elimina de dicho
     * ArrayList. Al eliminarse se graban los cambios en fichero.
     *
     * @param codigo tipo String. Código identificador del pedido a eliminar.
     */
    public void quitarPedido(String codigo) {

    }

    /**
     * Método que busca un pedido determinado por su código en el ArrayList de
     * pedidos que estan registrados en la plataforma y permite cambiar sus
     * atributos. Al editarse se graban los cambios en fichero.
     *
     * @param codigo tipo String. Código identificador del pedido a eliminar.
     */
    public void editarPedido(String codigo) {

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
        return ped;
    }

    /**
     * Método que muestra una lista de todas las comisiones cuyo precio base
     * corresponda con el parámetro introducido en el método.
     *
     * @param precio tipo double. Precio base que sirve de parámetro para
     * realizar la búsqueda en el ArrayList de Comisiones.
     */
    public void listarPorPrecio(double precio) {

    }

    /**
     * Método que muestra una lista de todas las comisiones cuyo precio base sea
     * igual o menos al parámetro introducido en el método.
     *
     * @param precio tipo double. Precio base que sirve de límite superior para
     * realizar la búsqueda en el ArrayList de Comisiones.
     */
    public void listarPrecioMenor(double precio) {

    }

    /**
     * Método que lista todas las comisiones a realizadas por un artista
     * determinado y que será buscado en el Arraylist de comisiones a través de
     * su nombre de artista.
     *
     * @param nombre tipo String. Nombre del artista que realiza esa comision y
     * que sirve como parámetro de búsqueda dentro del ArrayList de comisiones.
     */
    public void listarPorArtista(String nombre) {

    }

    /**
     * Método que lista los atributos de todas las comisiones cuyo título sea
     * igual al introducido mediante parámetro en el método. Busca las
     * coincidencias en cada comisión registrada en el ArrayList de comisiones
     * de la plataforma y las muestra por pantalla.
     *
     * Nota: El parámetro de entrada no sería necesario siempre que se encuentre
     * en la propia clase que contiene el ArrayList. En caso de trasladar el
     * método a otra clase sí es necesario el parámetro.
     *
     * @param titulo tipo String. Título de la comisión o comisiones que se
     * quieren listar por pantalla.
     */
    public void listarPorTitulo(String titulo) {

    }

    /**
     * Método que lista por pantalla el contenido completo del ArrayLit de
     * Pedidos, mostrando todos los pedidos que hay registrados hasta la fecha
     * con sus atributos.
     *
     * Nota: El parámetro de entrada no sería necesario siempre que se encuentre
     * en la propia clase que contiene el ArrayList. En caso de trasladar el
     * método a otra clase sí es necesario el parámetro.
     *
     * @param pedidos ArrayList compuesto de instancias de tipo Pedido.
     */
    public void listarPedidos(ArrayList<Pedido> pedidos) {

    }

    /**
     * Método que lista por pantalla el contenido completo del ArrayList de
     * comisiones, mostrando todas las comisiones que hay registradas hasta la
     * fecha con sus atributos.
     *
     * Nota: El parámetro de entrada no sería necesario siempre que se encuentre
     * en la propia clase que contiene el ArrayList. En caso de trasladar el
     * método a otra clase sí es necesario el parámetro.
     *
     * @param comisiones ArrayList compuesto de instancias de tipo Comision.
     */
    public void listarComisiones(ArrayList<Comision> comisiones) {

    }

    /**
     * Método que lista por pantalla el contenido completo del TreeSet de
     * clientes, mostrando todos los clientes que hay registrados hasta la fecha
     * con sus atributos.
     *
     * Nota: El parámetro de entrada no sería necesario siempre que se encuentre
     * en la propia clase que contiene el ArrayList. En caso de trasladar el
     * método a otra clase sí es necesario el parámetro.
     *
     * @param clientes
     */
    public void listarClientes(TreeSet<Cliente> clientes) {

    }

    /**
     * Método que calcula el total que ha ganada la plataforma mediante los
     * recibos que se han generado por la venta o adquisición de una comisión
     * por parte de un cliente. Para ello obtiene el identificador de la
     * comisión que aparece en cada recibo, busca la comison en concreto, y
     * calcula el precio final de cada comisión sumando finalmente los todos los
     * totales para dar el resultado total ganado por la plataforma.
     *
     * @param pedidos ArrayList compuesto de objetos de tipo Pedido.
     * @return double. Suma final de todos los precios totales de cada objeto
     * comisión referenciado en cada recibo por su código de identificación.
     */
    public double calcularTotalGanado(ArrayList<Pedido> pedidos) {
        double total = 0;

        return total;
    }

}
