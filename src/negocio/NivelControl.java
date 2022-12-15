package negocio;

// Clase NivelControl encargada de interactuar y controlar el CRUD del objeto Nivel

import datos.NivelDAO;
import entidades.Nivel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NivelControl {

    private final NivelDAO DATOS;
    private Nivel nivel;

    public NivelControl(){
        DATOS = new NivelDAO();
    }

    public List<String> mostrarNivel(int id){

        List<String> info = new ArrayList<>();

        nivel = DATOS.mostrar(id);

        if(nivel != null){
            info.add(Integer.toString(nivel.getNivelId()));
            info.add(nivel.getCategoria());
            info.add(Integer.toString(nivel.getPuntos()));
            info.add(nivel.getDificultad());
        }

        return info;
    }

}


