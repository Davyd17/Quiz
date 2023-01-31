package datos.opciondao;

import database.Conexion;
import datos.interfaces.InterfaceCrud;
import entidades.Opcion;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OpcionCrud implements InterfaceCrud<Opcion> {

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private Opcion opcion;
    private boolean resp;


    public OpcionCrud(){
        CON = Conexion.getInstance();
    }

    //READ
    @Override
    public Opcion obtener(int id) {

        try{

            pst = CON.conectar().prepareStatement("SELECT * FROM opcion WHERE id = ?");
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

    //CREATE
    @Override
    public boolean insertar(Opcion obj) {

        try{

            pst = CON.conectar().prepareStatement("INSERT INTO opcion (pregunta_id,contenido,respuesta) VALUES (?,?,?)");
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

        try{

            pst = CON.conectar().prepareStatement("UPDATE opcion SET contenido = ?, respuesta = ? WHERE id = ?");
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
}
