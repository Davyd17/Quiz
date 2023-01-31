package datos.niveldao;

/*
Clase NivelCrud que se encargara de acceder a los datos del objeto nivel, esta a su vez implementa la interface InterfaceCrud
que contiene la guia para realizar un crud simple al objeto
*/

import datos.interfaces.InterfaceCrud;
import entidades.Nivel;
import database.Conexion;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NivelCrud implements InterfaceCrud<Nivel> {

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;
    private Nivel nivel;

    public NivelCrud(){
        CON = Conexion.getInstance();
    }

    // Metodo que consulta los datos de un nivel en especifico

    @Override
    public Nivel obtener(int id){

        try{

            pst = CON.conectar().prepareStatement("SELECT * FROM nivel WHERE id = ?");
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

}
