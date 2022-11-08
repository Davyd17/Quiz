package negocio;

import datos.UsuarioDAO;
import entidades.Usuario;

public class UsuarioControl {

    private final UsuarioDAO DATOS;
    private final Usuario OBJ;

    public UsuarioControl(){
        DATOS = new UsuarioDAO();
        OBJ = new Usuario();
    }

    public String registrar(String usuario,String contraseña) {
        String resp = "0";

        return "0";

    }


}
