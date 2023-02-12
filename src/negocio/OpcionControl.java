package negocio;

import datos.mysql.MySQLOpcionDAO;
import entidades.Opcion;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class OpcionControl {

    private final MySQLOpcionDAO DATOS;
    private Opcion entidad;
    private boolean resp;

    public OpcionControl(){
        DATOS = new MySQLOpcionDAO();
    }

    public ArrayList<Opcion> obtenerListaPorPregunta(int preguntaId) {

        ArrayList<Opcion> registros = DATOS.ObtenerListaPorPregunta(preguntaId);

        if(registros.isEmpty()){

            JOptionPane.showMessageDialog(null, "Hubo un error al obtener las opciones");
        }

        return registros;

    }

    public boolean insertar(int preguntaId, String contenido, Boolean respuesta){

        entidad = new Opcion();
        entidad.setPreguntaId(preguntaId);
        entidad.setContenido(contenido);
        entidad.setRespuesta(respuesta);

        resp = DATOS.insertar(entidad);

        return resp;
    }
}
