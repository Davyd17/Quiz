package modelo.mapper;

import modelo.entidades.Opcion;
import modelo.entidades.Pregunta;
import modelo.transferobject.PreguntaDto;

import java.util.ArrayList;

public class PreguntaMapper {

    public PreguntaDto CreateDto(Pregunta pregunta, ArrayList<Opcion> opciones){

        return new PreguntaDto(

                pregunta.getId(),
                pregunta.getContenido(),
                new ArrayList<>(opciones)
        );

    }
}
