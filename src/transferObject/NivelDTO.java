package transferObject;

import java.util.ArrayList;

public class NivelDTO {

    private int nivelId;
    private String categoria;
    private int puntos;
    private String dificultad;
    private ArrayList<PreguntaDTO> preguntas = new ArrayList<>();

    public NivelDTO() {
    }

    public NivelDTO(int nivelId, String categoria, int puntos, String dificultad, ArrayList<PreguntaDTO> preguntas) {
        this.nivelId = nivelId;
        this.categoria = categoria;
        this.puntos = puntos;
        this.dificultad = dificultad;
        this.preguntas = preguntas;
    }

    public int getNivelId() {
        return nivelId;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getDificultad() {
        return dificultad;
    }

    public ArrayList<PreguntaDTO> getPreguntas() {
        return preguntas;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPreguntas(ArrayList<PreguntaDTO> preguntas) {
        this.preguntas = preguntas;
    }
}
