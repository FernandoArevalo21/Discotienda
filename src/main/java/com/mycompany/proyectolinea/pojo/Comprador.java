/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.pojo;

import com.mycompany.proyectolinea.conexion.conexion;
import com.mycompany.proyectolinea.controller.PaginaprincipalController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author usuario
 */
public class Comprador {
  conexion conexion = new conexion();
    Statement st;
    public List<Album> verAlbum(){
       List<Album> lista = null;
          try {
              System.out.println("conexion");
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT albun.nombre_albun,albun.precio_albun, artista.nombre_artista\n" +
            "FROM albun RIGHT JOIN artista\n" +
            "ON albun.id_artista=artista.id_artista\n" +
            "ORDER BY albun.id_albun");
            System.out.println("Consulta realizada");
               lista = new ArrayList();
            while (rs.next()) {
                Album album = new Album();
                album.setNombre_albun(rs.getString("nombre_albun"));
                album.setPrecio_albun(rs.getInt("precio_albun"));
                album.setNombre_artista(rs.getString("nombre_artista"));
                lista.add(album);
            }     
            
        } catch (SQLException e) {
            e.setNextException(e);
        }
         return lista;
    }
}

