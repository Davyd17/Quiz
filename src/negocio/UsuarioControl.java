package negocio;

import datos.mysql.MySQLAdministradorDAO;
import datos.mysql.MySQLJugadorDAO;
import datos.mysql.MySQLUsuarioDAO;
import entidades.Administrador;
import entidades.Jugador;
import entidades.Usuario;
import mapper.AdminMapper;
import mapper.JugadorMapper;
import transferobject.UsuarioDto;

public class UsuarioControl {

    private final MySQLUsuarioDAO DATOS;
    private Usuario usuario;
    private UsuarioDto usuarioDto;

    public UsuarioControl() {
        DATOS = new MySQLUsuarioDAO();
        usuario = new Usuario();
    }

    public String registrar(String nombreUsuario, String contrasena, int rol) {

        MySQLUsuarioDAO existe = new MySQLUsuarioDAO();

        if (existe.existe(nombreUsuario)) {
            return "El usuario ya existe";
        } else {

            this.usuario.setNombreUsuario(nombreUsuario);
            this.usuario.setContrasena(contrasena);
            this.usuario.setRol(rol);

            if (DATOS.insertar(this.usuario)) {
                return "OK";
            } else {
                return "No fue posible realizar el registro";
            }
        }

    }

    public UsuarioDto IniciarSesion(String nombreUsuario, String contrasena){

        this.usuario = new MySQLUsuarioDAO().iniciarSesion(nombreUsuario,contrasena);

        if(this.usuario != null){
            if(this.usuario.getRol() == 1){

                Administrador administrador = new MySQLAdministradorDAO().obtenerPorUsuario(this.usuario.getId());

                this.usuarioDto = new AdminMapper().CreateDTO(administrador,this.usuario);

            } else if (this.usuario.getRol() == 2) {

                Jugador jugador = new MySQLJugadorDAO().obtenerPorUsuario(this.usuario.getId());

                this.usuarioDto = new JugadorMapper().CreateDTO(jugador, this.usuario);
            }
        }

        return usuarioDto;
    }


}