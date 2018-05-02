package programacion.proyecto.pkgfinal;

import java.util.Arrays;

/**
 *
 * @author Laura
 */
public abstract class Comision {

    private String codigo;
    private String titulo;
    private String descripcion;
    private int fecha;
    private int precioBase;
    private boolean NSFW;
    private String[] galeria;
    private Artista artist;

    public Comision() {
    }

    public Comision(String codigo, String titulo, String descripcion, int fecha, int precioBase, boolean NSFW, String[] galeria, Artista artist) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precioBase = precioBase;
        this.NSFW = NSFW;
        this.galeria = galeria;
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

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
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

    public String[] getGaleria() {
        return galeria;
    }

    public void setGaleria(String[] galeria) {
        this.galeria = galeria;
    }

    public Artista getArtist() {
        return artist;
    }

    public void setArtist(Artista artist) {
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
        return codigo + ";" + titulo + ";" + descripcion + ";" + fecha + ";" + precioBase + ";=" + NSFW + ";" + Arrays.toString(galeria) + ";" + artist.toString();
    }

    public abstract String toStringCompleto();

}
