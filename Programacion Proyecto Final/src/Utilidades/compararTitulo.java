/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Clases.Comision;
import java.util.Comparator;

/**
 *
 * @author Laura
 */
public class compararTitulo implements Comparator<Comision> {

    @Override
    public int compare(Comision t, Comision t1) {
        return t.getTitulo().compareToIgnoreCase(t1.getTitulo());
    }
    
    
}
