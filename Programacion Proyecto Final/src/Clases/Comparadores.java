/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Comparator;

/**
 *
 * @author Laura
 */
public class Comparadores {
    /**
     * Criterio de comparación de comisiones por precio TOTAL, en orden ascendente
     * y criterio secundario de a igualdad de precio total, listar por titulo.
     */
    public static class comisionesPrecioTotal implements Comparator<Comision> {

        @Override
        public int compare(Comision uno, Comision dos) {
            double num = uno.calcularPrecioTotal() - dos.calcularPrecioTotal();
            if (num == 0) {
                num = uno.getTitulo().compareToIgnoreCase(dos.getTitulo());
            }
            return (int) Math.floor(num);
        }

    }

    /**
     * Criterio de comparación de clientes por nombre o nickname en orden
     * alfabetico.
     */
    public static class clientesNickname implements Comparator<Cliente> {

        @Override
        public int compare(Cliente t, Cliente t1) {
            return t.getNickname().compareToIgnoreCase(t1.getNickname());
        }

    }

    /**
     * Criterio de comparación de comisiones por Artista, en orden alfabético
     * natural y criterio secundario de a igualdad de artista, listar por precio
     * base.
     */
    public static class comisionesArtista implements Comparator<Comision> {

        @Override
        public int compare(Comision t, Comision t1) {
            int num = t.getArtist().compareToIgnoreCase(t1.getArtist());
            if (num == 0) {
                num = t.getPrecioBase() - t1.getPrecioBase();
            }
            return num;
        }

    }
}
