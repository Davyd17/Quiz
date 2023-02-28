package modelo.negocio;

import modelo.datos.mysql.MySQLPreguntaDAO;
import modelo.entidades.Pregunta;
import modelo.mapper.PreguntaMapper;
import modelo.transferobject.PreguntaDto;


import javax.swing.*;
import java.util.ArrayList;

public class PreguntaControl {

    private final MySQLPreguntaDAO DATOS;
    private Pregunta entidad;
    private boolean resp;

    public PreguntaControl() {
        DATOS = new MySQLPreguntaDAO();
    }

     public ArrayList<PreguntaDto> obtenerListaDePreguntasPorNivelId(int nivelId){

        ArrayList<Pregunta> preguntaList = DATOS.obtenerListaPorNivel(nivelId);
        return  obtenerListaPreguntaDto(preguntaList);
    } 
     
     private ArrayList<PreguntaDto> obtenerListaPreguntaDto(ArrayList<Pregunta> preguntaList){
         
         ArrayList<PreguntaDto> preguntaDtoList = new ArrayList<>();
         
         for(Pregunta pregunta : preguntaList){

            PreguntaDto preguntaDto = new PreguntaMapper().CreateDto(pregunta, new OpcionControl().obtenerListaPorPregunta(pregunta.getId()));

            if(preguntaDto != null){
                preguntaDtoList.add(preguntaDto);
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al obtener la pregunta");
            }
        }
         
         return preguntaDtoList;
         
     }

    public boolean insertar(int nivelId, String contenido){

        entidad = new Pregunta();
        entidad.setNivelId(nivelId);
        entidad.setContenido(contenido);

         resp = DATOS.insertar(entidad);

        return resp;

    }
    
    public boolean editar(int preguntaId, int nivelId, String contenido){
        
        entidad = new Pregunta(
                preguntaId,
                nivelId,
                contenido
        );
        
        resp = DATOS.actualizar(entidad);
        
        return resp;
    }
    


}
