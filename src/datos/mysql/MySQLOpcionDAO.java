package datos.mysql;

import database.ConexionMySQL;
import datos.interfaces.mysql.OpcionDAO;
import entidades.Opcion;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOpcionDAO implements OpcionDAO {

    private final ConexionMySQL CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private Opcion opcion;
    private boolean resp;


    public MySQLOpcionDAO(){
        CON = ConexionMySQL.getInstance();
    }

    //READ
    @Override
    public Opcion obtener(int id) {

        String sql = "SELECT * FROM opcion WHERE id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while(rs.next()){
                opcion = new Opcion(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getBoolean(4));
            }

            pst.close();
            rs.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            CON.desconectar();
            pst = null;
            rs = null;
        }
        return opcion;
    }


    @Override
    public List<Opcion> obtenerTodos() {

        List<Opcion> registros = new ArrayList<>();

        String sql = "SELECT * FROM opcion";

        try{

            pst = CON.conectar().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) registros.add(new Opcion(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getBoolean(4)));

            pst.close();
            rs.close();


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
            rs = null;
        }
        return registros;
    }

    //CREATE
    @Override
    public boolean insertar(Opcion obj) {

        String sql = "INSERT INTO opcion (pregunta_id,contenido,respuesta) VALUES (?,?,?)";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1,obj.getPreguntaId());
            pst.setString(2, obj.getContenido());
            pst.setBoolean(3, obj.isRespuesta());

            if(pst.executeUpdate() > 0){
                resp = true;
            }

            pst.close();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally {
            CON.desconectar();
            pst = null;
        }
        return resp;
    }

    //UPDATE
    @Override
    public boolean actualizar(Opcion obj) {

        String sql = "UPDATE opcion SET contenido = ?, respuesta = ? WHERE id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setString(1, obj.getContenido());
            pst.setBoolean(2,obj.isRespuesta());
            pst.setInt(2, obj.getId());


            if(pst.executeUpdate() > 0){
                resp = true;
            }

            pst.close();

        }catch(SQLException e){
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
    public ArrayList<Opcion> ObtenerListaPorPregunta(int preguntaId) {

        ArrayList<Opcion> registros = new ArrayList<>();

        String sql = "SELECT * FROM opcion WHERE pregunta_id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, preguntaId);
            rs = pst.executeQuery();

            while (rs.next()) registros.add(new Opcion(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getBoolean(4)));

            pst.close();
            rs.close();


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
            rs = null;
        }
        return registros;
    }
}
