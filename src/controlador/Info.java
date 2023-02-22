
package controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelo.entidades.Opcion;
import modelo.negocio.NivelControl;
import modelo.transferobject.AdminDto;
import modelo.transferobject.JugadorDto;
import modelo.transferobject.NivelDto;
import modelo.transferobject.PreguntaDto;

public class Info {
    
    private static NivelDto nivelDto;
    private static ArrayList<PreguntaDto> listaPreguntas;
    private static ArrayList<Opcion[]> listaOpciones;
    private static JugadorDto infoJugador;
    private static AdminDto infoAdmin;

    public Info() {
        listaPreguntas = new ArrayList<>();
        listaOpciones = new ArrayList<>();
    }
    
    public void getInfoNivel(int nivel){
        
        nivelDto = new NivelControl().obtener(nivel);
        listaPreguntas.addAll(nivelDto.getPreguntas());
        
         
        
        for(PreguntaDto preguntaDto : listaPreguntas){
            
            Opcion[] opciones = new Opcion[4];
            
            for(int i = 0; i <= opciones.length - 1; i++){
                opciones[i] = preguntaDto.getOpciones().get(i);
            }
            
            listaOpciones.add(opciones);
            
        }
        
    }
    
    public static void main(String[] args) {
        
        Info info = new Info();
        info.getInfoNivel(1);
       
        int count = 0;
        for(PreguntaDto preguntaDto : listaPreguntas){
            
            System.out.println(preguntaDto.getContenido());
            
            Opcion[] opciones = listaOpciones.get(count);
            
            for(int i = 0; i <= listaOpciones.get(i).length - 1; i++){        
                    
                    System.out.println(opciones[i].getPreguntaId() + opciones[i].getContenido());
            }
           
           count ++; 
        }
    }
    
    //Getters & Setters

    public static NivelDto getNivelDto() {
        return nivelDto;
    }

    public static void setNivelDto(NivelDto nivelDto) {
        Info.nivelDto = nivelDto;
    }

    public static ArrayList<PreguntaDto> getListaPreguntas() {
        return listaPreguntas;
    }

    public static void setListaPreguntas(ArrayList<PreguntaDto> listaPreguntas) {
        Info.listaPreguntas = listaPreguntas;
    }

    public static ArrayList<Opcion[]> getListaOpciones() {
        return listaOpciones;
    }

    public static void setListaOpciones(ArrayList<Opcion[]> listaOpciones) {
        Info.listaOpciones = listaOpciones;
    }

    public static JugadorDto getInfoJugador() {
        return infoJugador;
    }

    public static void setInfoJugador(JugadorDto infoJugador) {
        Info.infoJugador = infoJugador;
    }

    public static AdminDto getInfoAdmin() {
        return infoAdmin;
    }

    public static void setInfoAdmin(AdminDto infoAdmin) {
        Info.infoAdmin = infoAdmin;
    }
    
    
}
