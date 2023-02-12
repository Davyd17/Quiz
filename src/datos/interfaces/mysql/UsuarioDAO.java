package datos.interfaces.mysql;

import datos.interfaces.DAO;
import entidades.Usuario;

public interface UsuarioDAO extends DAO<Usuario>{

    Usuario iniciarSesion(String nombreUsuario, String contrasena);

    boolean existe(String texto);

}
