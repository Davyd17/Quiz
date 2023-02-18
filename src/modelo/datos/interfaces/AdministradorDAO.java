package modelo.datos.interfaces;

import modelo.datos.interfaces.DAO;
import modelo.entidades.Administrador;

public interface AdministradorDAO extends DAO<Administrador> {

    Administrador obtenerPorUsuario(int usuarioId);
}
