package negocio;

import datos.mysql.MySQLPreguntaDAO;
import entidades.Pregunta;
import mapper.PreguntaMapper;
import transferobject.PreguntaDto;


import javax.swing.*;
import java.util.ArrayList;

public class PreguntaControl {

    private final MySQLPreguntaDAO DATOS;
    private Pregunta entidad;
    private boolean resp;

    public PreguntaControl() {
        DATOS = new MySQLPreguntaDAO();
    }

    public ArrayList<PreguntaDto> obtenerListaPorNivel(int nivelId){

        ArrayList<Pregunta> registros = DATOS.obtenerListaPorNivel(nivelId);
        ArrayList<PreguntaDto> preguntaDtoList = new ArrayList<>();

        for(Pregunta entidad : registros){

            PreguntaDto preguntaDto = new PreguntaMapper().CreateDto(entidad, new OpcionControl().obtenerListaPorPregunta(entidad.getId()));

            if(preguntaDto != null){
                preguntaDtoList.add(preguntaDto);
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al obtener la pregunta");
            }
        }

        return  preguntaDtoList;
    }

    public boolean insertar(int nivelId, String contenido){

        entidad = new Pregunta();
        entidad.setNivelId(nivelId);
        entidad.setContenido(contenido);

         resp = DATOS.insertar(entidad);

        return resp;

    }



}
