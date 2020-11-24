/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.pojo;

/**
 *
 * @author Johan
 */
public class ModificarAlbunPojo {
    private String nombreAlbun;
    private String precioAlbun;
    private String idAlbun;

    public ModificarAlbunPojo() {
    }

    public ModificarAlbunPojo(String nombreAlbun, String precioAlbun, String idAlbun) {
        this.nombreAlbun = nombreAlbun;
        this.precioAlbun = precioAlbun;
        this.idAlbun = idAlbun;
    }

    public String getNombreAlbun() {
        return nombreAlbun;
    }

    public void setNombreAlbun(String nombreAlbun) {
        this.nombreAlbun = nombreAlbun;
    }

    public String getPrecioAlbun() {
        return precioAlbun;
    }

    public void setPrecioAlbun(String precioAlbun) {
        this.precioAlbun = precioAlbun;
    }

    public String getIdAlbun() {
        return idAlbun;
    }

    public void setIdAlbun(String idAlbun) {
        this.idAlbun = idAlbun;
    }
}
