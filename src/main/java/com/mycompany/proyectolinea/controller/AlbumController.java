/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.pojo.datos;
import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.io.IOException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author usuario
 */
@Named(value = "albumController")
@RequestScoped
public class AlbumController {

    private String nombre_album;
    private int precio_album;
    private String artistaSeleccionado;
    private String id_artista;

    public String getArtistaSeleccionado() {
        return artistaSeleccionado;
    }

    public void setArtistaSeleccionado(String artistaSeleccionado) {
        this.artistaSeleccionado = artistaSeleccionado;
    }
    private List<String> listaArtista;

    public List<String> getListaArtista() {
        return listaArtista;
    }

    public void setListaArtista(List<String> listaArtista) {
        this.listaArtista = listaArtista;
    }

    /**
     * Creates a new instance of AlbumController
     */
    public AlbumController() {
        Informacion_Artista artista = new Informacion_Artista();
        listaArtista = artista.listar();
    }

    public void registroalbum() throws ClassNotFoundException, IOException {
        System.out.println("Entro" + " " + nombre_album + " " + precio_album+" "+artistaSeleccionado);  
        String id_artistas = artistaSeleccionado;
        String[] parts = id_artistas.split(" ");
         id_artista = parts[0]; 
        Informacion_Artista ifa = new Informacion_Artista();
        ifa.informacionArtista();
        datos dt= new datos();
         dt.cargarAlbum(nombre_album,precio_album,id_artista);
          FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Administrador.xhtml");
    }

    public void mostrarDatos() {
        Informacion_Artista artista = new Informacion_Artista();
        listaArtista = artista.listar();
        System.out.println("EL tamaño de la lista es: " + listaArtista.size());
        for (String datos : listaArtista) {
            System.out.println("Los Datos son: " + datos);
        }
    }

    public String getNombre_album() {
        return nombre_album;
    }

    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public int getPrecio_album() {
        return precio_album;
    }

    public void setPrecio_album(int precio_album) {
        this.precio_album = precio_album;
    }

}
