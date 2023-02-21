/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.juego;

import javax.swing.JFrame;
import vista.Juego;
import vista.Principal;

/**
 *
 * @author PC1
 */
public class AccesLabels extends Juego{
    
    private Juego juego;
    
    public AccesLabels(Juego juego){
        
        this. juego = juego;
           
    }
    
    public void setLabels(){
        
        getLblNombreUsuario().setText(Principal.getInfoJugador().getNombreUsuario());
        
        
    }
    
    
    
}
