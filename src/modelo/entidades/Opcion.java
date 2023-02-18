package modelo.entidades;

//Entidad que mapea la tabla opcion de la base de datos
public class Opcion {

    // Atributos
    private int id;
    private int preguntaId;//Foreign Key
    private String contenido;

    private boolean respuesta;

    // Contructor por defecto
    public Opcion() {
    }

    // Constructor
    public Opcion(int id, int preguntaId, String contenido, boolean respuesta) {
        this.id = id;
        this.preguntaId = preguntaId;
        this.contenido = contenido;
        this.respuesta = respuesta;
    }
    
    // Getters & Setters
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Opcion{" +
                "id=" + id +
                ", preguntaId=" + preguntaId +
                ", contenido='" + contenido + '\'' +
                ", respuesta=" + respuesta +
                '}';
    }
}
