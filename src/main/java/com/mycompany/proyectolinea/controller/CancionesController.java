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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author usuario
 */
@Named(value = "cancionesController")
@RequestScoped
public class CancionesController {
    @Inject
   private LoginSession loginSession;
    private String nombre_cancion;
    private int precio_cancion;
    private String albunSeleccionado;
    private List<String> listaAlbun;
    private String id_album;
    /**
     * Creates a new instance of CancionesController
     */
    @PostConstruct
    void init(){
        if(loginSession.getLlave()==null){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CancionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    public CancionesController() {
        nombre_cancion=null;
        precio_cancion=0;
        albunSeleccionado=null;
        listaAlbun=null;
        id_album=null;
        Informacion_Artista artista = new Informacion_Artista();
        listaAlbun = artista.listarAlbun();
    }
    public void registrocancion() throws IOException{
        System.out.println("Entro"+nombre_cancion+""+precio_cancion);  
        String id_albums = albunSeleccionado;
        String[] parts = id_albums.split(" ");
         id_album = parts[0]; 
        datos dt= new datos();
         dt.cargarCanciones(nombre_cancion,precio_cancion,id_album);
          FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Administrador.xhtml");
    }
    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public int getPrecio_cancion() {
        return precio_cancion;
    }

    public void setPrecio_cancion(int precio_cancion) {
        this.precio_cancion = precio_cancion;
    }

    public String getAlbunSeleccionado() {
        return albunSeleccionado;
    }

    public void setAlbunSeleccionado(String albunSeleccionado) {
        this.albunSeleccionado = albunSeleccionado;
    }

    public List<String> getListaAlbun() {
        return listaAlbun;
    }

    public void setListaAlbun(List<String> listaAlbun) {
        this.listaAlbun = listaAlbun;
    }
    
    
}
