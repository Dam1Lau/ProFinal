package Clases;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * Clase Comisión. Las comisiones son el producto (obra de arte, ilustración)
 * que se compra y ofrece en la plataforma.
 * <br>
 * Contiene una serie de atributos que serán comunes a las clases que heredan de
 * ella. Además contiene un método abstracto cuyo cálculo será delegado a las
 * subclases que herdan de el.
 *
 * @author Laura
 */
public abstract class Comision implements Serializable {

    private String codigo;
    private String titulo;
    private String descripcion;
    private int precioBase;
    private boolean NSFW;
    private String artist;

    /**
     * Constructor vacio de la clase comision. Crea una instancia inicializando
     * los atributos de la clase al valor por defecto.
     */
    public Comision() {
    }

    /**
     * Constructor de la clase comisión. Crea una instancia de la clase pidiendo
     * mediante la introducción de todos los atributos a través de los
     * parámetros de entrada del constructor. Los parámetros necesarios son los
     * siguientes:
     *
     * @param codigo tipo String. Código único, irrepetible que identifica a la
     * comsión.
     * @param titulo tipo String. Título identificativo de la comisión. Es
     * conveniente que contenga palabras descriptivas de la comisión.
     * @param descripcion tipo String. Descripción general de la comisión
     * @param precioBase tipo int. Precio base para una comsión general. Se
     * elige trabajar con int para que sea sencillo obervar el precio base de un
     * solo vistazo.
     * @param NSFW tipo booleano. NSFW significa Not Safe For Work e identifica
     * si un trabajo digital, ilustración u obra tiene contenido adulto o no.
     * <br>True: Tiene algun tipo de contenido adulto. <br>False: No tiene
     * contenido adulto.
     * @param artist tipo String. Nombre del artista que ha realizado la comsión
     * u obra.
     */
    public Comision(String codigo, String titulo, String descripcion, int precioBase, boolean NSFW, String artist) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.NSFW = NSFW;
        this.artist = artist;
    }

    /**
     * Método utilizado para obtener el valor del atributo código de la clase
     * Comisión.
     *
     * @return codigo de la comisión, tipo String. Devuelve el contenido del
     * atributo código.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método utilizado para obtener el valor del atributo título de la clase
     * Comisión.
     *
     * @return título de la comisión, tipo String. Devuelve el contenido del
     * atributo título.
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método utilizado para obtener el valor del atributo descripción de la
     * clase Comisión.
     *
     * @return descripción de la comisión, tipo String. Devuelve el contenido
     * del atributo descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }
/**
 * Método utilizado para establecer el valor del atributo descripción de la
 * clase Comisión.
 * @param descripcion tipo string. Titulo que se quiere establecer en el atributo título.
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método utilizado para obtener el valor del atributo precio base de la
     * clase Comisión.
     *
     * @return precio base de la comisión, tipo int. Devuelve el contenido del
     * atributo precioBase.
     */
    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Método utilizado para obtener el valor del atributo NSFW de la clase
     * Comisión.
     *
     * @return atributo NSFW de la comisión, tipo boolean. True si tiene
     * contenido NSFW, false en caso contrario.
     */
    public boolean isNSFW() {
        return NSFW;
    }

    public void setNSFW(boolean NSFW) {
        this.NSFW = NSFW;
    }

    /**
     * Método utilizado para obtener el valor del atributo artista de la clase
     * Comisión.
     *
     * @return nombre del artista que ha creado la comisión, tipo String.
     * Devuelve el contenido del atributo artista.
     */
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     *
     * @return double - Precio total de la comision a realizar, dependiendo de
     * ciertos factores que varían según la subclase o tipo del que se trate
     * cada comisión.
     */
    public abstract double calcularPrecioTotal();

    @Override
    public String toString() {
        return codigo + ";" + titulo + ";" + descripcion + ";" + precioBase + ";=" + NSFW + ";" + ";" + artist.toString();
    }

    public abstract String toStringCompleto();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

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
        final Comision other = (Comision) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

}
