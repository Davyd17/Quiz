package modelo.mapper;

import modelo.entidades.Nivel;
import modelo.entidades.Pregunta;
import modelo.transferobject.PreguntaDto;
import modelo.transferobject.NivelDto;

import java.util.ArrayList;

public class NivelMapper {

    public NivelDto CreateDTO(Nivel nivel, ArrayList<PreguntaDto> preguntas){

        NivelDto nivelDTO = new NivelDto();
            
            nivelDTO.setNivelId(nivel.getId());
            nivelDTO.setNivel(nivel.getNivel());
            nivelDTO.setCategoria(nivel.getCategoria());
            nivelDTO.setPuntos(nivel.getPuntos());
            nivelDTO.setDificultad(nivel.getDificultad());
            nivelDTO.setPreguntas(preguntas);

            return nivelDTO;
    }
}
