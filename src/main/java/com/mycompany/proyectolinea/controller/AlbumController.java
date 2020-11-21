/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.servic.Informacion_Artista;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

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

    public void registroalbum() throws ClassNotFoundException {
        System.out.println("Entro" + " " + nombre_album + " " + precio_album+" "+artistaSeleccionado);
        Informacion_Artista ifa = new Informacion_Artista();
        ifa.informacionArtista();
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
