package transferobject;

import java.util.ArrayList;

public class NivelDto {

    private int nivelId;
    private String categoria;
    private int puntos;
    private String dificultad;
    private ArrayList<PreguntaDto> preguntas = new ArrayList<>();

    public NivelDto() {
    }

    public NivelDto(int nivelId, String categoria, int puntos, String dificultad, ArrayList<PreguntaDto> preguntas) {
        this.nivelId = nivelId;
        this.categoria = categoria;
        this.puntos = puntos;
        this.dificultad = dificultad;
        this.preguntas = preguntas;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public ArrayList<PreguntaDto> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<PreguntaDto> preguntas) {
        this.preguntas = preguntas;
    }
}
