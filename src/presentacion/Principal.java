package presentacion;

import negocio.UsuarioControl;
import transferobject.AdminDto;
import transferobject.JugadorDto;
import transferobject.UsuarioDto;

import javax.swing.*;
import java.awt.event.*;

public class Principal extends JFrame{
    private JPanel pnlPrincipal;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogIn;
    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JLabel lblRegistro;
    private JLabel lblRegistroLink;
    private JLabel lblUsuarioIncorrecto;
    protected static JugadorDto jugadorDto;
    protected static AdminDto adminDto;
    protected static UsuarioDto usuarioDto;

    public Principal() {
        super("Quiz Game");
        this.setContentPane(pnlPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createUIComponents();
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

        usuarioDto = new UsuarioControl().IniciarSesion(txtUsuario.getText(),txtContrasena.getText());

        if(usuarioDto != null) {

            try {
                if (Class.forName("transferobject.AdminDto").isInstance(usuarioDto)) {

                    adminDto = (AdminDto) usuarioDto;
                    this.dispose();
                    InterfazAdministrador administrador = new InterfazAdministrador();
                    administrador.setVisible(true);


                } else if (Class.forName("transferobject.JugadorDto").isInstance(usuarioDto)) {

                    jugadorDto = (JugadorDto) usuarioDto;
                    this.dispose();
                    Juego juego = new Juego();
                    juego.setVisible(true);

                } else{
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else{

            lblUsuarioIncorrecto.setText("Nombre de usuario y/o contraseña incorrecto");
            txtUsuario.setText("");
            txtContrasena.setText("");

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
