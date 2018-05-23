/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Clases.Comision;
import Clases.Digital;
import Clases.Tradicional;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase teclado con las utilidades necesarias para pedir al usuario una serie
 * de datos por teclado. Aglutina las clases que requieran de preguntar al
 * usuario algun tipo de dato, pregunta, menú de creación...
 *
 * @author Laura
 */
public class Teclado {

    /**
     * Método que obtiene de teclado un número y comprueba que aquello que se
     * introduce sea efectivamente un dígito correcto y no un símbolo, letra u
     * otro caracter.
     *
     * @return int, número entero.
     */
    public static int pedirNumero() {
        int numero = 0;
        boolean esNumero = false;
        Scanner lector = new Scanner(System.in);
        while (esNumero == false) {
            try {
                numero = lector.nextInt();
                esNumero = true;
            } catch (InputMismatchException e) {
                System.out.println("Dato incorecto. Introduce un número porfavor.");
            }
        }
        return numero;
    }

    /**
     * Método que obtiene de teclado un número con decimales y comprueba que
     * aquello que se introduce sea efectivamente un dígito correcto y no un
     * símbolo, letra u otro caracter.
     *
     * @return double, número con decimales.
     */
    public static int pedirPrecio() {
        int precio = 0;
        boolean esCorrecta = false;
        Scanner lector = new Scanner(System.in);
        while (esCorrecta == false) {
            try {
                do {
                    System.out.println("Introduce un precio: (mínimo 5€)");
                    precio = lector.nextInt();
                    esCorrecta = true;
                } while (precio < 5);
            } catch (InputMismatchException e) {
                System.out.println("Dato incorecto. Introduce un número porfavor.");
            }
        }
        return precio;
    }

    /**
     * Método que pide al usuario que responda si o no ante una pregunta que se le
     * ha debido plantear anteriormente a la llamada del mismo y que retornará un
     * booleando según la opción elegida.
     *
     * @return boolean. True si elige 1(Si), false si elige 2(No).
     */
    public static boolean pedirBoolean() {
        boolean opcion;
        System.out.println("1. Si  2. No");
        int numero = 0;
        while (numero != 1 && numero != 2) {
            numero = Teclado.pedirNumero();
        }
        if (numero == 1) {
            opcion = true;
        } else {
            opcion = false;
        }
        return opcion;
    }

    public static Comision crearComision() {
        Scanner lector = new Scanner(System.in);
        System.out.println("========== DATOS PARA CREAR UNA NUEVA COMISIÓN ============");
        System.out.println("Código de la comisión:");
        String cod = lector.nextLine();
        System.out.println("Título de la comisión:");
        String tit = lector.nextLine();
        System.out.println("Descripción del dibujo/producto:");
        String des = lector.nextLine();
        System.out.println("Precio base (minimo 5€):");
        int pre = pedirPrecio();
        System.out.println("¿Puede ser de contenido adulto la ilustración a encargar?");
        boolean nsfw = pedirBoolean();
        System.out.println("Artista que vende la comisión:");
        String artist = lector.nextLine();
        System.out.println("¿Ilustracion hecha por medio Digital o Tradicional? 1. Digital 2. Tradicional");
        int opcion;
        do {
            opcion = Teclado.pedirNumero();
        } while (opcion != 1 && opcion != 2);
        Comision comi;
        if (opcion == 1) {
            System.out.println("¿Es una ilustracion animada? 1.Si   2.No");
            boolean anim = pedirBoolean();
            System.out.println("¿Se enviarán los bocetos previos para hacer correcciones o solo el producto final?  1. Con correcciones   2. Solo el producto final.");
            boolean correc = pedirBoolean();
            comi = new Digital(anim, correc, cod, tit, des, pre, nsfw, artist);
        } else {
            System.out.println("Tamaño del papel o soporte a usar: (Grande, mediano, pequeño");
            String tamano = lector.nextLine();
            System.out.println("Zona de envio que desea abarcar: 1. UE  2. Internacional.");
            int zona = 0;
            do {
                zona = Teclado.pedirNumero();
            } while (zona != 1 && zona != 2);
            comi = new Tradicional(tamano, zona, cod, tit, des, pre, nsfw, artist);
        }
        return comi;
    }
}
