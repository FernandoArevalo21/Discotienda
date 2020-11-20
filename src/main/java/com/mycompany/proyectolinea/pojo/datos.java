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
 * @author usuario
 */
public class datos {

    conexion conexion = new conexion();
    Statement st;

    public void cargarDatosComprador(String nombre, String apellido, String correo, String username, String password){
        try {
            System.out.println(nombre);
            st = conexion.conexion().createStatement();
            String query = "INSERT INTO comprador(nombre,apellido,correo,username, password) VALUES ('" + nombre + "','" + apellido + "','" + correo + "','" + username + "','" + password + "')";
            st.executeUpdate(query);
            System.out.println("Usuario ingresado");
        } catch (SQLException e) {
            e.setNextException(e);
        }
    }
     public void cagarDatosArtista(String nombre_artista, String genero_musical, String imagen, String nacionalidad, String fecha_nacimiento){
        try{
           st= conexion.conexion().createStatement();
            String query= "INSERT INTO artista(nombre_artista,genero_musical,imagen,nacionalidad, fecha_nacimiento) VALUES ('"+nombre_artista+"','"+genero_musical+"','"+imagen+"','"+nacionalidad+"','"+fecha_nacimiento+"')";
            System.out.println(query);
        st.executeUpdate(query);
          System.out.println("Usuario ingresado");  
        }catch(SQLException e){
            e.setNextException(e);
        }
           
      }
     public void cargarDatosAdmin(String nombre, String apellido, String correo, String username, String password){
        try {
            System.out.println(nombre);
            st = conexion.conexion().createStatement();
            String query = "INSERT INTO admin(nombre,apellido,correo,username, password) VALUES ('" + nombre + "','" + apellido + "','" + correo + "','" + username + "','" + password + "')";
            st.executeUpdate(query);
            System.out.println("Usuario ingresado");
        } catch (SQLException e) {
            e.setNextException(e);
        }
    }
}
