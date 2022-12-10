package datos;

import database.Conexion;
import datos.interfaces.CrudJuegoInterface;
import entidades.Opcion;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OpcionDAO implements CrudJuegoInterface<Opcion> {

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private Opcion opcion;
    private boolean resp;


    public OpcionDAO(){
        CON = Conexion.getInstance();
    }
    @Override
    public Opcion mostrar(int id) {

        try{

            pst = CON.conectar().prepareStatement("SELECT * FROM opcion WHERE id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while(rs.next()){
                opcion = new Opcion(rs.getInt(1),rs.getInt(2),rs.getString(3));
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
    public List<Opcion> listar() {
        return null;
    }

    @Override
    public boolean insertar(Opcion obj) {

        try{

            pst = CON.conectar().prepareStatement("INSERT INTO opcion (pregunta_id,contenido) VALUES (?,?)");
            pst.setInt(1,obj.getPreguntaId());
            pst.setString(2, obj.getContenido());

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

    @Override
    public boolean actualizar(Opcion obj) {

        try{

            pst = CON.conectar().prepareStatement("UPDATE opcion SET contenido = ? WHERE id = ?");
            pst.setString(1, obj.getContenido());
            pst.setInt(2, obj.getOpcionId());

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
}
