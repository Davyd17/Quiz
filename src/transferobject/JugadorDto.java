package transferobject;

// DTO para la entidad Usuario que se encarga de traer solo las variables necesarias (desconoce la variable contrasena)

import java.io.Serializable;

public class  JugadorDto extends UsuarioDto implements Serializable {

    private int jugadorId;
    private int nivelId;
    private int puntosAcumulados;

    public JugadorDto(){

    }

    public JugadorDto(int usuarioId, int jugadorId, String nombreUsuario, int nivelId, int puntosAcumulados) {
        super.setUsuarioId(usuarioId);
        this.jugadorId = jugadorId;
        super.setNombreUsuario(nombreUsuario);
        this.nivelId = nivelId;
        this.puntosAcumulados = puntosAcumulados;
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

    @Override
    public String toString() {
        return "JugadorDto{" +
                "usuarioId=" + super.getUsuarioId() +
                ", jugadorId=" + jugadorId +
                ", nombreUsuario='" + super.getNombreUsuario() + '\'' +
                ", nivelId=" + nivelId +
                ", puntosAcumulados=" + puntosAcumulados +
                '}';
    }
}
