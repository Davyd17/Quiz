package mapper;

import entidades.Jugador;
import entidades.Usuario;
import transferobject.JugadorDto;

//Mappeador que se encarga de enlazar la entidad Usuario y JugadorMapper

public class JugadorMapper {

    public JugadorDto CreateDTO(Jugador jugador, Usuario usuario){

        JugadorDto jugadorDTO = new JugadorDto(

                jugador.getUsuarioId(),
                jugador.getId(),
                usuario.getNombreUsuario(),
                jugador.getNivelId(),
                jugador.getPuntosAcumulados()

        );

        return jugadorDTO;
    }

}
