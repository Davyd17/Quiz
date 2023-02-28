/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.juego;

import javax.swing.JRadioButton;
import vista.Juego;

public class ControlOpciones {
    
    private final Juego JUEGO;

    protected ControlOpciones(Juego JUEGO) {
        this.JUEGO = JUEGO;
    }
    
    protected JRadioButton[] getOpcionesRadioButton() {
        
        JRadioButton[] botonOpciones = new JRadioButton[4];
        botonOpciones[0] = JUEGO.getRbtnOpcion1();
        botonOpciones[1] = JUEGO.getRbtnOpcion2();
        botonOpciones[2] = JUEGO.getRbtnOpcion3();
        botonOpciones[3] = JUEGO.getRbtnOpcion4();
        
        return botonOpciones;
    }
}
