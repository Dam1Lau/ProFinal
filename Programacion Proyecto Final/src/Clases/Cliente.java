/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase cliente. Un cliente se caracteriza por su nickname que debe ser único,
 * un email y una contraseña que da acceso a sus datos.
 *
 * @author Laura
 */
public class Cliente implements Serializable {

    private String nickname;
    private String email;
    private String password;
    

    /**
     * Constructor vacio de la clase cliente. Crea una instancia inicializando
     * los atributos de la clase al valor por defecto.
     */
    public Cliente() {
        
    }

    /**
     * Constructor de la clase cliente. Crea una instancia de la clase mediante
     * la introducción de todos sus atributos a través de los parámetros de
     * entrada del constructor. Los parámetros necesarios son los siguientes:
     *
     * @param nickname tipo String. Debe ser un identificador único de cada
     * cliente, sin poder repetirse en otro cliente.
     * @param email tipo String. Email del cliente para poder ponerse en
     * contacto con él. Es necesario rellenar éste atributo.
     * @param password tipo String. Contraseña de acceso del cliente a sus
     * datos. Puede contener números y letras.
     */
    public Cliente(String nickname, String email, String password) {
        this.nickname = nickname;  //Debe ser único y no repetirse en ningún otro cliente.
        this.email = email;
        this.password = password;
    }

    /**
     * Método utilizado para obtener el valor del atributo nickname de la clase
     * Cliente.
     *
     * @return nickname del Cliente, tipo String. Devuelve el contenido del
     * atributo nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Método utilizado para obtener el valor del atributo email de la clase
     * Cliente.
     *
     * @return email del cliente, tipo String. Devuelve el contenido del
     * atributo email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método utilizado para establecer el valor del atributo email de la clase
     * Cliente.
     *
     * @param email del cliente, tipo String. Debe contener el formato correcto
     * para un email (@ y dominio).
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método utilizado para obtener el valor del atributo password de la clase
     * Cliente.
     *
     * @return password del cliente, tipo String. Devuelve el contenido del
     * atributo password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método utilizado para establecer el valor del atributo contraseña de la
     * clase Cliente.
     *
     * @param password del cliente, tipo String. Puede contener números y
     * letras.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método que genera un String con los atributos de la clase Cliente,
     * separando cada uno de ellos por un punto y coma.
     *
     * @return String con los datos de los atributos clase Cliente.
     */
    @Override
    public String toString() {
        return nickname + "," + email + "," + password;
    }

    /**
     * Método que genera un String con el valor de sus atributos tras una frase
     * o palabra que identifique a cada uno de ellos.
     *
     * @return String con los atributos de la clase precedidos por una palabra
     * identificativa de cada uno de ellos.
     */
    public String toStringCompleto() {
        return "Nombre Artista: " + nickname + "  Email registro: " + email + "  Contraseña: " + password;
    }

    /**
     * Método que genera un código hash para cada instancia de la clase Cliente.
     *
     * @return int. Devuelve un número generado usando el atributo nickname de
     * la clase Cliente.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nickname);
        return hash;
    }

    /**
     * Método equals para comparar si dos objetos son iguales comparando sus
     * atributos nickname.
     *
     * @param obj objeto a comparar por su atributo nickname.
     * @return True si ambos objetos comparados son iguales, false si no son
     * iguales.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        return true;
    }

}
