package presentacion;

import negocio.UsuarioControl;

import javax.swing.*;
import java.awt.event.*;


public class RegistroJugador extends  javax.swing.JFrame{

    private JPanel pnlRegistroJ;
    private JLabel lblNombreUsuario;
    private JLabel lblContraseña;
    private JTextField txtNombreUsuario;
    private JTextField txtContrasena;
    private JButton btnRegistro;
    private JLabel lblVolver;
    private JLabel lblRegistroExistoso;
    private JLabel lblClaveAdmin;
    private JTextField textField1;
    private JLabel lblRegistroAdmin;
    private UsuarioControl usuarioControl;
    private String claveAdmin;
    private static short rol;

    public RegistroJugador(){
        super("Registro");
        this.createUIComponents();
        this.setContentPane(pnlRegistroJ);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.lblRegistroExistoso.setVisible(false);
        lblRegistroAdmin.setText("¿Administrador?");
        rol = 2;

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

        lblRegistroAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblRegistroAdminActionPerformed(e);
            }
        });

    }

    private void lblRegistroAdminActionPerformed(MouseEvent e){

        short count = 3;

        do{

            claveAdmin = JOptionPane.showInputDialog("Ingrese clave de administrador");

            if(!claveAdmin.equals("746")){
                count -= 1;
                JOptionPane.showMessageDialog(this, "Clave incorrrecta, tiene " + count + " intentos");
                if(count == 0) break;
            } else{
                rol = 1;
                lblRegistroAdmin.setText("Registro de administrador");
            }

        } while(!claveAdmin.equals("746"));

    }

    private void btnRegistroActionPerformed(ActionEvent e){

        usuarioControl = new UsuarioControl();


        String result = usuarioControl.registrar(txtNombreUsuario.getText(),txtContrasena.getText(),rol);

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
