package modelo.datos.mysql;

import modelo.database.ConexionMySQL;
import modelo.datos.interfaces.UsuarioDAO;
import modelo.entidades.Administrador;
import modelo.entidades.Jugador;
import modelo.entidades.Usuario;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Clase en la que se implementa el patron DAO para acceder a los datos de la entidad Usuario.

// Se implementa la interface InterfaceCrudForeignKey, esta brinda los metodos para realizar un CRUD simple.

public class MySQLUsuarioDAO implements UsuarioDAO {

    private final ConexionMySQL CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private Usuario entidad;
    private boolean resp;  //Variable que almacena la respuesta de la operacion

    public MySQLUsuarioDAO() {
        CON = ConexionMySQL.getInstance(); // Se inicializa la variable CON responsable de obtener la instancia para obtener la conexion con la base de datos.
    }


    //CREATE
    @Override
    public boolean insertar(Usuario obj) {

        int idGenerado = 0;
        int filasAfectadas = 0;

        String sql = "INSERT INTO usuario (nombre_usuario,contraseña,rol) VALUES(?,?,?)";

        try {

            pst = CON.conectar().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNombreUsuario());
            pst.setString(2, obj.getContrasena());
            pst.setInt(3, obj.getRol());

            filasAfectadas = pst.executeUpdate();
            rs = pst.getGeneratedKeys();

            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }

            pst.close();
            rs.close();


        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {

           pst = null;
           rs = null;
           CON.desconectar();
        }

        if(filasAfectadas > 0){
            resp = false;
            if (obj.getRol() == 1){

                Administrador administrador = new Administrador();
                administrador.setUsuarioId(idGenerado);

                MySQLAdministradorDAO datos = new MySQLAdministradorDAO();
                resp = datos.insertar(administrador);

            } else if(obj.getRol() == 2){

                Jugador jugador = new Jugador();
                jugador.setUsuarioId(idGenerado);
                jugador.setNivelId(1);
                jugador.setPuntosAcumulados(0);

                MySQLJugadorDAO datos = new MySQLJugadorDAO();
                resp = datos.insertar(jugador);
            }
        }

        return resp;
    }

    //READ
    @Override
    public Usuario obtener(int id) {

        Usuario usuario = null;

        String sql = "SELECT * FROM usuario WHERE id = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()){
                usuario = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }

            rs.close();
            pst.close();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            CON.desconectar();
            rs = null;
            pst = null;
        }
        return usuario;
    }

    //READ
    // Metodo que se encarga de retornar una lista con todos los registros de la tabla usuario
    @Override
    public List<Usuario> obtenerTodos() {


        List<Usuario> registros = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try {

            pst = CON.conectar().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()){
                registros.add(new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }

            pst.close();
            rs.close();


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            rs = null;
            pst = null;
        }

        return registros;
    }

    //UPDATE
    @Override
    public boolean actualizar(Usuario obj) {

        String sql = "UPDATE usuario set usuario_id = ?, nombre_usuario = ?, contraseña = ?, rol_id = ? WHERE usuario_id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);

            pst.setInt(1, obj.getId());
            pst.setString(2, obj.getNombreUsuario());
            pst.setString(3, obj.getContrasena());
            pst.setInt(4, obj.getRol());
            pst.setInt(5, obj.getId());

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
    public boolean eliminar() {
        return false;
    }

    // METODOS ADICIONALES
    @Override
    public Usuario iniciarSesion(String nombreUsuario, String contrasena) {


        String sql = "SELECT * FROM usuario WHERE nombre_usuario = BINARY ? and contraseña = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setString(1,nombreUsuario);
            pst.setString(2,contrasena);
            rs = pst.executeQuery();

            if(rs.next()) entidad = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            pst = null;
            rs = null;
            CON.desconectar();
        }
        return entidad;
    }

    @Override
    public boolean existe(String texto) {

        String sql = "SELECT nombre_usuario FROM usuario WHERE nombre_usuario = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
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
