package presentacion;

import entidades.Nivel;
import negocio.NivelControl;
import transferobject.JugadorDto;
import transferobject.UsuarioDto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static presentacion.Principal.jugadorDto;

public class Juego extends JFrame{
    private JPanel pnlJuego;
    private JLabel lblUsuario;
    private JLabel lblNivel;
    private JLabel lblPuntos;
    private JLabel lblCategoria;
    private JLabel lblTituloCategoria;

    public Juego(){
        super("Quiz Game");
        this.setContentPane(pnlJuego);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createUIComponents();
    }

    @SuppressWarnings("unchecked")
    private void createUIComponents() {

        this.setSize(500,400);
        this.setLocationRelativeTo(null);

        this.infoLabel();

    }

    private void infoLabel(){

        lblUsuario.setText(jugadorDto.getNombreUsuario());

        lblNivel.setText("NIVEL: " + (jugadorDto.getNivelId()));

        Nivel nivel = new NivelControl().obtenerNivel(jugadorDto.getNivelId());
        lblCategoria.setText((nivel.getCategoria()));
        lblPuntos.setText("Puntos: " + nivel.getPuntos());


    }

}
