package transferobject;

import java.util.ArrayList;
import entidades.Opcion;

public class PreguntaDto {

    private int nivelId;
    private int preguntaId;
    private String contenido;
    private ArrayList<Opcion> Opciones = new ArrayList<>();

    public PreguntaDto() {
    }

    public PreguntaDto(int nivelId, int preguntaId, String contenido, ArrayList<Opcion> opciones) {
        this.nivelId = nivelId;
        this.preguntaId = preguntaId;
        this.contenido = contenido;
        Opciones = opciones;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public ArrayList<Opcion> getOpciones() {
        return Opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        Opciones = opciones;
    }
}
