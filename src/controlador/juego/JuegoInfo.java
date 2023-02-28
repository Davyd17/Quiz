
package controlador.juego;
import controlador.Info;
import javax.swing.JRadioButton;
import modelo.entidades.Opcion;
import vista.Juego;


/**
 *
 * @author PC1
 */
public class JuegoInfo{
    
    private final Juego JUEGO;
    private final Info INFO;
    public static int preguntaIndiceAleatoria;
    
    public JuegoInfo(Juego juego){
           this.JUEGO = juego;
           this.INFO = new Info();
           preguntaIndiceAleatoria = (int) (Math.random() * 4);
    }
    
    public void showInfo(){
        
        INFO.getInfoNivel(Info.getInfoJugador().getNivel());
        
        this.JUEGO.getLblNombreUsuario().setText(Info.getInfoJugador().getNombreUsuario()); //Nombre de usuario
        this.JUEGO.getLblPuntosAcumulados().setText("Puntos Acumulados: " + Info.getInfoJugador().getPuntosAcumulados()); //Puntos acumulados
        
        this.JUEGO.getLblCategoria().setText("Categoria: " + Info.getNivelDto().getCategoria()); // Categoria
        this.JUEGO.getLblNivel().setText("Nivel: " + Integer.toString(Info.getNivelDto().getNivel())); //Nivel
        this.JUEGO.getLblPuntos().setText("Puntos: " + Integer.toString(Info.getNivelDto().getPuntos())); //Puntos
                
        this.JUEGO.getLblPreguntaContenido().setText(Info.getListaPreguntas().get(preguntaIndiceAleatoria).getContenido()); // Pregunta
        
        Opcion[] opciones = Info.getListaOpciones().get(preguntaIndiceAleatoria);
        
        JRadioButton[] botonesopcion = new ControlOpciones(JUEGO).getOpcionesRadioButton();
        
        for(int i = 0; i <= botonesopcion.length - 1; i++){
            
            botonesopcion[i].setText(opciones[i].getContenido());
        }
   
    }
    
    
}
