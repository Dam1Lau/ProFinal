/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 * Clase pedido. La clase pedido se genera cuando un cliente adquiere una
 * comisión. Para generar el pedido se necesita generar un código único para
 * cada pedido, y almacenar el nickname del cliente que lo genera, así como el
 * código de la comisión que adquiere.
 *
 * @author Laura
 */
public class Pedido implements Serializable {

    private String idPedido;
    private String nicknameCliente;
    private String codigoComision;
    
    public static int numPedidosGenerados;

    /**
     * Constructor vacio de la clase Pedido. Crea una instancia inicializando
     * los atributos de la clase al valor por defecto.
     */
    public Pedido() {
        numPedidosGenerados++;
        this.idPedido = this.getClass().getSimpleName() + numPedidosGenerados;
    }

    /**
     * Constructor de la clase Pedido. Crea una instancia de la clase mediante
     * la introducción de todos sus atributos a través de los parámetros de
     * entrada del constructor. Los parámetros necesarios son los siguientes:
     *
     * @param idPedido tipo String. Código único e identificador de cada pedido.
     * No debe repetirse en ningún otro pedido.
     * @param nicknameCliente tipo String. Nickname del cliente que ha generado
     * el pedido.
     * @param codigoComision tipo String. Código identificador de la comisión
     * que ha adquirido el cliente y que genera el pedido.
     */
    public Pedido(String idPedido, String nicknameCliente, String codigoComision) {
        this();
        this.nicknameCliente = nicknameCliente;
        this.codigoComision = codigoComision;
    }

    /**
     * Método utilizado para obtener el valor del atributo id de pedido de la
     * clase Pedido.
     *
     * @return identificador del pedido, tipo String. Devuelve el contenido del
     * atributo idPedido.
     */
    public String getidPedido() {
        return idPedido;
    }

    /**
     * Método utilizado para obtener el valor del atributo nickname del cliente
     * de la clase Pedido.
     *
     * @return nombre o nickname del cliente, tipo String. Devuelve el contenido
     * del atributo nicknameCliente que ha generado el pedido.
     */
    public String getNicknameCliente() {
        return nicknameCliente;
    }

    /**
     * Método utilizado para obtener el valor del atributo nickname del cliente
     * de la clase Pedido.
     *
     * @return nombre o nickname del cliente, tipo String. Devuelve el contenido
     * del atributo nicknameCliente que ha generado el pedido.
     */
    public String getCodigoComision() {
        return codigoComision;
    }

    /**
     * Método que genera un String con los atributos de la clase Pedido,
     * separando cada uno de ellos por un punto y coma.
     *
     * @return String con los datos de los atributos clase Pedido.
     */
    @Override
    public String toString() {
        return idPedido + ";" + nicknameCliente + ";" + codigoComision;
    }

    /**
     * Método que genera un String con el valor de los atributos de la clase
     * pedido tras una frase o palabra que identifique a cada uno de ellos.
     *
     * @return String con los atributos del Pedido.
     */
    public String toStringCompleto() {
        return "Identificador del pedido: " + idPedido + ", Nombre (nickname) del cliente: " + nicknameCliente + " Identificador de la comisión: " + codigoComision;
    }

}
