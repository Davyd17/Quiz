package mapper;

import entidades.Nivel;
import entidades.Pregunta;
import transferobject.PreguntaDto;
import transferobject.NivelDto;

import java.util.ArrayList;

public class NivelMapper {

    public NivelDto CreateDTO(Nivel nivel, ArrayList<PreguntaDto> preguntas){

        NivelDto nivelDTO = new NivelDto();

            nivelDTO.setNivelId(nivel.getId());
            nivelDTO.setCategoria(nivel.getCategoria());
            nivelDTO.setPuntos(nivel.getPuntos());
            nivelDTO.setDificultad(nivel.getDificultad());
            nivelDTO.setPreguntas(preguntas);

            return nivelDTO;
    }
}
