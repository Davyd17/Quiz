package modelo.datos.interfaces;

import modelo.datos.interfaces.DAO;
import modelo.entidades.Usuario;

public interface UsuarioDAO extends DAO<Usuario>{

    Usuario iniciarSesion(String nombreUsuario, String contrasena);

    boolean existe(String texto);

}
