package com.mycompany.proyectolinea.pojo;

/**
 *
 * @author Johan
 */
public class Artista {

    private String nombreArtista;
    private String generoMusical;
    private String nacionalidad;
    private String fechaNacimiento;
    private String idArtista;

    public Artista() {
    }

    
    public Artista(String nombreArtista, String generoMusical, String nacionalidad, String fechaNacimiento, String idArtista) {
        this.nombreArtista = nombreArtista;
        this.generoMusical = generoMusical;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }

    
}
