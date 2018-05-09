/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;

/**
 *
 * @author Laura
 */
public class Digital extends Comision {

    private boolean animado;
    private boolean conCorrecciones;

    public Digital() {
    }

    public Digital(boolean animado, boolean conCorrecciones, String codigo, String titulo, String descripcion, int precioBase, boolean NSFW, String artist) {
        super(codigo, titulo, descripcion, precioBase, NSFW, artist);
        this.animado = animado;
        this.conCorrecciones = conCorrecciones;
    }

    public boolean isAnimado() {
        return animado;
    }

    public void setAnimado(boolean animado) {
        this.animado = animado;
    }

    public boolean isConCorrecciones() {
        return conCorrecciones;
    }

    public void setConCorrecciones(boolean conCorrecciones) {
        this.conCorrecciones = conCorrecciones;
    }

    /**
     * La comisión tendrá un precio final que varía de la siguiente forma: Si es
     * animada, se añade al precio base un 30% más sobre el precio base. Si se
     * quiere ver el paso a paso para pedir correcciones, se añade in 20% al
     * precio base. Si se quieren ambas modalidades se añade un 75% más sobre el
     * precio base.
     *
     * @return total a pagar por la comisión/dibujo dependiendo de sus
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

    @Override
    public String toString() {
        return super.toString() + ";" + animado + ";" + conCorrecciones;
    }

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
