package datos.interfaces.mysql;

import datos.interfaces.DAO;
import entidades.Jugador;

public interface JugadorDAO extends DAO<Jugador> {

    Jugador obtenerPorUsuario(int usuarioId);
}
