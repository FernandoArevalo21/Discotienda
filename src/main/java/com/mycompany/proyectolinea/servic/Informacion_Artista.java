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
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Informacion_Artista {
    conexion conexion = new conexion();
    Statement st;
    public void informacionArtista() {
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT*FROM artista");
            System.out.println("Consulta realizada");
            while (rs.next()) {
                int id_artista = rs.getInt("id_artista");
                String nombre_artista = rs.getString("nombre_artista");
                System.out.println(String.format("%s,%s", id_artista, nombre_artista));

            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
    }
    public List<String> listar(){
        List<String>lista = null;
        try {
            st = conexion.conexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT id_artista, nombre_artista FROM artista");
            System.out.println("Consulta realizada");
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(Integer.toString(rs.getInt("id_artista"))+" "+rs.getString("nombre_artista"));
                //lista.add(rs.getString("nombre_artista"));
            }
        } catch (SQLException e) {
            e.setNextException(e);
        }
        return lista;
    }
}
