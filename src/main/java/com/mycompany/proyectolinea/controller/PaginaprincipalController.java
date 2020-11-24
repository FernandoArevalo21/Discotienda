/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.pojo.Album;
import com.mycompany.proyectolinea.pojo.Comprador;
import com.mycompany.proyectolinea.pojo.datos;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author usuario
 */
@Named(value = "paginaprincipalController")
@RequestScoped
public class PaginaprincipalController {
      @Inject
    private LoginSession loginSession;
    private LoginController lr;
   private Album album = new Album();
   private List<Album> datos;
   private String artistaSeleccionado;
   private Album selectedAlbum;
    /**
     * Creates a new instance of PaginaprincipalController
     */
    @PostConstruct
    void init(){
        if(loginSession.getLlave()==null){
          try {
              FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/index.xhtml");
          } catch (IOException ex) {
              Logger.getLogger(PaginaprincipalController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    public PaginaprincipalController() {
    Comprador comprador=new Comprador();   
    datos=comprador.verAlbum();
    
    }
    public void mostrar(String datos,int dato){
        System.out.println("Entro"+" "+datos+" "+dato);
        datos dt= new datos();
        dt.cargarinformacion(lr.getCorreo(), datos, dato);
    }
    public void boton() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Comprarcancion.xhtml");
    }
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Album> getDatos() {
        return datos;
    }

    public void setDatos(List<Album> datos) {
        this.datos = datos;
    }

    public String getArtistaSeleccionado() {
        return artistaSeleccionado;
    }

    public void setArtistaSeleccionado(String artistaSeleccionado) {
        this.artistaSeleccionado = artistaSeleccionado;
    }

    public Album getSelectedAlbum() {
        return selectedAlbum;
    }

    public void setSelectedAlbum(Album selectedAlbum) {
        this.selectedAlbum = selectedAlbum;
    }
}
