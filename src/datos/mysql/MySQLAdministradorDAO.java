package datos.mysql;

import database.ConexionMySQL;
import datos.interfaces.mysql.AdministradorDAO;
import entidades.Administrador;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
Clase que implementa el patron DAO para acceder a los datos de la entidad administrador. Implementa la interface InterfaceCrudForeignKey
esta brinda la guia para realizar el CRUD en la BD
 */

public class MySQLAdministradorDAO implements AdministradorDAO {

    private final ConexionMySQL CON;
    private PreparedStatement pst;
    private ResultSet rs;
    private boolean resp;
    private Administrador entidad;

    public MySQLAdministradorDAO(){
        CON = ConexionMySQL.getInstance();
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

        String sql = "SELECT * FROM administrador WHERE id = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()){
                entidad = new Administrador(rs.getInt(1),rs.getInt(2));
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

        return entidad;
    }

    @Override
    public List<Administrador> obtenerTodos() {
        return null;
    }

    // UPDATE (Sin uso definido ya que por ahora solo cuenta con una foreign key ).
    @Override
    public boolean actualizar(Administrador obj) {

        return false;
    }

    @Override
    public boolean eliminar() {
        return false;
    }


    @Override
    public Administrador obtenerPorUsuario(int usuarioId) {

        String sql = "SELECT * FROM administrador WHERE usuario_id = ?";

        try{
            pst = CON.conectar().prepareStatement(sql);
            pst.setInt(1, usuarioId);
            rs = pst.executeQuery();

            if (rs.next()){
                entidad = new Administrador(rs.getInt(1),rs.getInt(2));
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

        return entidad;
    }
}
