/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.juego.actionperfomer;

import controlador.juego.JuegoControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Juego;

public abstract class ActionPerformerAbstract implements ActionListener{
    
    private final JuegoControl JUEGO_CONTROL;
    private final Juego JUEGO;

    public ActionPerformerAbstract(Juego JUEGO, ActionEvent evt) {
        this.JUEGO = JUEGO;
        this.JUEGO_CONTROL = new JuegoControl(JUEGO);
        this.actionPerformed(evt);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
   

    public JuegoControl getJUEGO_CONTROL() {
        return JUEGO_CONTROL;
    }

    public Juego getJUEGO() {
        return JUEGO;
    }
    
    
    
    
}
