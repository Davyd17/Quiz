package datos;

import database.Conexion;
import datos.interfaces.CrudJuegoInterface;
import entidades.Pregunta;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PreguntaDAO implements CrudJuegoInterface<Pregunta> {

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;
    private Pregunta pregunta;

    public PreguntaDAO(){
        CON = Conexion.getInstance();
        resp = false;
    }


    @Override
    public Pregunta mostrar(int id) {

        try{

            pst = CON.conectar().prepareStatement("SELECT * FROM pregunta WHERE id = ?");
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
    public List<Pregunta> listar() {
        return null;
    }

    @Override
    public boolean insertar(Pregunta obj) {

        try{

            pst = CON.conectar().prepareStatement("INSERT INTO pregunta (nivel_id,contenido) VALUES (?,?)");
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

        try{

            pst = CON.conectar().prepareStatement("UPDATE pregunta set contenido = ? where id = ?");
            pst.setString(1, obj.getContenido());
            pst.setInt(2, obj.getPreguntaId());

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
        return false;
    }

}
