package presentacion;

import negocio.UsuarioControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RegistroJugador extends  javax.swing.JFrame{

    private JPanel pnlRegistroJ;
    private JLabel lblNombreUsuario;
    private JLabel lblContraseña;
    private JTextField txtNombreUsuario;
    private JTextField txtContrasena;
    private JButton btnRegistro;
    private JLabel lblVolver;
    private JLabel lblRegistroExistoso;
    private UsuarioControl usuarioControl;

    public RegistroJugador(){
        super("Registro");
        this.createUIComponents();
        this.setContentPane(pnlRegistroJ);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.lblRegistroExistoso.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    private void createUIComponents(){

        this.setSize(400,380);
        this.setLocationRelativeTo(null);



        lblVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblVolverActionPerformed(e);
            }
        });

        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegistroActionPerformed(e);
            }
        });
    }

    private void btnRegistroActionPerformed(ActionEvent e){

        usuarioControl = new UsuarioControl();

        String result = usuarioControl.registrar(txtNombreUsuario.getText(),txtContrasena.getText(),2);

        if (result.equals("OK")){
            lblRegistroExistoso.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,result);
        }

        txtNombreUsuario.setText("");
        txtContrasena.setText("");

    }

    private void lblVolverActionPerformed(MouseEvent e){
        this.dispose();
        Principal principal = new Principal();
        principal.setVisible(true);
    }


}
