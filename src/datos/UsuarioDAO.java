package datos;

import datos.interfaces.CrudSimpleInterface;
import database.Conexion;
import entidades.Administrador;
import entidades.Jugador;
import entidades.Usuario;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Usuario iniciarSesion(String nombreUsuario, String contrasena){
        Connection con;
        Usuario usuario = null;

        try{

            con = CON.conectar();
            pst = con.prepareStatement("SELECT id, nombre_usuario, contraseña, rol FROM usuario WHERE nombre_usuario = ? AND contraseña = ?");
            pst.setString(1, nombreUsuario);
            pst.setString(2, contrasena);
            rs = pst.executeQuery();

            if(rs.next()){
                if(rs.getInt(4) == 1) {
                    pst = con.prepareStatement("SELECT u.id, a.id AS administrador_id, u.nombre_usuario FROM usuario u INNER JOIN administrador a ON u.id = a.usuario_id;");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        usuario = new Administrador(rs.getInt(1), rs.getInt(2), rs.getString(3));
                    }

                } else if (rs.getInt(4) == 2){
                    pst = con.prepareStatement("SELECT u.id, j.id AS jugador_id, u.nombre_usuario, j.nivel_id, j.puntos_acumulados FROM usuario u INNER JOIN jugador j ON u.id = j.usuario_id\n" + "");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        usuario = new Jugador(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                    }
                }
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

        return usuario;
    }

    @Override
    public List<Usuario> listar() {
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

        Connection con = null;
        try {
            con = CON.conectar();
            con.setAutoCommit(false);

            pst = con.prepareStatement("INSERT INTO usuario (nombre_usuario,contraseña,rol) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNombreUsuario());
            pst.setString(2, obj.getContrasena());
            pst.setInt(3, obj.getRol());

            int filasAfectadas = pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            int idGenerado = 0;

            if(rs.next()){
                idGenerado = rs.getInt(1);
            }

            if(filasAfectadas == 1){
                if (obj.getRol() == 1){
                    pst = con.prepareStatement("INSERT INTO administrador (usuario_id) VALUES (?)");
                    pst.setInt(1, idGenerado);
                    resp = pst.executeUpdate() > 0;
                    con.commit();

                } else if (obj.getRol() == 2){
                    pst = con.prepareStatement("INSERT INTO jugador (usuario_id) VALUES (?)");
                    pst.setInt(1,idGenerado);
                    resp = pst.executeUpdate() > 0;
                    con.commit();
                }

            } else {
                con.rollback();
            }

        } catch(SQLException e){

                JOptionPane.showMessageDialog(null, e.getMessage());


        } finally {
            try{

                if(pst != null){
                    pst.close();
                }

                if(rs != null){
                    pst.close();
                }

                if (con != null){
                    con.close();
                }

            }catch(SQLException e){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
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
            pst.setInt(4, obj.getRol());
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

            pst = CON.conectar().prepareStatement("SELECT nombre_usuario FROM usuario WHERE nombre_usuario = ?");
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
