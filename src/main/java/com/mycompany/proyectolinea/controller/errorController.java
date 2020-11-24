/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author usuario
 */
@Named(value = "errorController")
@RequestScoped
public class errorController {
    private Object Facescontext;

    /**
     * Creates a new instance of errorController
     */
    public errorController() {
    }
   public String getStatuscode (){
       String val=String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.status_code"));
       
      return val;
   }
}
