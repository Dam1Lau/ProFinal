/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.proyecto.pkgfinal;

/**
 *
 * @author Laura
 */
public class Artista {
    private String codigoArtista;
    private String nickname;
    private String email;
    private String password;

    public Artista() {
    }

    public Artista(String codigoArtista, String nickname, String email, String password) {
        this.codigoArtista = codigoArtista;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public String getCodigoArtista() {
        return codigoArtista;
    }

    public void setCodigoArtista(String codigoArtista) {
        this.codigoArtista = codigoArtista;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  codigoArtista + "," + nickname + "," + email + "," + password;
    }
    
    public String toStringCompleto() {
        return  "ID artista: " + codigoArtista + "  Nombre Artista: " + nickname + "  Email registro: " + email + "  Contraseña: " + password;
    }
    
}
