package datos.interfaces.mysql;

import datos.interfaces.DAO;
import entidades.Pregunta;

import java.util.ArrayList;
import java.util.List;

public interface PreguntaDAO extends DAO<Pregunta> {

    ArrayList<Pregunta> obtenerListaPorNivel(int nivelId);
}
