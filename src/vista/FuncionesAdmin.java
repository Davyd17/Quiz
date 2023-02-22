/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Info;
import controlador.SetImagen;
import controlador.funcionesadmin.AccesoComponentes;
import controlador.funcionesadmin.CerrarSesion;
import controlador.funcionesadmin.InfoControl;
import modelo.entidades.Opcion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.transferobject.NivelDto;
import modelo.transferobject.PreguntaDto;

/**
 *
 * @author PC1
 */
public class FuncionesAdmin extends javax.swing.JFrame {

    private final SetImagen SET_IMAGE = new SetImagen(this);
    private static NivelDto nivelDto;
    private static List<PreguntaDto> listaPreguntas;
    private static List<Opcion> listaOpciones;
    private static int preguntaIndice;
    private static int nivelSeleccionado;
    private final String URL_QUIZLOGO = "src/vista/images/quizLogo.png";
    private final String URL_ICONO = "vista/images/icono.png";
    private final AccesoComponentes ACCESO = new AccesoComponentes(this);
    private final InfoControl DATOS = new InfoControl(this);

    /**
     * Creates new form Juego
     */
    public FuncionesAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.SET_IMAGE.ajustarImagenLabel(lblLogo, URL_QUIZLOGO);
        this.lblNombreUsuario.setText(Info.getInfoAdmin().getNombreUsuario());
        this.ACCESO.setVistaComponentes(false, false, false);
        this.ACCESO.isEditable(false);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource(URL_ICONO));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOpciones = new javax.swing.ButtonGroup();
        pnlFuncionesAdmin = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblCerrarSesion = new javax.swing.JLabel();
        btnNivel1 = new javax.swing.JButton();
        btnNivel2 = new javax.swing.JButton();
        btnNivel3 = new javax.swing.JButton();
        btnNivel4 = new javax.swing.JButton();
        btnNivel5 = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblDificultad = new javax.swing.JLabel();
        btnPregunta1 = new javax.swing.JButton();
        btnPregunta2 = new javax.swing.JButton();
        btnPregunta3 = new javax.swing.JButton();
        btnPregunta4 = new javax.swing.JButton();
        btnPregunta5 = new javax.swing.JButton();
        rbtnOpcion1 = new javax.swing.JRadioButton();
        rbtnOpcion2 = new javax.swing.JRadioButton();
        rbtnOpcion3 = new javax.swing.JRadioButton();
        rbtnOpcion4 = new javax.swing.JRadioButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCategoria = new javax.swing.JTextField();
        txtPuntos = new javax.swing.JTextField();
        txtDificultad = new javax.swing.JTextField();
        scrolltxtPreguntaContenido = new javax.swing.JScrollPane();
        txtPreguntaContenido = new javax.swing.JTextArea();
        txtOpcion1 = new javax.swing.JTextField();
        txtOpcion2 = new javax.swing.JTextField();
        txtOpcion3 = new javax.swing.JTextField();
        txtOpcion4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUIZ!");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());

        pnlFuncionesAdmin.setBackground(new java.awt.Color(255, 255, 255));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/quizLogo.png"))); // NOI18N

        lblNombreUsuario.setText("Nombre de usuario");

        lblCerrarSesion.setText("Cerrar Sesion");
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
        });

        btnNivel1.setText("Nivel 1");
        btnNivel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivel1ActionPerformed(evt);
            }
        });

        btnNivel2.setText("Nivel 2");
        btnNivel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivel2ActionPerformed(evt);
            }
        });

        btnNivel3.setText("Nivel 3");
        btnNivel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivel3ActionPerformed(evt);
            }
        });

        btnNivel4.setText("Nivel 4");
        btnNivel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivel4ActionPerformed(evt);
            }
        });

        btnNivel5.setText("Nivel 5");
        btnNivel5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivel5ActionPerformed(evt);
            }
        });

        lblCategoria.setText("Categoria:");

        lblPuntos.setText("Puntos:");

        lblDificultad.setText("Dificultad:");

        btnPregunta1.setText("Pregunta 1");
        btnPregunta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregunta1ActionPerformed(evt);
            }
        });

        btnPregunta2.setText("Pregunta 2");
        btnPregunta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregunta2ActionPerformed(evt);
            }
        });

        btnPregunta3.setText("Pregunta 3");
        btnPregunta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregunta3ActionPerformed(evt);
            }
        });

        btnPregunta4.setText("Pregunta 4");
        btnPregunta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregunta4ActionPerformed(evt);
            }
        });

        btnPregunta5.setText("Pregunta 5");
        btnPregunta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPregunta5ActionPerformed(evt);
            }
        });

        grupoOpciones.add(rbtnOpcion1);

        grupoOpciones.add(rbtnOpcion2);

        grupoOpciones.add(rbtnOpcion3);

        grupoOpciones.add(rbtnOpcion4);

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtPreguntaContenido.setColumns(20);
        txtPreguntaContenido.setRows(5);
        scrolltxtPreguntaContenido.setViewportView(txtPreguntaContenido);

        javax.swing.GroupLayout pnlFuncionesAdminLayout = new javax.swing.GroupLayout(pnlFuncionesAdmin);
        pnlFuncionesAdmin.setLayout(pnlFuncionesAdminLayout);
        pnlFuncionesAdminLayout.setHorizontalGroup(
            pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFuncionesAdminLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPregunta1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFuncionesAdminLayout.createSequentialGroup()
                        .addComponent(btnNivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnNivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDificultad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFuncionesAdminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPregunta2)
                        .addGap(53, 53, 53)))
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addComponent(lblPuntos)
                        .addGap(18, 18, 18)
                        .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(txtDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFuncionesAdminLayout.createSequentialGroup()
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                                .addGap(0, 9, Short.MAX_VALUE)
                                .addComponent(btnNivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnPregunta3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                                .addComponent(btnPregunta4)
                                .addGap(60, 60, 60)
                                .addComponent(btnPregunta5))
                            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                                .addComponent(btnNivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnNivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFuncionesAdminLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblCerrarSesion))
                .addGap(19, 19, 19))
            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrolltxtPreguntaContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addComponent(rbtnOpcion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOpcion1))
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtnOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnOpcion3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOpcion2)
                            .addComponent(txtOpcion3)
                            .addComponent(txtOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(100, 100, 100)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnGuardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFuncionesAdminLayout.setVerticalGroup(
            pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreUsuario)
                .addGap(9, 9, 9)
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCerrarSesion))
                .addGap(18, 18, 18)
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnNivel1)
                                    .addComponent(btnNivel5)
                                    .addComponent(btnNivel2))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFuncionesAdminLayout.createSequentialGroup()
                                .addComponent(btnNivel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(lblPuntos)
                            .addComponent(lblDificultad)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPregunta1)
                            .addComponent(btnPregunta2)
                            .addComponent(btnPregunta3)
                            .addComponent(btnPregunta4)
                            .addComponent(btnPregunta5)))
                    .addComponent(btnNivel4))
                .addGap(18, 18, 18)
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbtnOpcion3)
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                                .addComponent(scrolltxtPreguntaContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(rbtnOpcion1))
                            .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(txtOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtnOpcion2)
                            .addComponent(txtOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtOpcion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addComponent(rbtnOpcion4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFuncionesAdminLayout.createSequentialGroup()
                        .addComponent(txtOpcion4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)))
                .addGroup(pnlFuncionesAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEditar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFuncionesAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFuncionesAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        if (nivelDto != null) {

            this.ACCESO.setVistaComponentes(true, true, true);

            if (listaPreguntas == null || listaPreguntas.get(preguntaIndice - 1) == null) {
                this.ACCESO.setVistaComponentes(true, true, false);
            }

        } else {
            this.ACCESO.setVistaComponentes(false, false, false);
        }

        this.ACCESO.isEditable(false);
        this.DATOS.getInfo();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (DATOS.validarCamposVacios()) {

            if (nivelDto != null && listaPreguntas != null && preguntaIndice <= listaPreguntas.size() - 1) {

                if (DATOS.editInfo()) {
                    this.ACCESO.isEditable(false);
                    this.DATOS.getInfo();
                }
            } else if (nivelDto == null) {

                if (this.DATOS.insertNewNivel()) {
                    this.ACCESO.isEditable(false);
                    this.DATOS.getInfo();
                    this.ACCESO.setVistaComponentes(true, true, false);
                }

            } else {

                if (this.DATOS.insertNewPregunta()) {
                    this.ACCESO.isEditable(false);
                    this.DATOS.getInfo();
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        this.ACCESO.isEditable(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPregunta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregunta5ActionPerformed

        preguntaIndice = 4;
        this.ACCESO.setVistaComponentes(true, true, true);

        if (listaPreguntas != null && preguntaIndice <= listaPreguntas.size() - 1) {

            this.ACCESO.isEditable(false);
            this.DATOS.getInfo();

        } else {

            this.DATOS.vaciarCampos(false, true);
            this.ACCESO.isEditable(true);

        }
    }//GEN-LAST:event_btnPregunta5ActionPerformed

    private void btnPregunta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregunta4ActionPerformed

        preguntaIndice = 3;
        this.ACCESO.setVistaComponentes(true, true, true);

        if (listaPreguntas != null && preguntaIndice <= listaPreguntas.size() - 1) {

            this.ACCESO.isEditable(false);
            this.DATOS.getInfo();

        } else {

            this.DATOS.vaciarCampos(false, true);
            this.ACCESO.isEditable(true);

        }
    }//GEN-LAST:event_btnPregunta4ActionPerformed

    private void btnPregunta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregunta3ActionPerformed

        preguntaIndice = 2;
        this.ACCESO.setVistaComponentes(true, true, true);

        if (listaPreguntas != null && preguntaIndice <= listaPreguntas.size() - 1) {

            this.ACCESO.isEditable(false);
            this.DATOS.getInfo();

        } else {

            this.DATOS.vaciarCampos(false, true);
            this.ACCESO.isEditable(true);

        }
    }//GEN-LAST:event_btnPregunta3ActionPerformed

    private void btnPregunta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregunta2ActionPerformed

        preguntaIndice = 1;
        this.ACCESO.setVistaComponentes(true, true, true);

        if (listaPreguntas != null && preguntaIndice <= listaPreguntas.size() - 1) {

            this.ACCESO.isEditable(false);
            this.DATOS.getInfo();

        } else {

            this.DATOS.vaciarCampos(false, true);
            this.ACCESO.isEditable(true);

        }
    }//GEN-LAST:event_btnPregunta2ActionPerformed

    private void btnPregunta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPregunta1ActionPerformed

        preguntaIndice = 0;

        this.ACCESO.setVistaComponentes(true, true, true);

        if (listaPreguntas != null && preguntaIndice <= listaPreguntas.size() - 1) {

            this.ACCESO.isEditable(false);
            this.DATOS.getInfo();

        } else {

            this.DATOS.vaciarCampos(false, true);
            this.ACCESO.isEditable(true);

        }
    }//GEN-LAST:event_btnPregunta1ActionPerformed

    private void btnNivel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivel1ActionPerformed

        nivelSeleccionado = 1;

        if (this.DATOS.getInfo()) {
            this.ACCESO.setVistaComponentes(true, true, false);
            this.ACCESO.isEditable(false);

        } else {

            this.ACCESO.setVistaComponentes(true, false, false);
            this.DATOS.vaciarCampos(true, true);
            this.ACCESO.isEditable(true);

        }

    }//GEN-LAST:event_btnNivel1ActionPerformed

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked

        CerrarSesion cerrarSesion = new CerrarSesion(this);
        cerrarSesion.mouseClicked(evt);
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void btnNivel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivel2ActionPerformed
        
        nivelSeleccionado = 2;

        if (this.DATOS.getInfo()) {
            this.ACCESO.setVistaComponentes(true, true, false);
            this.ACCESO.isEditable(false);

        } else {

            this.ACCESO.setVistaComponentes(true, false, false);
            this.DATOS.vaciarCampos(true, true);
            this.ACCESO.isEditable(true);

        }

    }//GEN-LAST:event_btnNivel2ActionPerformed

    private void btnNivel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivel3ActionPerformed
        
        nivelSeleccionado = 3;

        if (this.DATOS.getInfo()) {
            this.ACCESO.setVistaComponentes(true, true, false);
            this.ACCESO.isEditable(false);

        } else {

            this.ACCESO.setVistaComponentes(true, false, false);
            this.DATOS.vaciarCampos(true, true);
            this.ACCESO.isEditable(true);

        }

    }//GEN-LAST:event_btnNivel3ActionPerformed

    private void btnNivel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivel4ActionPerformed
        
        nivelSeleccionado = 4;

        if (this.DATOS.getInfo()) {
            this.ACCESO.setVistaComponentes(true, true, false);
            this.ACCESO.isEditable(false);

        } else {

            this.ACCESO.setVistaComponentes(true, false, false);
            this.DATOS.vaciarCampos(true, true);
            this.ACCESO.isEditable(true);

        }

    }//GEN-LAST:event_btnNivel4ActionPerformed

    private void btnNivel5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivel5ActionPerformed
        
        nivelSeleccionado = 5;

        if (this.DATOS.getInfo()) {
            this.ACCESO.setVistaComponentes(true, true, false);
            this.ACCESO.isEditable(false);

        } else {

            this.ACCESO.setVistaComponentes(true, false, false);
            this.DATOS.vaciarCampos(true, true);
            this.ACCESO.isEditable(true);

        }

    }//GEN-LAST:event_btnNivel5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionesAdmin().setVisible(true);
            }
        });
    }

    // Getter & Setter
    public static int getNivelSeleccionado() {
        return nivelSeleccionado;
    }

    public static void setNivelSeleccionado(int nivelSeleccionado) {
        FuncionesAdmin.nivelSeleccionado = nivelSeleccionado;
    }

    public static int getPreguntaIndice() {
        return preguntaIndice;
    }

    public static void setPreguntaIndice(int preguntaIndice) {
        FuncionesAdmin.preguntaIndice = preguntaIndice;
    }

    public JRadioButton getRbtnOpcion1() {
        return rbtnOpcion1;
    }

    public void setRbtnOpcion1(JRadioButton rbtnOpcion1) {
        this.rbtnOpcion1 = rbtnOpcion1;
    }

    public JRadioButton getRbtnOpcion2() {
        return rbtnOpcion2;
    }

    public void setRbtnOpcion2(JRadioButton rbtnOpcion2) {
        this.rbtnOpcion2 = rbtnOpcion2;
    }

    public JRadioButton getRbtnOpcion3() {
        return rbtnOpcion3;
    }

    public void setRbtnOpcion3(JRadioButton rbtnOpcion3) {
        this.rbtnOpcion3 = rbtnOpcion3;
    }

    public JRadioButton getRbtnOpcion4() {
        return rbtnOpcion4;
    }

    public void setRbtnOpcion4(JRadioButton rbtnOpcion4) {
        this.rbtnOpcion4 = rbtnOpcion4;
    }

    public JTextField getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(JTextField txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public JTextField getTxtDificultad() {
        return txtDificultad;
    }

    public void setTxtDificultad(JTextField txtDificultad) {
        this.txtDificultad = txtDificultad;
    }

    public JTextField getTxtOpcion1() {
        return txtOpcion1;
    }

    public void setTxtOpcion1(JTextField txtOpcion1) {
        this.txtOpcion1 = txtOpcion1;
    }

    public JTextField getTxtOpcion2() {
        return txtOpcion2;
    }

    public void setTxtOpcion2(JTextField txtOpcion2) {
        this.txtOpcion2 = txtOpcion2;
    }

    public JTextField getTxtOpcion3() {
        return txtOpcion3;
    }

    public void setTxtOpcion3(JTextField txtOpcion3) {
        this.txtOpcion3 = txtOpcion3;
    }

    public JTextField getTxtOpcion4() {
        return txtOpcion4;
    }

    public void setTxtOpcion4(JTextField txtOpcion4) {
        this.txtOpcion4 = txtOpcion4;
    }

    public JTextArea getTxtPreguntaContenido() {
        return txtPreguntaContenido;
    }

    public void setTxtPreguntaContenido(JTextArea txtPreguntaContenido) {
        this.txtPreguntaContenido = txtPreguntaContenido;
    }

    public JTextField getTxtPuntos() {
        return txtPuntos;
    }

    public void setTxtPuntos(JTextField txtPuntos) {
        this.txtPuntos = txtPuntos;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnPregunta1() {
        return btnPregunta1;
    }

    public void setBtnPregunta1(JButton btnPregunta1) {
        this.btnPregunta1 = btnPregunta1;
    }

    public JButton getBtnPregunta2() {
        return btnPregunta2;
    }

    public void setBtnPregunta2(JButton btnPregunta2) {
        this.btnPregunta2 = btnPregunta2;
    }

    public JButton getBtnPregunta3() {
        return btnPregunta3;
    }

    public void setBtnPregunta3(JButton btnPregunta3) {
        this.btnPregunta3 = btnPregunta3;
    }

    public JButton getBtnPregunta4() {
        return btnPregunta4;
    }

    public void setBtnPregunta4(JButton btnPregunta4) {
        this.btnPregunta4 = btnPregunta4;
    }

    public JButton getBtnPregunta5() {
        return btnPregunta5;
    }

    public void setBtnPregunta5(JButton btnPregunta5) {
        this.btnPregunta5 = btnPregunta5;
    }

    public JLabel getLblCategoria() {
        return lblCategoria;
    }

    public void setLblCategoria(JLabel lblCategoria) {
        this.lblCategoria = lblCategoria;
    }

    public JLabel getLblDificultad() {
        return lblDificultad;
    }

    public void setLblDificultad(JLabel lblDificultad) {
        this.lblDificultad = lblDificultad;
    }

    public JLabel getLblPuntos() {
        return lblPuntos;
    }

    public void setLblPuntos(JLabel lblPuntos) {
        this.lblPuntos = lblPuntos;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JScrollPane getScrolltxtPreguntaContenido() {
        return scrolltxtPreguntaContenido;
    }

    public void setScrolltxtPreguntaContenido(JScrollPane scrolltxtPreguntaContenido) {
        this.scrolltxtPreguntaContenido = scrolltxtPreguntaContenido;
    }

    public static NivelDto getNivelDto() {
        return nivelDto;
    }

    public static void setNivelDto(NivelDto nivelDto) {
        FuncionesAdmin.nivelDto = nivelDto;
    }

    public static List<PreguntaDto> getListaPreguntas() {
        return listaPreguntas;
    }

    public static void setListaPreguntas(List<PreguntaDto> listaPreguntas) {
        FuncionesAdmin.listaPreguntas = listaPreguntas;
    }

    public static List<Opcion> getListaOpciones() {
        return listaOpciones;
    }

    public static void setListaOpciones(List<Opcion> listaOpciones) {
        FuncionesAdmin.listaOpciones = listaOpciones;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNivel1;
    private javax.swing.JButton btnNivel2;
    private javax.swing.JButton btnNivel3;
    private javax.swing.JButton btnNivel4;
    private javax.swing.JButton btnNivel5;
    private javax.swing.JButton btnPregunta1;
    private javax.swing.JButton btnPregunta2;
    private javax.swing.JButton btnPregunta3;
    private javax.swing.JButton btnPregunta4;
    private javax.swing.JButton btnPregunta5;
    private javax.swing.ButtonGroup grupoOpciones;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblDificultad;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JPanel pnlFuncionesAdmin;
    private javax.swing.JRadioButton rbtnOpcion1;
    private javax.swing.JRadioButton rbtnOpcion2;
    private javax.swing.JRadioButton rbtnOpcion3;
    private javax.swing.JRadioButton rbtnOpcion4;
    private javax.swing.JScrollPane scrolltxtPreguntaContenido;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtDificultad;
    private javax.swing.JTextField txtOpcion1;
    private javax.swing.JTextField txtOpcion2;
    private javax.swing.JTextField txtOpcion3;
    private javax.swing.JTextField txtOpcion4;
    private javax.swing.JTextArea txtPreguntaContenido;
    private javax.swing.JTextField txtPuntos;
    // End of variables declaration//GEN-END:variables
}
