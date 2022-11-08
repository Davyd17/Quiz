package entidades;

// Entidad Nivel, donde solo se podra editar el nombre de la categoria, de modo que el resto de atributos
// estan definidos por defecto

public class Nivel {

    private int nivelId;
    private String categoria;
    private int puntos;
    private String dificultad;

    public Nivel() {

    }

    public Nivel(int nivelId, String categoria, int puntos, String dificultad) {
        this.nivelId = nivelId;
        this.categoria = categoria;
        this.puntos = puntos;
        this.dificultad = dificultad;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
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
