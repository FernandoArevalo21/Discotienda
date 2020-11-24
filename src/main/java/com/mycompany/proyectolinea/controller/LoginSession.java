/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
@Named(value = "loginSession")
@SessionScoped
public class LoginSession implements Serializable {

       private String llave;
    /**
     * Creates a new instance of LoginSession
     */
    public LoginSession() {
        System.out.println("Se ha creado este objeto"+llave);
        this.llave=null;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }
    
}
