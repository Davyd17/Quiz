package controlador.juego;

import controlador.Info;
import javax.swing.JRadioButton;
import modelo.entidades.Opcion;
import vista.Juego;

public class RespuestaCorrecta {
    
    private final Juego JUEGO;
    private boolean isCorrect;

    public RespuestaCorrecta(Juego JUEGO) {
        this.JUEGO = JUEGO;
    }
    
    public boolean isRespuestaCorrecta(){
             
            ControlOpciones controlOpciones = new ControlOpciones(JUEGO);
            JRadioButton[] botonOpcion = controlOpciones.getOpcionesRadioButton();
            Opcion[] respuestaOpciones = Info.getListaOpciones().get(JuegoInfo.preguntaIndiceAleatoria);
            
            for(int i = 0; i <= botonOpcion.length - 1; i++){
                isCorrect = botonOpcion[i].isSelected() == respuestaOpciones[i].isRespuesta();
            }
            
               
           return isCorrect;
    }
    
}
