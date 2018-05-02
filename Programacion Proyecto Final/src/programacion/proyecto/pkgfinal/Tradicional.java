/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.proyecto.pkgfinal;

import java.util.Arrays;

/**
 *
 * @author Laura
 */
public class Tradicional extends Comision {

    private String tamano;
    private int zonaEnvio;

    public Tradicional() {
    }

    public Tradicional(String tamano, int zonaEnvio, String codigo, String titulo, String descripcion, int fecha, int precioBase, boolean NSFW, String[] galeria, Artista artist) {
        super(codigo, titulo, descripcion, fecha, precioBase, NSFW, galeria, artist);
        this.tamano = tamano;
        this.zonaEnvio = zonaEnvio;
    }

    public String gettamano() {
        return tamano;
    }

    public void settamano(String tamano) {
        this.tamano = tamano;
    }

    public int getZonaEnvio() {
        return zonaEnvio;
    }

    public void setZonaEnvio(int zonaEnvio) {
        this.zonaEnvio = zonaEnvio;
    }
/**
 * La comisión tendrá un precio final que varía de la siguiente forma:
 *      Si el tamaño del dibujo es grande, se observa la zona de envio y se añade una cifra fija por
 *      la cercnía o lejanía del destino. De igual modo si no es grande, se considera normal y se divide en 
 *      tramos segun la zona de envio añadiendo una cifra fija.
 * @return total a pagar por la comisión/dibujo dependiendo de sus caracteristicas.
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
                total = total  + 15;
            }
        }
        return total;
    }
    
        @Override
    public String toString() {
        return super.toString() + ";" + tamano + ";" + zonaEnvio;
    }
    
        @Override
    public String toStringCompleto() {
        String esNSFW;
        if (super.isNSFW()) {
            esNSFW = "Si";
        } else {
            esNSFW = "No";
        }
        return "Codigo comisión: " + super.getCodigo() + ", titulo: " + super.getTitulo() + ", descripcion: " + super.getDescripcion() + ", año creación: " + super.getFecha() + ", Precio Base: " + super.getPrecioBase() + ", NSFW: " + esNSFW + ", Galeria de imágenes: " + Arrays.toString(super.getGaleria()) + ", Artista que dibuja: " + super.getArtist() + " Tamaño del papel: " + this.tamano + " Zona de envio número: " + this.zonaEnvio;
    }
}
