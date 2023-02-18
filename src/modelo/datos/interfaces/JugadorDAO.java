package modelo.datos.interfaces;

import modelo.datos.interfaces.DAO;
import modelo.entidades.Jugador;

public interface JugadorDAO extends DAO<Jugador> {

    Jugador obtenerPorUsuario(int usuarioId);
}
