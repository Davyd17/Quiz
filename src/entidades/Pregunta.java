package entidades;

public class Pregunta {

    private int preguntaId;
    private int nivelId;
    private String contenido;

    public Pregunta() {
    }

    public Pregunta(int preguntaId, int nivelId, String contenido) {
        this.preguntaId = preguntaId;
        this.nivelId = nivelId;
        this.contenido = contenido;
    }

    public int getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(int preguntaId) {
        this.preguntaId = preguntaId;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
