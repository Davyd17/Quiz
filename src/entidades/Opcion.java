package entidades;

public class Opcion {

    private int id;
    private int preguntaId;
    private int contenido;

    public Opcion() {
    }

    public Opcion(int id, int preguntaId, int contenido) {
        this.id = id;
        this.preguntaId = preguntaId;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
