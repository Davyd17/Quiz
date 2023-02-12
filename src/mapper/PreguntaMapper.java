package mapper;

import entidades.Opcion;
import entidades.Pregunta;
import transferobject.PreguntaDto;

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
