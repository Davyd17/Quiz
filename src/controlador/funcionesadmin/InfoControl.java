/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.funcionesadmin;

import controlador.Info;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.negocio.NivelControl;
import modelo.negocio.OpcionControl;
import modelo.negocio.PreguntaControl;
import modelo.transferobject.PreguntaDto;
import vista.FuncionesAdmin;

public class InfoControl {

    private final FuncionesAdmin FUNCIONESADMIN;
    private boolean resultado;

    public InfoControl(FuncionesAdmin FUNCIONESADMIN) {
        this.FUNCIONESADMIN = FUNCIONESADMIN;
    }

    public boolean getInfo() {

        Info.setNivelDto(new NivelControl().obtener(FuncionesAdmin.getNivelSeleccionado()));

        if (FuncionesAdmin.getNivelDto() != null) {

            FuncionesAdmin.setListaPreguntas(FuncionesAdmin.getNivelDto().getPreguntas());

            FUNCIONESADMIN.getTxtCategoria().setText(FuncionesAdmin.getNivelDto().getCategoria());
            FUNCIONESADMIN.getTxtPuntos().setText(Integer.toString(FuncionesAdmin.getNivelDto().getPuntos()));
            FUNCIONESADMIN.getTxtDificultad().setText(FuncionesAdmin.getNivelDto().getDificultad());
            resultado = true;

            if (!FuncionesAdmin.getListaPreguntas().isEmpty()) {

                PreguntaDto preguntaDto = FuncionesAdmin.getListaPreguntas().get(FuncionesAdmin.getPreguntaIndice());
                FuncionesAdmin.setListaOpciones(preguntaDto.getOpciones());

                FUNCIONESADMIN.getTxtPreguntaContenido().setText(preguntaDto.getContenido());

                FUNCIONESADMIN.getTxtOpcion1().setText(FuncionesAdmin.getListaOpciones().get(0).getContenido());
                FUNCIONESADMIN.getRbtnOpcion1().setSelected(FuncionesAdmin.getListaOpciones().get(0).isRespuesta());

                FUNCIONESADMIN.getTxtOpcion2().setText(FuncionesAdmin.getListaOpciones().get(1).getContenido());
                FUNCIONESADMIN.getRbtnOpcion2().setSelected(FuncionesAdmin.getListaOpciones().get(1).isRespuesta());

                FUNCIONESADMIN.getTxtOpcion3().setText(FuncionesAdmin.getListaOpciones().get(2).getContenido());
                FUNCIONESADMIN.getRbtnOpcion3().setSelected(FuncionesAdmin.getListaOpciones().get(2).isRespuesta());

                FUNCIONESADMIN.getTxtOpcion4().setText(FuncionesAdmin.getListaOpciones().get(3).getContenido());
                FUNCIONESADMIN.getRbtnOpcion4().setSelected(FuncionesAdmin.getListaOpciones().get(3).isRespuesta());
                resultado = true;
            }
        } else {
            resultado = false;
        }

        return resultado;

    }

    public boolean validarCamposVacios() {

        if (FuncionesAdmin.getNivelDto() == null) {

            if (FUNCIONESADMIN.getTxtCategoria().getText().isEmpty()
                    || FUNCIONESADMIN.getTxtDificultad().getText().isEmpty()
                    || FUNCIONESADMIN.getTxtPuntos().getText().isEmpty()) {

                JOptionPane.showMessageDialog(FUNCIONESADMIN, "Todos los campos son obligatorios", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {

                resultado = true;

            }

        } else if (FUNCIONESADMIN.getTxtCategoria().getText().isEmpty()
                || FUNCIONESADMIN.getTxtDificultad().getText().isEmpty()
                || FUNCIONESADMIN.getTxtPuntos().getText().isEmpty()
                || FUNCIONESADMIN.getTxtPreguntaContenido().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion1().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion2().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion3().getText().isEmpty()
                || FUNCIONESADMIN.getTxtOpcion4().getText().isEmpty()) {

            JOptionPane.showMessageDialog(FUNCIONESADMIN, "Todos los campos son obligatorios", "Advertencia", JOptionPane.INFORMATION_MESSAGE);

        } else {

            resultado = true;
        }

        return resultado;

    }

    public void vaciarCampos(boolean seccionNivel, boolean seccionPregunta) {

        if (seccionNivel) {

            FUNCIONESADMIN.getTxtCategoria().setText("");
            FUNCIONESADMIN.getTxtDificultad().setText("");
            FUNCIONESADMIN.getTxtPuntos().setText("");

        }
        if (seccionPregunta) {

            FUNCIONESADMIN.getTxtPreguntaContenido().setText("");

            FUNCIONESADMIN.getTxtOpcion1().setText("");
            FUNCIONESADMIN.getTxtOpcion2().setText("");
            FUNCIONESADMIN.getTxtOpcion3().setText("");
            FUNCIONESADMIN.getTxtOpcion4().setText("");

            FUNCIONESADMIN.getRbtnOpcion1().setSelected(seccionPregunta);
            FUNCIONESADMIN.getRbtnOpcion2().setSelected(seccionPregunta);
            FUNCIONESADMIN.getRbtnOpcion3().setSelected(seccionPregunta);
            FUNCIONESADMIN.getRbtnOpcion4().setSelected(seccionPregunta);

        }

    }

    public boolean editInfo() {

        boolean nivelEditado = new NivelControl().editar(FuncionesAdmin.getNivelSeleccionado(),
                FUNCIONESADMIN.getTxtCategoria().getText(),
                Integer.parseInt(FUNCIONESADMIN.getTxtPuntos().getText()),
                FUNCIONESADMIN.getTxtDificultad().getText());

        boolean preguntaEditada = new PreguntaControl().editar(FuncionesAdmin.getListaPreguntas().get(FuncionesAdmin.getPreguntaIndice()).getPreguntaId(),
                FuncionesAdmin.getNivelDto().getNivelId(),
                FUNCIONESADMIN.getTxtPreguntaContenido().getText());

        boolean opcionesEditadas = false;

        JTextField[] opcionesTextField = new JTextField[4];
        opcionesTextField[0] = FUNCIONESADMIN.getTxtOpcion1();
        opcionesTextField[1] = FUNCIONESADMIN.getTxtOpcion2();
        opcionesTextField[2] = FUNCIONESADMIN.getTxtOpcion3();
        opcionesTextField[3] = FUNCIONESADMIN.getTxtOpcion4();

        JRadioButton[] botonOpciones = new JRadioButton[4];
        botonOpciones[0] = FUNCIONESADMIN.getRbtnOpcion1();
        botonOpciones[1] = FUNCIONESADMIN.getRbtnOpcion2();
        botonOpciones[2] = FUNCIONESADMIN.getRbtnOpcion3();
        botonOpciones[3] = FUNCIONESADMIN.getRbtnOpcion4();

        int validacion = 0;
        for (int i = 0; i <= FuncionesAdmin.getListaOpciones().size() - 1; i++) {

            if (new OpcionControl().editar(FuncionesAdmin.getListaOpciones().get(i).getId(), FuncionesAdmin.getListaOpciones().get(i).getPreguntaId(),
                    opcionesTextField[i].getText(), botonOpciones[i].isSelected())) {
                validacion++;
            }

            if (validacion == FuncionesAdmin.getListaOpciones().size() - 1) {
                opcionesEditadas = true;
            }

        }

        if (nivelEditado && preguntaEditada && opcionesEditadas) {

            resultado = true;

        } else {
            JOptionPane.showMessageDialog(FUNCIONESADMIN, "Hubo un error en la edicion", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    public boolean insertNewNivel() {

        NivelControl nivelControl = new NivelControl();

        boolean nivelCreado = nivelControl.insertar(FuncionesAdmin.getNivelSeleccionado(),
                FUNCIONESADMIN.getTxtCategoria().getText(),
                Integer.parseInt(FUNCIONESADMIN.getTxtPuntos().getText()),
                FUNCIONESADMIN.getTxtDificultad().getText());

        FuncionesAdmin.setNivelDto(nivelControl.obtener(FuncionesAdmin.getNivelSeleccionado()));

        return nivelCreado;
    }

    public boolean insertNewPregunta() {

        PreguntaControl preguntaControl = new PreguntaControl();

        boolean preguntaCreada = preguntaControl.insertar(FuncionesAdmin.getNivelDto().getNivelId(), FUNCIONESADMIN.getTxtPreguntaContenido().getText());

        FuncionesAdmin.setNivelDto(new NivelControl().obtener(FuncionesAdmin.getNivelSeleccionado()));

        int preguntaId = FuncionesAdmin.getNivelDto().getPreguntas().get(FuncionesAdmin.getPreguntaIndice()).getPreguntaId();

        JTextField[] opcionesTextField = new JTextField[4];
        opcionesTextField[0] = FUNCIONESADMIN.getTxtOpcion1();
        opcionesTextField[1] = FUNCIONESADMIN.getTxtOpcion2();
        opcionesTextField[2] = FUNCIONESADMIN.getTxtOpcion3();
        opcionesTextField[3] = FUNCIONESADMIN.getTxtOpcion4();

        JRadioButton[] botonOpciones = new JRadioButton[4];
        botonOpciones[0] = FUNCIONESADMIN.getRbtnOpcion1();
        botonOpciones[1] = FUNCIONESADMIN.getRbtnOpcion2();
        botonOpciones[2] = FUNCIONESADMIN.getRbtnOpcion3();
        botonOpciones[3] = FUNCIONESADMIN.getRbtnOpcion4();

        boolean opcionesEditadas = false;

        int validacion = 0;
        for (int i = 0; i <= 3; i++) {

            if (new OpcionControl().insertar(preguntaId,
                    opcionesTextField[i].getText(),
                    botonOpciones[i].isSelected())) {
                validacion++;
            }
        }

        if (validacion == 4) {
            opcionesEditadas = true;
        }

        if (preguntaCreada && opcionesEditadas) {
            resultado = true;

        } else {
            JOptionPane.showMessageDialog(FUNCIONESADMIN, "Hubo un error en la creacion", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

}
