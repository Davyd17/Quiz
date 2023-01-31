package negocio;


import datos.preguntadao.PreguntaCrud;
import entidades.Pregunta;


import java.util.ArrayList;
import java.util.List;

public class PreguntaControl {

    private final PreguntaCrud DATOS;
    private Pregunta pregunta;

    public PreguntaControl(){
        DATOS = new PreguntaCrud();

    }

    public List<String> obtenerContenido(int id){

        List<String> info = new ArrayList<>();

        pregunta = DATOS.obtener(id);

        if(pregunta != null){
            info.add(Integer.toString(pregunta.getId()));
            info.add(Integer.toString(pregunta.getNivelId()));
            info.add(pregunta.getContenido());
        }

        return info;
    }
}
