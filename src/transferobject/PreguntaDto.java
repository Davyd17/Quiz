package transferobject;

import java.util.ArrayList;
import entidades.Opcion;

public class PreguntaDto {

    private int preguntaId;
    private String contenido;
    private ArrayList<Opcion> opciones = new ArrayList<>();

    public PreguntaDto() {
    }

    public PreguntaDto(int preguntaId, String contenido, ArrayList<Opcion> opciones) {
        this.preguntaId = preguntaId;
        this.contenido = contenido;
        this.opciones.addAll(opciones);
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
        return opciones;
    }

    public void setOpciones(ArrayList<Opcion> opciones) {
        opciones = opciones;
    }

    @Override
    public String toString() {
        return "PreguntaDto{" +
                "preguntaId=" + preguntaId +
                ", contenido='" + contenido + '\'' +
                ", opciones=" + opciones +
                '}';
    }
}
