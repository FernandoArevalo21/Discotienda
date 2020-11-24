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
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Johan
 */
@Named(value = "compradorController")
@Dependent
public class CompradorController {
    /**
     * Creates a new instance of CompradorController
     */
    public CompradorController() {
    }
    public void comprarAlbun() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Paginaprincipalcomprador.xhtml");
    }
    public void comprarCancion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ProyectoLinea/faces/Comprarcancion.xhtml");
    }
}
