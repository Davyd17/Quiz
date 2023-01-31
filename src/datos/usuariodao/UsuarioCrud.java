package datos.usuariodao;

import datos.administradordao.AdministradorCrud;
import datos.jugadordao.JugadorCrud;
import datos.interfaces.InterfaceCrud;
import database.Conexion;
import entidades.Administrador;
import entidades.Jugador;
import entidades.Usuario;

import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Clase en la que se implementa el patron DAO para acceder a los datos de la entidad Usuario.

// Se implementa la interface InterfaceCrud, esta brinda los metodos para realizar un CRUD simple.

public class UsuarioCrud implements InterfaceCrud<Usuario> {

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp; //Variable que almacena la respuesta de la operacion

    public UsuarioCrud() {
        CON = Conexion.getInstance(); // Se inicializa la variable CON responsable de obtener la instancia para obtener la conexion con la base de datos.
    }


    //CREATE
    @Override
    public boolean insertar(Usuario obj) {

        int idGenerado = 0;
        int filasAfectadas = 0;

        try {

            pst = CON.conectar().prepareStatement("INSERT INTO usuario (nombre_usuario,contraseña,rol) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
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

                AdministradorCrud datos = new AdministradorCrud();
                resp = datos.insertar(administrador);

            } else if(obj.getRol() == 2){

                Jugador jugador = new Jugador();
                jugador.setUsuarioId(idGenerado);
                jugador.setNivelId(1);
                jugador.setPuntosAcumulados(0);

                JugadorCrud datos = new JugadorCrud();
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

    //UPDATE
    @Override
    public boolean actualizar(Usuario obj) {

        try{

            pst = CON.conectar().prepareStatement("UPDATE usuario set usuario_id = ?, nombre_usuario = ?, contraseña = ?, rol_id = ? WHERE usuario_id = ?");

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
}
