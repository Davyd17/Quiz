package entidades;

public class Opcion {

    private int opcionId;
    private int preguntaId;
    private String contenido;

    public Opcion() {
    }

    public Opcion(int opcionId, int preguntaId, String contenido) {
        this.opcionId = opcionId;
        this.preguntaId = preguntaId;
        this.contenido = contenido;
    }

    public int getOpcionId() {
        return opcionId;
    }

    public void setOpcionId(int opcionId) {
        this.opcionId = opcionId;
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
}
