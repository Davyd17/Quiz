package modelo.datos.mysql;

/*
Clase MySQLNivelDAO que se encargara de acceder a los datos del objeto nivel, esta a su vez implementa la interface InterfaceCrudForeignKey
que contiene la guia para realizar un crud simple al objeto
*/

import modelo.datos.interfaces.NivelDAO;
import modelo.entidades.Nivel;
import modelo.database.ConexionMySQL;

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
    private Nivel entidad;

    public MySQLNivelDAO(){
        CON = ConexionMySQL.getInstance();
    }

    // Metodo que consulta los datos de un nivel en especifico

    @Override
    public Nivel obtener(int nivel){

        String sql = "SELECT * FROM nivel WHERE nivel = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1,nivel);
            rs = pst.executeQuery();

            if(rs.next()){
                entidad = new Nivel(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getInt(4),rs.getString(5));
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

        return entidad;

    }

    @Override
    public List<Nivel> obtenerTodos() {

        List<Nivel> registros = new ArrayList<>();

        String sql = "SELECT * FROM nivel";

        try {

            pst = CON.conectar().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()){
                registros.add(new Nivel(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getInt(4),rs.getString(5)));
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
            pst = CON.conectar().prepareStatement("INSERT INTO nivel (nivel, categoria, puntos, dificultad) VALUES(?,?,?,?)");
            pst.setInt(1, obj.getNivel());
            pst.setString(2, obj.getCategoria());
            pst.setInt(3, obj.getPuntos());
            pst.setString(4,obj.getDificultad());

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
            pst = CON.conectar().prepareStatement("UPDATE nivel SET nivel = ?, categoria = ?, puntos = ?, dificultad = ? WHERE nivel = ?");
            pst.setInt(1, obj.getNivel());
            pst.setString(2, obj.getCategoria());
            pst.setInt(3, obj.getPuntos());
            pst.setString(4,obj.getDificultad());
            pst.setInt(5, obj.getNivel());

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
    public boolean existe(int nivel) {

        String sql = "SELECT nivel FROM nivel WHERE nivel = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, nivel);
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
