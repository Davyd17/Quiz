package mapper;

import entidades.Nivel;
import transferobject.JuegoDTO;
import transferobject.NivelDTO;

import java.util.ArrayList;

public class NivelMapper {

    public NivelDTO CreateDTO(Nivel entidad){

        NivelDTO nivelDTO = new NivelDTO();

            nivelDTO.setCategoria(entidad.getCategoria());
            nivelDTO.setDificultad(entidad.getDificultad());
            nivelDTO.setPuntos(entidad.getPuntos());
            nivelDTO.setPreguntas(new ArrayList<JuegoDTO>());

            return nivelDTO;
    }
}
