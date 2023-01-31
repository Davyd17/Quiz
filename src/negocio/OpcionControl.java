package negocio;

import datos.opciondao.OpcionCrud;
import entidades.Opcion;


import java.util.ArrayList;
import java.util.List;

public class OpcionControl {

    private final OpcionCrud DATOS;
    private Opcion opcion;

    public OpcionControl(){
        DATOS = new OpcionCrud();
    }

    public List<String> obtenerContenido(int id) {

        List<String> info = new ArrayList<>();

        opcion = DATOS.obtener(id);

        if(opcion != null){

            info.add(Integer.toString(opcion.getId()));
            info.add(Integer.toString(opcion.getPreguntaId()));
            info.add(opcion.getContenido());
        }

        return info;
    }
}
