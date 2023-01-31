package datos.usuariodao;

import database.Conexion;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistenciaUsuario {

    private final Conexion CON;

    public ExistenciaUsuario(){
        CON = Conexion.getInstance();
    }

    public boolean encontrar(String texto){
        boolean resp = false;

        ResultSet rs;
        PreparedStatement pst;
        try{

            pst = CON.conectar().prepareStatement("SELECT nombre_usuario FROM usuario WHERE nombre_usuario = ?");
            pst.setString(1, texto);
            rs = pst.executeQuery();

            resp = rs.next();

            pst.close();
            rs.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            rs = null;
            pst = null;
        }

        return resp;
    }
}
