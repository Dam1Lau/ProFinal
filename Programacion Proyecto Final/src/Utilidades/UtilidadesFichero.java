/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Clases.Cliente;
import Clases.Comision;
import Clases.Pedido;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que agrupa todas las funcionalidades relacioandas con la carga y
 * grabado de datos en ficheros de diversa clase. Ficheros de datos y ficheros
 * de texto. Las rutas o nombres de los ficheros están definidas como static
 * final al comienzo de la clase.
 *
 * @author Laura
 */
public class UtilidadesFichero {

    private static final String datosComisiones = "comisiones.dat";
    private static final String datosClientes = "clientes.dat";
    private static final String datosPedidos = "factura.dat";

    /**
     * Método que graba los datos de las comisiones almacenadas en la plataforma
     * en un fichero de datos.
     *
     * @param comisiones ArrayList compuesto de instancias de clase Comision.
     * ArrayList con todas las comisiones que hay registradas en la plataforma
     * en el momento del grabado de datos en el fichero.
     */
    public static void grabarComisiones(ArrayList<Comision> comisiones) {
        try {
            ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(new File(datosComisiones)));
            for (int i = 0; i < comisiones.size(); i++) {
                ou.writeObject(comisiones.get(i));
            }
            ou.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que graba los datos de los clientes almacenados en la plataforma
     * en un fichero de datos.
     *
     * @param clientes ArrayList compuesto de instancias de clase Cliente.
     * ArrayList con todas los clientes que hay registradas en la plataforma en
     * el momento del grabado de datos en el fichero.
     */
    public static void grabarClientes(TreeSet<Cliente> clientes) {
        try {
            ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(new File(datosClientes)));
            Iterator<Cliente> it = clientes.iterator();
            while (it.hasNext()) {
                Cliente aux = (Cliente) it.next();
                ou.writeObject(aux);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que graba los datos de los pedidos almacenadas en la plataforma en
     * un fichero de datos.
     *
     * @param pedidos ArrayList compuesto de instancias de clase Pedido.
     * ArrayList con todos los pedidos que hay registradas en la plataforma en
     * el momento del grabado de datos en el fichero.
     */
    public static void grabarPedido(ArrayList<Pedido> pedidos) {
        try {
            ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(new File(datosPedidos)));
            for (int i = 0; i < pedidos.size(); i++) {
                ou.writeObject(pedidos.get(i));
            }
            ou.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que obtiene un ArrayList compuesto de de objetos de tipo Comision
     * a partir de un fichero de datos para posteriormente cargaros en la
     * plataforma y poder actuar sobre ellos.
     *
     * @return ArrayList compuesto de instancias de la clase Comision.
     */
    public static ArrayList<Comision> cargarComisiones() {
        ArrayList<Comision> aux = new ArrayList();
        boolean finalFichero = false;
        try {
            ObjectInputStream ou = new ObjectInputStream(new FileInputStream(new File(datosComisiones)));
            try {
                while (finalFichero == false) {
                    try {
                        aux.add((Comision) ou.readObject());
                    } catch (EOFException e) {
                        finalFichero = true;
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
            ou.close();

        } catch (IOException ex) {
            Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

    /**
     * Método que obtiene un ArrayList compuesto de de objetos de tipo Cliente a
     * partir de un fichero de datos para posteriormente cargaros en la
     * plataforma y poder actuar sobre ellos.
     *
     * @return ArrayList compuesto de instancias de la clase Cliente.
     */
    public static TreeSet<Cliente> cargarClientes() {
        TreeSet<Cliente> aux = new TreeSet();
        boolean finalFichero = false;
        try {
            ObjectInputStream ou = new ObjectInputStream(new FileInputStream(new File(datosComisiones)));
            try {
                while (finalFichero == false) {
                    try {
                        aux.add((Cliente) ou.readObject());
                    } catch (EOFException e) {
                        finalFichero = true;
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
            ou.close();

        } catch (IOException ex) {
            Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

    /**
     * Método que obtiene un ArrayList compuesto de de objetos de tipo Pedido
     * a partir de un fichero de datos para posteriormente cargaros en la
     * plataforma y poder actuar sobre ellos.
     *
     * @return ArrayList compuesto de instancias de la clase Pedido.
     */
    public static ArrayList<Pedido> cargarPedidos() {
        ArrayList<Pedido> aux = new ArrayList();
        boolean finalFichero = false;
        try {
            ObjectInputStream ou = new ObjectInputStream(new FileInputStream(new File(datosComisiones)));
            try {
                while (finalFichero == false) {
                    try {
                        aux.add((Pedido) ou.readObject());
                    } catch (EOFException e) {
                        finalFichero = true;
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
            ou.close();

        } catch (IOException ex) {
            Logger.getLogger(UtilidadesFichero.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

}
