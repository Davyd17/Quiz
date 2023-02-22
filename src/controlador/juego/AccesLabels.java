/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.juego;
import controlador.Info;
import vista.Juego;
import vista.Principal;

/**
 *
 * @author PC1
 */
public class AccesLabels{
    
    private Juego juego;
    
    public AccesLabels(Juego juego){
           this.juego = juego;
    }
    
    public void setLabels(){
        
        this.juego.getLblNombreUsuario().setText(Info.getInfoJugador().getNombreUsuario());
        this.juego.getLblNivel().setText("Nivel: " + Integer.toString(Info.getInfoJugador().getNivel()));
        
        
    }
    
    
    
}
