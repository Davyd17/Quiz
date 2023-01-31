package datos.usuariodao;

import database.Conexion;
import entidades.Usuario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioInicioSesion {

    private final Conexion CON;

    public UsuarioInicioSesion(){
        CON = Conexion.getInstance();
    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasena){

        PreparedStatement pst;
        ResultSet rs;
        Usuario entidad = null;

        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? and contraseña = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setString(1,nombreUsuario);
            pst.setString(2,contrasena);
            rs = pst.executeQuery();

            if(rs.next()) entidad = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            pst = null;
            rs = null;
            CON.desconectar();
        }
        return entidad;
    }
}
