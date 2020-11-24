package com.mycompany.proyectolinea.pojo;

import com.mycompany.proyectolinea.conexion.conexion;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Johan
 */
public class ActualizarDatosAlbun {
    Statement st = null;
    conexion con = new conexion();
    public void actualizaArtista(ModificarAlbunPojo albun) throws SQLException, ClassNotFoundException {
        st = this.con.conexion().createStatement();
        String sql = "UPDATE albun SET nombre_albun = '" + albun.getNombreAlbun() + "' where id_albun = '"
                + albun.getIdAlbun() + "'";
        System.out.println(sql);
        st.executeUpdate(sql);
    }
}
