package entidades;

// Entidad Nivel, donde solo se podra editar el nombre de la categoria, de modo que el resto de atributos
// estan definidos por defecto

public class Nivel {

    private int id;
    private String categoria;
    private int puntos;
    private String dificultad;

    public Nivel(){

    }

    public Nivel(int id, String categoria, int puntos, String dificultad) {
        this.id = id;
        this.categoria = categoria;
        this.puntos = puntos;
        this.dificultad = dificultad;
    }

    public Nivel(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
