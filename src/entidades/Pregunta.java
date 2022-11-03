package entidades;

public class Pregunta {

    private int id;
    private int nivelId;
    private String contenido;

    public Pregunta() {
    }

    public Pregunta(int id, int nivelId, String contenido) {
        this.id = id;
        this.nivelId = nivelId;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
