package negocio;


import datos.PreguntaDAO;
import entidades.Pregunta;
import negocio.interfaces.ControlInterface;

import java.util.ArrayList;
import java.util.List;

public class PreguntaControl implements ControlInterface <Pregunta> {

    private final PreguntaDAO DATOS;
    private Pregunta pregunta;

    public PreguntaControl(){
        DATOS = new PreguntaDAO();

    }

    public List<String> obtenerContenido(int id){

        List<String> info = new ArrayList<>();

        pregunta = DATOS.mostrar(id);

        if(pregunta != null){
            info.add(Integer.toString(pregunta.getPreguntaId()));
            info.add(Integer.toString(pregunta.getNivelId()));
            info.add(pregunta.getContenido());
        }

        return info;
    }
}
