package entidades;

//Entidad que mapea la tabla pregunta en la base de datos
public class Pregunta {

    // Atributos
    private int id;
    private int nivelId; // Foreign Key
    private String contenido;

    // Constructor por defecto
    public Pregunta() {
    }

    // Constructor
    public Pregunta(int id, int nivelId, String contenido) {
        this.id = id;
        this.nivelId = nivelId;
        this.contenido = contenido;
    }

    // Getters & Setters
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
