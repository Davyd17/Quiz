package presentacion;

import negocio.UsuarioControl;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Principal extends JFrame{
    private JPanel pnlPrincipal;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogIn;
    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JLabel lblRegistro;
    private JLabel lblRegistroLink;
    private UsuarioControl  usuarioControl;

    public Principal() {
        super("Quiz Game");
        this.setContentPane(pnlPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createUIComponents();
        usuarioControl = new UsuarioControl();
    }

    @SuppressWarnings("unchecked")
    private void createUIComponents() {

        this.setSize(400,380);
        this.setLocationRelativeTo(null);

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLoginActionPerformed();
            }
        });

        lblRegistroLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblRegistrarActionPerformed(e);
            }
        });

    }

    private void btnLoginActionPerformed(){

        List<String> info = new ArrayList<>(usuarioControl.inciarSesion(txtUsuario.getText(), txtContrasena.getText()));

        if(info.isEmpty()){

            JOptionPane.showMessageDialog(this,"Nombre de usuario y/o contraseña incorrectos","Error",JOptionPane.WARNING_MESSAGE);
        } else{

            JOptionPane.showMessageDialog(this, info);
        }

    }
    private void lblRegistrarActionPerformed(MouseEvent e){
        this.dispose();
        RegistroJugador rj = new RegistroJugador();
        rj.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Principal().setVisible(true);

            }
        });
    }

}
