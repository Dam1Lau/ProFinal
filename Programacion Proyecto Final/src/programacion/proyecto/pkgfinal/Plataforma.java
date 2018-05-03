/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.proyecto.pkgfinal;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Laura
 */
public class Plataforma {
    ArrayList <Comision> comisiones = new ArrayList();
    TreeSet <Cliente> artistas = new TreeSet();

    public Plataforma() {
        artistas.add(new Cliente("Froggy","fro@gmail.com","1234"));
        artistas.add(new Cliente("Bakugo","boom@gmail.com","4567"));
        artistas.add(new Cliente("Deku","Oneforall@gmail.com","8888"));
        artistas.add(new Cliente("Ochako","gravityfalls@gmail.com","9999"));
        artistas.add(new Cliente("Todoroki","chicken@gmail.com","9876"));
        
        
        //comisiones.add(new Comision("C001","Retrato","Retrato de un personaje o persona hasta los hombros.",2018,15,false,{"abcd.jpg","def.jpg"}, ));
    }

    public ArrayList<Comision> getComisiones() {
        return comisiones;
    }

    public void setComisiones(ArrayList<Comision> comisiones) {
        this.comisiones = comisiones;
    }
    
    
    
    
}
