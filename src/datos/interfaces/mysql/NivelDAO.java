package datos.interfaces.mysql;

import datos.interfaces.DAO;
import entidades.Nivel;

public interface NivelDAO extends DAO<Nivel> {

    boolean existe(int id);
}
