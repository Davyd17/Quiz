package presentacion;

import entidades.Opcion;
import negocio.*;
import transferobject.NivelDto;
import transferobject.PreguntaDto;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static presentacion.Principal.adminDto;

public class InterfazAdministrador extends JFrame {
    private JPanel pnlAdmin;
    private JLabel titulo;
    private JLabel lblUsuario;
    private JButton btnNivel1;
    private JButton btnNivel2;
    private JButton btnNivel3;
    private JButton btnNivel4;
    private JButton btnNivel5;
    private JLabel lblInfo;
    private JLabel lblCerrarSesion;
    private JLabel lblNivelSeleccionado;
    private JButton btnPregunta1;
    private JButton btnPregunta2;
    private JButton btnPregunta3;
    private JButton btnPregunta4;
    private JButton btnPregunta5;
    private JLabel lblCategoria;
    private JTextArea txtareaContenidoPregunta;
    private JTextField txtOpcion1;
    private JTextField txtOpcion2;
    private JTextField txtOpcion3;
    private JTextField txtOpcion4;
    private JCheckBox chboxOpcion1;
    private JCheckBox chboxOpcion2;
    private JCheckBox chboxOpcion3;
    private JCheckBox chboxOpcion4;
    private JLabel lblPuntos;
    private JLabel lblDificultad;
    private JButton btnListo;
    private JLabel lblMensajeEdicion;
    private JLabel lblAdvertencia;
    private static NivelDto nivelDto;

    public InterfazAdministrador() {
        super("Interfaz administrador");
        this.setContentPane(pnlAdmin);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUIComponents();
        this.vistaComponentesSeleccionNivel(false, false);
        lblMensajeEdicion.setVisible(false);

    }

    public void infoLabel() {

        lblUsuario.setText(adminDto.getNombreUsuario());
    }

    private void lblCerrarSesionActionPerformed() {

        adminDto = null;
        this.dispose();
        Principal principal = new Principal();
        principal.setVisible(true);
    }

    private void vistaComponentesSeleccionNivel(boolean btnPreguntas, boolean seccionPregunta) {

        lblNivelSeleccionado.setVisible(btnPreguntas);
        lblCategoria.setVisible(btnPreguntas);
        lblPuntos.setVisible(btnPreguntas);
        lblDificultad.setVisible(btnPreguntas);

        btnPregunta1.setVisible(btnPreguntas);
        btnPregunta2.setVisible(btnPreguntas);
        btnPregunta3.setVisible(btnPreguntas);
        btnPregunta4.setVisible(btnPreguntas);
        btnPregunta5.setVisible(btnPreguntas);

        txtareaContenidoPregunta.setVisible(seccionPregunta);

        txtOpcion1.setVisible(seccionPregunta);
        txtOpcion2.setVisible(seccionPregunta);
        txtOpcion3.setVisible(seccionPregunta);
        txtOpcion4.setVisible(seccionPregunta);

        chboxOpcion1.setVisible(seccionPregunta);
        chboxOpcion2.setVisible(seccionPregunta);
        chboxOpcion3.setVisible(seccionPregunta);
        chboxOpcion4.setVisible(seccionPregunta);

        btnListo.setVisible(seccionPregunta);

    }

    private void setBtnListo(int nivel) {
/*
        lblAdvertencia.setText("");

        if(
                txtareaContenidoPregunta.getText().length() == 0 ||
                        txtOpcion1.getText().length() == 0 ||
                        txtOpcion2.getText().length() == 0 ||
                        txtOpcion3.getText().length() == 0 ||
                        txtOpcion3.getText().length() == 0 ||
                        txtOpcion4.getText().length() == 0 ||
                        !chboxOpcion1.isSelected() &&
                                !chboxOpcion2.isSelected() &&
                                !chboxOpcion3.isSelected() &&
                                !chboxOpcion4.isSelected()

        ){
            lblAdvertencia.setText("Todos los campos son obligatorios");

        } else{

            int idGenerado = new PreguntaControl().insertar(nivel, txtareaContenidoPregunta.getText());
            System.out.println(idGenerado);

            OpcionControl opcionControl = new OpcionControl();

            opcionControl.insertar(idGenerado, txtOpcion1.getText(), chboxOpcion1.isSelected());
            opcionControl.insertar(idGenerado, txtOpcion2.getText(), chboxOpcion2.isSelected());
            opcionControl.insertar(idGenerado,txtOpcion3.getText(), chboxOpcion3.isSelected());
            opcionControl.insertar(idGenerado, txtOpcion4.getText(), chboxOpcion4.isSelected());

            lblAdvertencia.setText("Pregunta agregada exitosamente");

            vistaComponentesSeleccionNivel(true,false);
            txtareaContenidoPregunta.setText("");
            txtOpcion1.setText("");
            txtOpcion2.setText("");
            txtOpcion3.setText("");
            txtOpcion4.setText("");
            chboxOpcion1.setSelected(false);
            chboxOpcion2.setSelected(false);
            chboxOpcion3.setSelected(false);
            chboxOpcion4.setSelected(false);



        }
*/

    }

    private void setBtnNiveles(int nivel) {

        NivelControl nivelControl = new NivelControl();

        NivelDto nivelDto = nivelControl.obtener(nivel);

        if (nivelDto != null) {

            System.out.println("Nivel: " + nivelDto.getNivelId() + " Categoria: " + nivelDto.getCategoria() + " Puntos: " + nivelDto.getPuntos());

            ArrayList<PreguntaDto> preguntaDtos = nivelDto.getPreguntas();

            PreguntaDto preguntaDto = preguntaDtos.get((int) (Math.random() * preguntaDtos.size()));

            System.out.println("\n" + preguntaDto.getContenido() + "\n");

            for (Opcion opcion : new ArrayList<>(preguntaDto.getOpciones())) {

                System.out.println(opcion.getContenido() + "   " + opcion.isRespuesta());

            }

        } else {

            nivelControl.insertar("Primera", 50, "Facil");

            PreguntaControl preguntaControl = new PreguntaControl();

            preguntaControl.insertar(nivel, "La mera pregunta");

            nivelDto = nivelControl.obtener(nivel);

            List<PreguntaDto> preguntaDtos = nivelDto.getPreguntas();

            for (PreguntaDto preguntaDto : preguntaDtos) {

                int preguntaId = preguntaDto.getPreguntaId();

                System.out.println(preguntaId);
                OpcionControl opcionControl = new OpcionControl();

                opcionControl.insertar(preguntaId, "A", true);
                opcionControl.insertar(preguntaId, "B", false);
                opcionControl.insertar(preguntaId, "C", false);
                opcionControl.insertar(preguntaId, "D", false);
            }

            nivelDto = nivelControl.obtener(nivel);


        }

    }

    private void createUIComponents() {

        this.setSize(760, 580);
        this.setLocationRelativeTo(null);

        infoLabel();

        lblCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblCerrarSesionActionPerformed();
            }
        });

        btnNivel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnNiveles(1);
            }
        });

        btnNivel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnNiveles(2);
            }
        });

        btnNivel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnNiveles(3);
            }
        });

        btnNivel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnNiveles(4);
            }
        });

        btnNivel5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnNiveles(5);
            }
        });


    }


}






