package presentacion;

import negocio.NivelControl;
import transferobject.NivelDto;


import javax.swing.*;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static presentacion.Principal.jugadorDto;

public class Juego extends JFrame{
    private JPanel pnlJuego;
    private JLabel lblUsuario;
    private JLabel lblNivel;
    private JLabel lblPuntos;
    private JLabel lblCategoria;
    private JLabel lblTituloCategoria;
    private JLabel lblCerrarSesion;

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

        lblCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setLblCerrarSesion();
            }
        });

    }

    private void infoLabel(){
/*
        lblUsuario.setText(jugadorDto.getNombreUsuario());

        lblNivel.setText("NIVEL: " + (jugadorDto.getNivelId()));

        NivelDto nivel = new NivelControl().obtener(jugadorDto.getNivelId());
        lblCategoria.setText((nivel.getCategoria()));
        lblPuntos.setText("Puntos: " + nivel.getPuntos());

*/
    }

    private void setLblCerrarSesion(){

        jugadorDto = null;
        this.dispose();
        Principal principal = new Principal();
        principal.setVisible(true);
    }

}
