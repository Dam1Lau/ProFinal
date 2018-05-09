/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Laura
 */
public class Plataforma {
    ArrayList <Comision> comisiones = new ArrayList();
    TreeSet <Cliente> clientes = new TreeSet();

    public Plataforma() {
        clientes.add(new Cliente("Froggy","fro@gmail.com","1234"));
        clientes.add(new Cliente("Bakugo","boom@gmail.com","4567"));
        clientes.add(new Cliente("Deku","Oneforall@gmail.com","8888"));
        clientes.add(new Cliente("Ochako","gravityfalls@gmail.com","9999"));
        clientes.add(new Cliente("Todoroki","chicken@gmail.com","9876"));

    }

    public ArrayList<Comision> getComisiones() {
        return comisiones;
    }

    public void setComisiones(ArrayList<Comision> comisiones) {
        this.comisiones = comisiones;
    }

    public TreeSet<Cliente> getclientes() {
        return clientes;
    }

    public void setclientes(TreeSet<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    
}
