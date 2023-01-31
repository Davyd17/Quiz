package mapper;

import entidades.Administrador;
import entidades.Usuario;
import transferobject.AdminDto;

public class AdminMapper {

    public AdminDto CreateDTO(Administrador administrador, Usuario usuario){

        return new AdminDto(
                administrador.getUsuarioId(),
                administrador.getId(),
                usuario.getNombreUsuario()
        );
    }
}
