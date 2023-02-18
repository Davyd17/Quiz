package modelo.datos.interfaces;

import modelo.datos.interfaces.DAO;
import modelo.entidades.Nivel;

public interface NivelDAO extends DAO<Nivel> {

    boolean existe(int id);
}
