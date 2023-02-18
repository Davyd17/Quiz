package modelo.datos.interfaces;

import modelo.datos.interfaces.DAO;
import modelo.entidades.Opcion;

import java.util.List;

public interface OpcionDAO extends DAO <Opcion>{

    List<Opcion> ObtenerListaPorPregunta(int preguntaId);
}
