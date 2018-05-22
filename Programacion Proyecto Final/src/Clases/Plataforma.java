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
    ArrayList <Pedido> pedidos = new ArrayList();

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

    public TreeSet<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(TreeSet<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void agregarComision(Comision comi){
    
    }
    
    public  void quitarComision(String codigo){
    
    }
    
    public void editarComision(String codigo) {
    
    }
    
    public Comision obtenerComision(String codigo){
        Comision com = null;
        return com;
    }
    
    public void agregarCliente(Cliente clie){
    
    }
    
    public  void quitarCliente(String codigo){
    
    }
    
    public void editarCliente(String codigo) {
    
    }
    
    public Cliente obtenerCliente(String codigo){
        Cliente cli = null;
        return cli;
    }
    
    public void agregarPedido(Pedido ped){
    
    }
    
    public  void quitarPedido(String codigo){
    
    }
    
    public void editarPedido(String codigo) {
    
    }
    
    public Cliente obtenerPedido(String codigo){
        Cliente ped = null;
        return ped;
    }
    
    public void listarPorPrecio(double precio){
    
    }
    
    public void listarPrecioMenor(double precio){
    
    }
    
    public void listarPorArtista(String nombre){
    
    }
    
    public void listarPorTitulo(String titulo){
    
    }
    
    public void listarPedidos(ArrayList<Pedido> pedidos){
    
    }
    
    public void listarComisiones(ArrayList<Comision> comisiones){
    
    }
    
    public void listarClientes(TreeSet<Cliente> clientes){
    
    }
    
    public double calcularTotalGanado(ArrayList<Pedido> pedidos){
    double total = 0;
    
    return total;
    }
    
    
}
