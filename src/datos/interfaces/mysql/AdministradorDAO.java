package datos.interfaces.mysql;

import datos.interfaces.DAO;
import entidades.Administrador;

public interface AdministradorDAO extends DAO<Administrador> {

    Administrador obtenerPorUsuario(int usuarioId);
}
