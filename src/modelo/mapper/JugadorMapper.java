package modelo.mapper;

import modelo.entidades.Jugador;
import modelo.entidades.Usuario;
import modelo.transferobject.JugadorDto;

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
