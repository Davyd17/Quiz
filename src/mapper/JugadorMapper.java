package mapper;

import entidades.Jugador;
import transferobject.JugadorDTO;

//Mappeador que se encarga de enlazar la entidad Usuario y JugadorMapper

public class JugadorMapper {

    public JugadorDTO CreateDTO(Jugador jugador){

        JugadorDTO jugadorDTO = new JugadorDTO(

                jugador.getUsuarioId(),
                jugador.getJugadorId(),
                jugador.getNombreUsuario(),
                jugador.getNivelId(),
                jugador.getPuntosAcumulados()

        );

        return jugadorDTO;
    }

}
