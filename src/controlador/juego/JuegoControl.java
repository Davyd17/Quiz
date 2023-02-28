/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.juego;

import controlador.Info;
import controlador.CierreSesion;
import javax.swing.JOptionPane;
import vista.Juego;

public class JuegoControl {

    private final Juego JUEGO;
    private final RespuestaCorrecta RESPUESTA_CORRECTA;
    private final JugadorInfoControl JUGADOR_INFO_CONTROL;
    private final JuegoInfo JUGADOR_INFO;
    private final CierreSesion CIERRE_SESION;

    public JuegoControl(Juego JUEGO) {
        this.JUEGO = JUEGO;
        this.RESPUESTA_CORRECTA = new RespuestaCorrecta(JUEGO);
        this.JUGADOR_INFO_CONTROL = new JugadorInfoControl(JUEGO);
        this.JUGADOR_INFO = new JuegoInfo(JUEGO);
        this.CIERRE_SESION = new CierreSesion();
    }

    public boolean subirNivel() {

        if (this.RESPUESTA_CORRECTA.isRespuestaCorrecta()) {

            JOptionPane.showMessageDialog(JUEGO, "CORRECTO!!");

            int nivel = Info.getInfoJugador().getNivel() + 1;

            if (nivel <= 5) {

                this.JUGADOR_INFO_CONTROL.actualizarJugador(nivel, Info.getInfoJugador().getPuntosAcumulados()
                        + Info.getNivelDto().getPuntos());

                this.JUGADOR_INFO.showInfo();
            }
            
            this.JUEGO.getGrupobtnOpciones().clearSelection();
            return true;

        } else {
            return false;
        }

    }

    public boolean GanarJuego() {

        if (Info.getInfoJugador().getPuntosAcumulados() == 500) {

            JOptionPane.showMessageDialog(null, """
                                                 Felicitaciones!! Ha respondido todas las preguntas con exito!
                                                 Puntos acumulados: """ + Info.getInfoJugador().getPuntosAcumulados(),
                    "WIN", JOptionPane.FRAMEBITS);

            CIERRE_SESION.finalizar(JUEGO);

            return true;
        } else {
            return false;
        }
    }

    public void GameOver() {

        if (!this.RESPUESTA_CORRECTA.isRespuestaCorrecta()) {

            int seleccion = JOptionPane.showConfirmDialog(null, "¿Volver a jugar?", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
            
            if (seleccion != 0) {
                CIERRE_SESION.finalizar(JUEGO);
            }
            
            this.JUEGO.getGrupobtnOpciones().clearSelection();
            this.JUGADOR_INFO_CONTROL.actualizarJugador(1, 0);
            this.JUGADOR_INFO.showInfo();

        }
    }

    public void salirYGuardar() {
        CIERRE_SESION.finalizar(JUEGO);

    }

}
