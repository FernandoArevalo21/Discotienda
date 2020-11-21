/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectolinea.servic;

import com.mycompany.proyectolinea.conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Informacion_album {
    conexion conexion = new conexion();
    Statement st;
    public void informacionAlbum() {
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT*FROM albun");
            System.out.println("Consulta realizada");
            while (rs.next()) {
                int id_albun = rs.getInt("id_albun");
                String nombre_albun = rs.getString("nombre_albun");
                System.out.println(String.format("%s,%s", id_albun, nombre_albun));

            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
    }
    public List<String> listar(){
        List<String>lista = null;
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_albun, nombre_albun FROM artista");
            System.out.println("Consulta realizada");
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(Integer.toString(rs.getInt("id_albun"))+" "+rs.getString("nombre_albun"));
                //lista.add(rs.getString("nombre_artista"));
            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
        return lista;
    }
}

