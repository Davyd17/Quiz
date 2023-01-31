package mapper;

import entidades.Nivel;
import transferobject.PreguntaDto;
import transferobject.NivelDto;

import java.util.ArrayList;

public class NivelMapper {

    public NivelDto CreateDTO(Nivel entidad){

        NivelDto nivelDTO = new NivelDto();

            nivelDTO.setCategoria(entidad.getCategoria());
            nivelDTO.setDificultad(entidad.getDificultad());
            nivelDTO.setPuntos(entidad.getPuntos());
            nivelDTO.setPreguntas(new ArrayList<PreguntaDto>());

            return nivelDTO;
    }
}
