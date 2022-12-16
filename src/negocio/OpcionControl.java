package negocio;

import datos.OpcionDAO;
import entidades.Opcion;
import negocio.interfaces.ControlInterface;

import java.util.ArrayList;
import java.util.List;

public class OpcionControl implements ControlInterface<Opcion> {

    private final OpcionDAO DATOS;
    private Opcion opcion;

    public OpcionControl(){
        DATOS = new OpcionDAO();
    }

    @Override
    public List<String> obtenerContenido(int id) {

        List<String> info = new ArrayList<>();

        opcion = DATOS.mostrar(id);

        if(opcion != null){

            info.add(Integer.toString(opcion.getOpcionId()));
            info.add(Integer.toString(opcion.getPreguntaId()));
            info.add(opcion.getContenido());
        }

        return info;
    }
}
