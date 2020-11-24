/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import com.mycompany.proyectolinea.pojo.Album;
import com.mycompany.proyectolinea.pojo.Cancion;
import com.mycompany.proyectolinea.pojo.Comprador;
import com.mycompany.proyectolinea.pojo.datos;
import java.io.IOException;
import java.util.ArrayList;
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
@Named(value = "comprarcancionController")
@RequestScoped
public class ComprarcancionController {
      @Inject
   private LoginSession loginSession;
    private LoginController lr;
   private Cancion cancion = new Cancion();
   private ArrayList<Cancion> datos;
   private String cancionSeleccionado;
   private Cancion selectedCancion;

    /**
     * Creates a new instance of ComprarcancionController
     */
   @PostConstruct
   void init(){
       if(loginSession.getLlave()==null){
          try {
              FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/index.xhtml");
          } catch (IOException ex) {
              Logger.getLogger(ComprarcancionController.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
   }
    public ComprarcancionController() {
        Comprador comprador=new Comprador();   
        datos = comprador.verCancion();
    }
  
    
    public void ver(String datos,int dato){
        System.out.println("Entro:"+datos+" "+dato);
        
        datos dt= new datos();
        dt.cargarinformacion(lr.getCorreo(), datos, dato);
    }
    public void boton() throws IOException{
         FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Paginaprincipalcomprador.xhtml");
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public ArrayList<Cancion> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Cancion> datos) {
        this.datos = datos;
    }

    public String getCancionSeleccionado() {
        return cancionSeleccionado;
    }

    public void setCancionSeleccionado(String cancionSeleccionado) {
        this.cancionSeleccionado = cancionSeleccionado;
    }

    public Cancion getSelectedCancion() {
        return selectedCancion;
    }

    public void setSelectedCancion(Cancion selectedCancion) {
        this.selectedCancion = selectedCancion;
    }
    
}
