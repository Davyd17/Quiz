package modelo.datos.mysql;

import modelo.database.ConexionMySQL;
import modelo.datos.interfaces.JugadorDAO;
import modelo.entidades.Jugador;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLJugadorDAO implements JugadorDAO {

    private final ConexionMySQL CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;
    private Jugador entidad;

    public MySQLJugadorDAO() {
        CON = ConexionMySQL.getInstance();
    }

    // CREATE
    @Override
    public boolean insertar(Jugador obj) {

        resp = false;

        String sql = "INSERT INTO jugador (usuario_id, nivel, puntos_acumulados) VALUES(?,?,?)";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, obj.getUsuarioId());
            pst.setInt(2, obj.getNivel());
            pst.setInt(3, obj.getPuntosAcumulados());

            resp = pst.executeUpdate() > 0;

            pst.close();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
        }
        return resp;
    }

    //READ
    @Override
    public Jugador obtener(int id) {

        String sql = "SELECT * FROM jugador WHERE id = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()){
                entidad = new Jugador(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getInt(4));
            }

            pst.close();
            rs.close();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
            rs = null;
        }

        return entidad;
    }

    @Override
    public List<Jugador> obtenerTodos() {

        return null;
    }

    // UPDATE
    @Override
    public boolean actualizar(Jugador obj) {

        String sql = "UPDATE jugador SET nivel = ?, puntos_acumulados = ? WHERE id = ?";

        try {

            pst = CON.conectar().prepareStatement(sql);

            pst.setInt(1, obj.getNivel());
            pst.setInt(2, obj.getPuntosAcumulados());
            pst.setInt(3, obj.getId());

            if (pst.executeUpdate() > 0) {
                resp = true;
            }

            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    @Override
    public Jugador obtenerPorUsuario(int usuarioId) {

        String sql = "SELECT * FROM jugador WHERE usuario_id = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, usuarioId);
            rs = pst.executeQuery();

            if (rs.next()){
                entidad = new Jugador(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getInt(4));
            }

            pst.close();
            rs.close();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
            rs = null;
        }

        return entidad;
    }
}
