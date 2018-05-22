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
 *
 * @author Laura
 */
public class UtilidadesFichero {

    private static final String datosComisiones = "comisiones.dat";
    private static final String datosClientes = "clientes.dat";
    private static final String datosPedidos = "factura.dat";

    private void grabarComisiones(ArrayList<Comision> comisiones) {
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

    private void grabarClientes(TreeSet<Cliente> clientes) {
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
    
    private void grabarPedido(ArrayList<Pedido> pedidos) {
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

    private ArrayList<Comision> cargarComisiones() {
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

    private TreeSet<Comision> cargarClientes() {
        TreeSet<Comision> aux = new TreeSet();
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
    
    private ArrayList<Pedido> cargarPedidos() {
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
