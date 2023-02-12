package datos.mysql;

/*
Clase MySQLNivelDAO que se encargara de acceder a los datos del objeto nivel, esta a su vez implementa la interface InterfaceCrudForeignKey
que contiene la guia para realizar un crud simple al objeto
*/

import datos.interfaces.DAO;
import datos.interfaces.mysql.NivelDAO;
import entidades.Nivel;
import database.ConexionMySQL;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLNivelDAO implements NivelDAO{

    private final ConexionMySQL CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;
    private Nivel nivel;

    public MySQLNivelDAO(){
        CON = ConexionMySQL.getInstance();
    }

    // Metodo que consulta los datos de un nivel en especifico

    @Override
    public Nivel obtener(int id){

        String sql = "SELECT * FROM nivel WHERE id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();

            if(rs.next()){
                nivel = new Nivel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
            }

            pst.close();
            rs.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            CON.desconectar();
            pst = null;
            rs = null;
        }

        return nivel;

    }

    @Override
    public List<Nivel> obtenerTodos() {

        List<Nivel> registros = new ArrayList<>();

        String sql = "SELECT * FROM nivel";

        try {

            pst = CON.conectar().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()){
                registros.add(new Nivel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
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

    @Override
    public boolean insertar(Nivel obj) {

        try{
            pst = CON.conectar().prepareStatement("INSERT INTO nivel (categoria, puntos, dificultad) VALUES(?,?,?)");
            pst.setString(1, obj.getCategoria());
            pst.setInt(2, obj.getPuntos());
            pst.setString(3,obj.getDificultad());

            resp = pst.executeUpdate() > 0;

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
    public boolean actualizar(Nivel obj) {

        try {
            pst = CON.conectar().prepareStatement("UPDATE nivel SET categoria = ?, puntos = ?, dificultad = ? WHERE id = ?");
            pst.setString(1, obj.getCategoria());
            pst.setInt(2, obj.getPuntos());
            pst.setString(3, obj.getDificultad());
            pst.setInt(4, obj.getId());

            resp = pst.executeUpdate() > 0;

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
    public boolean existe(int id) {

        String sql = "SELECT id FROM nivel WHERE id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
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
