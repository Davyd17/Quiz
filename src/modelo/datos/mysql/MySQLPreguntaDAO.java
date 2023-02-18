package modelo.datos.mysql;

import modelo.database.ConexionMySQL;
import modelo.datos.interfaces.DAO;
import modelo.datos.interfaces.PreguntaDAO;
import modelo.entidades.Pregunta;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLPreguntaDAO implements PreguntaDAO {

    private final ConexionMySQL CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;
    private Pregunta pregunta;

    public MySQLPreguntaDAO(){
        CON = ConexionMySQL.getInstance();
        resp = false;
    }


    @Override
    public Pregunta obtener(int id) {

        String sql = "SELECT * FROM pregunta WHERE id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while(rs.next()){
                pregunta = new Pregunta(rs.getInt(1),rs.getInt(2),rs.getString(3));
            }

            pst.close();
            rs.close();

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally{
            CON.desconectar();
            pst = null;
            rs = null;
        }

        return pregunta;
    }

    @Override
    public List<Pregunta> obtenerTodos() {

        List<Pregunta> registros = new ArrayList<>();

        String sql = "SELECT * FROM pregunta";

        try{

            pst = CON.conectar().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) registros.add(new Pregunta(rs.getInt(1),rs.getInt(2), rs.getString(3)));

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



    @Override
    public boolean insertar(Pregunta obj) {

        String sql = "INSERT INTO pregunta (nivel_id,contenido) VALUES (?,?)";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1,obj.getNivelId());
            pst.setString(2,obj.getContenido());

            if(pst.executeUpdate() > 0){
                resp = true;
            }

            pst.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } finally{
            CON.desconectar();
            pst = null;
        }
        return resp;
    }

    @Override
    public boolean actualizar(Pregunta obj) {

        String sql = "UPDATE pregunta set contenido = ? where id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setString(1, obj.getContenido());
            pst.setInt(2, obj.getId());

            if(pst.executeUpdate() > 0){
                resp = true;
            }

            pst.close();

        } catch (SQLException e){
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

    //METODOS ADICIONALES

    @Override
    public ArrayList<Pregunta> obtenerListaPorNivel(int nivelId) {

        ArrayList<Pregunta> registros = new ArrayList<>();

        String sql = "SELECT * FROM pregunta WHERE nivel_id = ?";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, nivelId);
            rs = pst.executeQuery();

            while (rs.next()) registros.add(new Pregunta(rs.getInt(1),rs.getInt(2), rs.getString(3)));

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
