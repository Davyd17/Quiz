package entidades;

public class Opcion {

    private int opcionId;
    private int preguntaId;
    private int contenido;

    public Opcion() {
    }

    public Opcion(int opcionId, int preguntaId, int contenido) {
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

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }
}
