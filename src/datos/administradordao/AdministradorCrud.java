package datos.administradordao;

import database.Conexion;
import datos.interfaces.InterfaceCrud;
import entidades.Administrador;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
Clase que implementa el patron DAO para acceder a los datos de la entidad administrador. Implementa la interface InterfaceCrud
esta brinda la guia para realizar el CRUD en la BD
 */

public class AdministradorCrud implements InterfaceCrud<Administrador> {

    private final Conexion CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;

    public AdministradorCrud(){
        CON = Conexion.getInstance();
    }

    // Create
    @Override
    public boolean insertar(Administrador obj)  {

        String sql = "INSERT INTO administrador(usuario_id) VALUES(?)";

        try{

            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, obj.getUsuarioId());

            resp = pst.executeUpdate() > 0;

            pst.close();

        } catch (SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            CON.desconectar();
            pst = null;
        }
        return resp;
    }

    // READ
    @Override
    public Administrador obtener(int id) {


        Administrador administrador = null;

        String sql = "SELECT * FROM administrador WHERE usuario_id = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()){
                administrador = new Administrador(rs.getInt(1),rs.getInt(2));
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

        return administrador;
    }

    // UPDATE (Sin uso definido ya que por ahora solo cuenta con una foreign key ).
    @Override
    public boolean actualizar(Administrador obj) {

        return false;
    }

}
