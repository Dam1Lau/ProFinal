/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author dam1
 */
public class Pedido implements Serializable {
    private String idPedido;
    private String nicknameCliente;
    private String codigoComision;

    public Pedido() {
    }

    public Pedido(String idPedido, String nicknameCliente, String codigoComision) {
        this.idPedido = idPedido;
        this.nicknameCliente = nicknameCliente;
        this.codigoComision = codigoComision;
    }

    public String getidPedido() {
        return idPedido;
    }

    public void setidPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getNicknameCliente() {
        return nicknameCliente;
    }

    public void setNicknameCliente(String nicknameCliente) {
        this.nicknameCliente = nicknameCliente;
    }

    public String getCodigoComision() {
        return codigoComision;
    }

    public void setCodigoComision(String codigoComision) {
        this.codigoComision = codigoComision;
    }

    @Override
    public String toString() {
        return  idPedido + ";" + nicknameCliente + ";" + codigoComision;
    }
    
    public String toStringCompleto() {
        return  "Identificador del pedido: "+ idPedido + ", Nombre (nickname) del cliente: " + nicknameCliente + " Identificador de la comisión: " + codigoComision;
    }
    
}
