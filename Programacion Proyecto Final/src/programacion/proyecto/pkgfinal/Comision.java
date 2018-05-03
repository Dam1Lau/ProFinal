package programacion.proyecto.pkgfinal;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Laura
 */
public abstract class Comision {

    private String codigo;
    private String titulo;
    private String descripcion;
    private int precioBase;
    private boolean NSFW;
    private String artist;

    public Comision() {
    }

    public Comision(String codigo, String titulo, String descripcion, int precioBase, boolean NSFW, String artist) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.NSFW = NSFW;
        this.artist = artist;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isNSFW() {
        return NSFW;
    }

    public void setNSFW(boolean NSFW) {
        this.NSFW = NSFW;
    }


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
        hash = 59 * hash + Objects.hashCode(this.titulo);
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
