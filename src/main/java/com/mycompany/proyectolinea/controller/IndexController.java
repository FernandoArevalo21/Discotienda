/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Johan
 */
@Named(value = "indexController")
@RequestScoped
public class IndexController {
    @Inject
    private LoginSession loginSession;
    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
       
        
    }
    @PostConstruct
    public void init(){
         System.out.println("Se crea el objetoIndex"+loginSession.getLlave());
    }
    public void login() throws IOException {
       FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Login.xhtml");
    }
    public void registro() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Registrocomprador.xhtml");
    }
    
}
