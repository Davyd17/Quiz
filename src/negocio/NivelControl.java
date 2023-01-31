package negocio;

// Clase NivelControl encargada de interactuar y controlar el CRUD del objeto Nivel

import datos.niveldao.NivelCrud;
import entidades.Nivel;


import javax.swing.*;


public class NivelControl{

    private final NivelCrud DATOS;

    public NivelControl() {
        DATOS = new NivelCrud();
    }

    public Nivel obtenerNivel(int id){

        Nivel nivel = DATOS.obtener(id);

        if(nivel == null){
            JOptionPane.showMessageDialog(null, "Hubo un error al momento de obtener el nivel");
        }

        return nivel;
    }


}








