package datos;

import datos.interfaces.CrudSimpleInterface;
import database.Conexion;
import entidades.Usuario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Clase UsuarioDAO que se encarga de comunicarse con la base de datos, especificamente la tabla usuario, implementando el patron Data Acces Object.

// Se implementa la interface CrudSimpleInterface, esta brinda los metodos para realizar un CRUD simple y asi acceder a los datos de la tabla Usuario

public class UsuarioDAO implements CrudSimpleInterface<Usuario>{

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp; //Variable que almacena el restultado de la operacion

    public UsuarioDAO() {
        CON = Conexion.getInstance(); // Se inicializa la variable CON responsable de obtener la instancia para obtener la conexion con la base de datos
    }

    // metodo que se encarga de consultar si coincide o no el usuario ingresado (LogIn)
    public boolean consultar(Usuario obj){

        try{

            pst = CON.conectar().prepareStatement("SELECT nombre_usuario, contraseña FROM usuario WHERE nombre_usuario = ? and contraseña = ?");
            pst.setString(1, obj.getNombreUsuario());
            pst.setString(2, obj.getContrasena());
            rs = pst.executeQuery();

            if (rs.next()){
                resp = true;
            }

            pst.close();
            rs.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
            rs = null;
        }

        return resp;
    }

    @Override
    public List<Usuario> listar(int index) {
        List<Usuario> registro = new ArrayList<>();

        try {

            pst = CON.conectar().prepareStatement("SELECT * FROM usuario");
            rs = pst.executeQuery();

            while (rs.next()){
                registro.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(4)));
            }

            pst.close();
            rs.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            pst = null;
            rs = null;
            CON.desconectar();
        }


        return registro;
    }

    @Override
    public boolean insertar(Usuario obj) {

        try {

            pst = CON.conectar().prepareStatement("INSERT INTO usuario VALUES(?,?,?,?)");
            pst.setInt(1, obj.getUsuarioId());
            pst.setString(2, obj.getNombreUsuario());
            pst.setString(3, obj.getContrasena());
            pst.setInt(4, obj.getRolId());

            if (pst.executeUpdate() > 0){
                this.resp = true;
            }

            pst.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
        }

        return resp;
    }

    @Override
    public boolean actualizar(Usuario obj) {

        try{

            pst = CON.conectar().prepareStatement("UPDATE usuario set usuario_id = ?, nombre_usuario = ?, contraseña = ?, rol_id = ? WHERE usuario_id = ?");

            pst.setInt(1, obj.getUsuarioId());
            pst.setString(2, obj.getNombreUsuario());
            pst.setString(3, obj.getContrasena());
            pst.setInt(4, obj.getRolId());
            pst.setInt(5, obj.getUsuarioId());

            if (pst.executeUpdate() > 0){
                resp = true;
            }

            pst.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
        }

        return resp;
    }

    @Override
    public boolean existe(String texto){
        this.resp = false;

        try{

            pst = CON.conectar().prepareStatement("SELECT nombre_usuario FROM usuario WHERE nombre = ?");
            pst.setString(1, texto);
            rs = pst.executeQuery();

            if(rs.getRow() > 0){
                this.resp = true;
            }

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
