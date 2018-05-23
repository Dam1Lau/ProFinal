/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 * Clase Digital. Subclase que extiende y hereda de la clase Comisión. Los
 * atributos que la diferencian son si es o no animado y si llevará o no
 * correcciones.
 *
 * @author Laura
 */
public class Digital extends Comision {

    private boolean animado;
    private boolean conCorrecciones;

    /**
     * Constructor vacio de la clase Digital. Crea una instancia inicializando
     * los atributos de la clase al valor por defecto.
     */
    public Digital() {
    }

    /**
     * Constructor de la clase Digital. Crea una instancia de la clase mediante
     * la introducción de todos sus atributos a través de los parámetros de
     * entrada del constructor. Los parámetros necesarios son los siguientes:
     *
     * @param animado tipo boolean. Si el producto es una animación el valor
     * será True, si no lo es, False.
     * @param conCorrecciones tipo boolean. Si el producto puede ser corregido
     * durante su creación el valor será True, en caso contrario False.
     * @param codigo tipo String. Código único, irrepetible que identifica a la
     * comsión.
     * @param titulo tipo String. Título identificativo de la comisión. Es
     * conveniente que contenga palabras descriptivas de la comisión.
     * @param descripcion tipo String. Descripción general de la comisión
     * @param precioBase tipo int. Precio base para una comsión general. Se
     * elige trabajar con int para que sea sencillo observar el precio base de
     * un solo vistazo.
     * @param NSFW tipo booleano. NSFW significa Not Safe For Work e identifica
     * si un trabajo digital, ilustración u obra tiene contenido adulto o no.
     *
     * <br>True: Tiene algun tipo de contenido adulto. <br>False: No tiene
     * contenido adulto.
     * @param artist tipo String. Nombre del artista que ha realizado la comsión
     * u obra.
     */
    public Digital(boolean animado, boolean conCorrecciones, String codigo, String titulo, String descripcion, int precioBase, boolean NSFW, String artist) {
        super(codigo, titulo, descripcion, precioBase, NSFW, artist);
        this.animado = animado;
        this.conCorrecciones = conCorrecciones;
    }

    /**
     * Método utilizado para obtener el valor del atributo animado de la clase
     * Digital.
     *
     * @return atributo animado de la Comisión Digital, tipo boolean. True si la
     * comisión digital es animada, False en caso contrario.
     */
    public boolean isAnimado() {
        return animado;
    }

    /**
     * Método utilizado para establecer el valor del atributo animado de la
     * clase Comisión Digital.
     *
     * @param animado tipo boolean. True si es una caomisión digital animada,
     * false en caso contrario.
     */
    public void setAnimado(boolean animado) {
        this.animado = animado;
    }

    /**
     * Método utilizado para obtener el valor del atributo conCorrecciones la
     * clase Comisión Digital.
     *
     * @return atributo conCorrecciones de la Comisión Digital, tipo boolean.
     * True si la comisión digital podrá tener correcciones del cliente durante
     * su creación, False en caso contrario.
     */
    public boolean isConCorrecciones() {
        return conCorrecciones;
    }

    /**
     * Método utilizado para establecer el valor del atributo conCorrecciones de
     * la clase Comisión Digital.
     *
     * @param conCorrecciones tipo boolean. True si la comisión digital podrá
     * tener correcciones del cliente durante su creación, False en caso
     * contrario.
     */
    public void setConCorrecciones(boolean conCorrecciones) {
        this.conCorrecciones = conCorrecciones;
    }

    /**
     * La comisión tendrá un precio final que varía de la siguiente forma:
     * <br>
     * Si es animada, se añade al precio base un 30% más sobre el precio base.
     * Si se quiere ver el paso a paso para pedir correcciones, se añade un 20%
     * al precio base. Si se quieren ambas modalidades se añade un 75% más sobre
     * el precio base.
     *
     * @return double. Total a pagar por la comisión/dibujo dependiendo de sus
     * caracteristicas.
     */
    @Override
    public double calcularPrecioTotal() {
        double total = super.getPrecioBase();
        if (animado == true && conCorrecciones == false) {
            total = total * 1.30;
        } else if (animado == false && conCorrecciones == true) {
            total = total * 1.20;
        } else if (this.animado && this.conCorrecciones) {
            total = total * 1.75;
        }
        return total;
    }

    /**
     * Método que genera un String con los atributos propios de la clase Comsión
     * Digital, separando cada uno de ellos por un punto y coma.
     *
     * @return String con los datos de los atributos propios de la clase
     * Digital.
     */
    @Override
    public String toString() {
        return super.toString() + ";" + animado + ";" + conCorrecciones;
    }

    /**
     * Método que sobreescribe al método toStringCompleto de la clase Comisión
     * de la que lo hereda. Genera un String con el valor de sus atributos tras
     * una frase o palabra que identifique a cada uno de ellos.
     *
     * @return String con los atributos de la clase Digital junto con los de la
     * clase Comisión de la que hereda atributos.
     */
    @Override
    public String toStringCompleto() {
        String esNSFW;
        if (super.isNSFW()) {
            esNSFW = "Si";
        } else {
            esNSFW = "No";
        }
        return "Codigo comisión: " + super.getCodigo() + ", titulo: " + super.getTitulo() + ", descripcion: " + super.getDescripcion() + ", Precio Base: " + super.getPrecioBase() + ", NSFW: " + esNSFW + ", Artista que dibuja: " + super.getArtist() + " Animación digital: " + this.animado + " Con correcciones en el proceso: " + this.conCorrecciones;
    }
}
