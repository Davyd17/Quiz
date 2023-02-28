package modelo.negocio;

import modelo.datos.mysql.MySQLOpcionDAO;
import modelo.entidades.Opcion;


import javax.swing.*;
import java.util.ArrayList;

public class OpcionControl {

    private final MySQLOpcionDAO DATOS;
    private Opcion entidad;
    private boolean resp;

    public OpcionControl(){
        DATOS = new MySQLOpcionDAO();
    }

    public ArrayList<Opcion> obtenerListaPorPregunta(int preguntaId) {

        ArrayList<Opcion> registros = DATOS.ObtenerListaPorPregunta(preguntaId);

        if(registros == null){

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
    
    public boolean editar(int opcionId, int preguntaId, String contenido, boolean respuesta){
        
        entidad = new Opcion();
        
        entidad.setId(opcionId);
        entidad.setPreguntaId(preguntaId);
        entidad.setContenido(contenido);
        entidad.setRespuesta(respuesta);
        
        resp = DATOS.actualizar(entidad);
        
        return resp;
    }
}
