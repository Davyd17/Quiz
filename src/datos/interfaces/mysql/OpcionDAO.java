package datos.interfaces.mysql;

import datos.interfaces.DAO;
import entidades.Opcion;

import java.util.List;

public interface OpcionDAO extends DAO <Opcion>{

    List<Opcion> ObtenerListaPorPregunta(int preguntaId);
}
