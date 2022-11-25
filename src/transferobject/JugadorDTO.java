package transferobject;

// DTO para la entidad Usuario que se encarga de traer solo las variables necesarias (desconoce la variable contrasena)

import java.io.Serializable;

public class JugadorDTO implements Serializable {

    private int usuarioId;
    private int jugadorId;
    private String nombreUsuario;
    private int nivelId;
    private int puntosAcumulados;



    public JugadorDTO() {
    }

    public JugadorDTO(int usuarioId, int jugadorId, String nombreUsuario, int nivelId, int puntosAcumulados) {
        this.usuarioId = usuarioId;
        this.jugadorId = jugadorId;
        this.nombreUsuario = nombreUsuario;
        this.nivelId = nivelId;
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(int jugadorId) {
        this.jugadorId = jugadorId;
    }


}
