/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.pojo;

import com.mycompany.proyectolinea.conexion.conexion;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Johan
 */
public class ActualizarArtista {
    Statement st = null;
    conexion con = new conexion();
    public void actualizaArtista(Artista artista) throws SQLException, ClassNotFoundException {
        st = this.con.conexion().createStatement();
        String sql = "UPDATE artista SET nombre_artista = '" + artista.getNombreArtista() + "' where id_artista = '"
                + artista.getIdArtista() + "'";
        System.out.println(sql);
        st.executeUpdate(sql);
    }
    
}
