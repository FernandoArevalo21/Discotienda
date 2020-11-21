/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Johan
 */
@Named(value = "indexController")
@RequestScoped
public class IndexController {

    /**
     * Creates a new instance of IndexController
     */
    public IndexController() {
    }
    public void login() throws IOException {
       FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Login.xhtml");
    }
    public void registro() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Registrocomprador.xhtml");
    }
    
}
