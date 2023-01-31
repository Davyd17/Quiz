package datos.jugadordao;

import database.Conexion;
import datos.interfaces.InterfaceCrud;
import entidades.Jugador;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorCrud implements InterfaceCrud<Jugador>{

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;

    public JugadorCrud() {
        CON = Conexion.getInstance();
    }

    // CREATE
    @Override
    public boolean insertar(Jugador obj) {

        resp = false;

        String sql = "INSERT INTO jugador (usuario_id, nivel_id, puntos_acumulados) VALUES(?,?,?)";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, obj.getUsuarioId());
            pst.setInt(2, obj.getNivelId());
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

        Jugador jugador = null;

        String sql = "SELECT * FROM jugador WHERE usuario_id = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()){
                jugador = new Jugador(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getInt(4));
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

        return jugador;
    }

    // UPDATE
    @Override
    public boolean actualizar(Jugador obj) {

        String sql = "UPDATE jugador SET nivel_id = ?, puntos_acumulados = ? WHERE id = ?";

        try {

            pst = CON.conectar().prepareStatement(sql);

            pst.setInt(1, obj.getNivelId());
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
}
