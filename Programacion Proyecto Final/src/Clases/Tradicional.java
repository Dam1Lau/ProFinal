/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;

/**
 ** Clase Tradicional. Subclase que extiende y hereda de la clase Comisión. Los
 * atributos que la diferencian son el tamaño de la obra y la zona de envío.
 *
 * @author Laura
 */
public class Tradicional extends Comision {

    private String tamano;
    private int zonaEnvio;

    /**
     * Constructor vacio de la clase Tradicional. Crea una instancia
     * inicializando los atributos de la clase al valor por defecto.
     */
    public Tradicional() {
        this.codigo = this.getClass().getSimpleName() + numeroCreadas;
    }

    /**
     * Constructor de la clase Tradicional. Crea una instancia de la clase
     * mediante la introducción de todos sus atributos a través de los
     * parámetros de entrada del constructor. Los parámetros necesarios son los
     * siguientes:
     *
     * @param tamano tipo String. Se identifica con los valores grande, mediano
     * o pequeño.
     * @param zonaEnvio tipo int. Zona a la que se puede envíar el producto.
     * Zona 1 se considera la Unión Europea, cualuiqe otra zona es envío
     * mundial.
     * @param titulo tipo String. Título identificativo de la comisión. Es
     * conveniente que contenga palabras descriptivas de la comisión.
     * @param descripcion tipo String. Descripción general de la comisión.
     * @param precioBase tipo int. Precio base para una comsión general. Se
     * elige trabajar con int para que sea sencillo observar el precio base de
     * un solo vistazo.
     * @param NSFW tipo booleano. NSFW significa Not Safe For Work e identifica
     * si un trabajo digital, ilustración u obra tiene contenido adulto o no.
     * <br>True: Tiene algun tipo de contenido adulto. <br>False: No tiene
     * contenido adulto.
     * @param artist tipo String. Nombre del artista que ha realizado la comsión
     * u obra.
     */
    public Tradicional(String titulo, String descripcion, int precioBase, boolean NSFW, String artist,String tamano, int zonaEnvio) {
        super(titulo, descripcion, precioBase, NSFW, artist);
        this.tamano = tamano;
        this.zonaEnvio = zonaEnvio;
        this.codigo = this.getClass().getSimpleName() + numeroCreadas;
    }

    /**
     * Método utilizado para obtener el valor del atributo animado de la clase
     * Tradicional.
     *
     * @return atributo tamaño de la Comisión Tradicional, tipo String. Tomará
     * en general los valores grande, mediano o pequeño.
     */
    public String gettamano() {
        return tamano;
    }

    /**
     * Método utilizado para establecer el valor del atributo tamaño de la clase
     * Tradicional
     *
     * @param tamano String con el tamaño de la Comisión Tradicional. Tomará en
     * general los valores grande, mediano o pequeño.
     */
    public void settamano(String tamano) {
        this.tamano = tamano;
    }

    /**
     * Método utilizado para obtener el valor del atributo zona de envío de la
     * clase Tradicional.
     *
     * @return atributo zonaEnvio de la Tradicional, tipo String. Tomará en
     * general los valores 1 si es Unión Europea, otro valor mayor a 1 si es envio
     * internacional.
     */
    public int getZonaEnvio() {
        return zonaEnvio;
    }

    /**
     * Método utilizado para establecer el valor del atributo zona de envío de
     * la clase Tradicional
     *
     * @param zonaEnvio int con el tipo de zona de envío. Tomará en general los
     * valores 1 si es Unión Europea, otro valor mayor a 1 si es envio internacional.
     */
    public void setZonaEnvio(int zonaEnvio) {
        this.zonaEnvio = zonaEnvio;
    }

    /**
     * La comisión tendrá un precio final que varía de la siguiente forma: Si el
     * tamaño del dibujo es grande, se observa la zona de envio y se añade una
     * cifra fija por la cercnía o lejanía del destino. De igual modo si no es
     * grande, se considera normal y se divide en tramos segun la zona de envio
     * añadiendo una cifra fija.
     *
     * @return total a pagar por la comisión/dibujo dependiendo de sus
     * caracteristicas.
     */
    @Override
    public double calcularPrecioTotal() {
        double total = super.getPrecioBase();
        if (tamano.equalsIgnoreCase("grande")) {
            if (this.zonaEnvio == 1) {
                total = total + 15;
            } else {
                total = total + 25;
            }
        } else {
            if (this.zonaEnvio == 1) {
                total = total + 10;
            } else {
                total = total + 15;
            }
        }
        return total;
    }

    /**
     * Método que genera un String con los atributos propios de la clase Comsión
     * Tradicional, separando cada uno de ellos por un punto y coma.
     *
     * @return String con los datos de los atributos propios de la clase
     * Tradicional.
     */
    @Override
    public String toString() {
        return super.toString() + ";" + tamano + ";" + zonaEnvio;
    }

    /**
     * Método que sobreescribe al método toStringCompleto de la clase Comisión
     * de la que lo hereda. Genera un String con el valor de sus atributos tras
     * una frase o palabra que identifique a cada uno de ellos.
     *
     * @return String con los atributos de la clase Tradicional junto con los de
     * la clase Comisión de la que hereda atributos.
     */
    @Override
    public String toStringCompleto() {
        String esNSFW;
        if (super.isNSFW()) {
            esNSFW = "Si";
        } else {
            esNSFW = "No";
        }
        return "Codigo comisión: " + super.getCodigo() + " |  Titulo: " + super.getTitulo() + " |  Descripcion: " + super.getDescripcion() + " |  Precio Base: " + super.getPrecioBase() + " |  NSFW: " + esNSFW + " |  Artista que dibuja: " + super.getArtist() + " |  Tamaño del papel: " + this.tamano + " |  Zona de envio número: " + this.zonaEnvio;
    }
}
