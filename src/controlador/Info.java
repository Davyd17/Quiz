package controlador;

import java.util.ArrayList;
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
    }

    public boolean getInfoNivel(int nivel) {

        nivelDto = new NivelControl().obtener(nivel);

        if (nivelDto != null) {

            addAllPreguntasDto();
            return true;
            
        } else {
            nivelDto = null;
            return false;
        }
    }
    

    private void addAllPreguntasDto() {

        listaPreguntas = nivelDto.getPreguntas();

        if (listaPreguntas != null) addOpcionesPerPregunta();
         else  listaPreguntas = null;
            
        
    }

    private void addOpcionesPerPregunta() {

        listaOpciones = new ArrayList<>();

        int count = 0;
        for (PreguntaDto preguntaDto : listaPreguntas) {

            Opcion[] opciones = new Opcion[listaPreguntas.get(count).getOpciones().size()];

            for (int i = 0; i <= opciones.length - 1; i++) {
                opciones[i] = preguntaDto.getOpciones().get(i);
            }

            listaOpciones.add(opciones);

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
