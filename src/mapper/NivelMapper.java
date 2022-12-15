package mapper;

import entidades.Nivel;
import transferobject.NivelDTO;
import transferobject.PreguntaDTO;

import java.util.ArrayList;

public class ManualNivelMapper {

    public NivelDTO CreateDTO(Nivel entidad){

        NivelDTO result = new NivelDTO();

            result.setCategoria(entidad.getCategoria());
            result.setDificultad(entidad.getDificultad());
            result.setPuntos(entidad.getPuntos());
            result.setPreguntas(new ArrayList<PreguntaDTO>());

            return result;
    }
}
