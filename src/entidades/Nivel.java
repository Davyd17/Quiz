package entidades;

// Entidad que mapea la tabla nivel de la base de datos

public class Nivel {

    // Atributos
    private int id;
    private String categoria;
    private int puntos;
    private String dificultad;

    // Constructor por defecto
    public Nivel() {

    }

    // Constructor
    public Nivel(int id, String categoria, int puntos, String dificultad) {
        this.id = id;
        this.categoria = categoria;
        this.puntos = puntos;
        this.dificultad = dificultad;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
