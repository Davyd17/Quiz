package modelo.mapper;

import modelo.entidades.Administrador;
import modelo.entidades.Usuario;
import modelo.transferobject.AdminDto;

public class AdminMapper {

    public AdminDto CreateDTO(Administrador administrador, Usuario usuario){

        return new AdminDto(
                administrador.getUsuarioId(),
                administrador.getId(),
                usuario.getNombreUsuario()
        );
    }
}
