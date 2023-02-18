package modelo.datos.interfaces;

import modelo.datos.interfaces.DAO;
import modelo.entidades.Pregunta;

import java.util.ArrayList;
import java.util.List;

public interface PreguntaDAO extends DAO<Pregunta> {

    ArrayList<Pregunta> obtenerListaPorNivel(int nivelId);
}
