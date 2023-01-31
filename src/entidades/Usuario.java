package entidades;

// Entidad que mapea la tabla usuario de la base de datos
public class Usuario {

    // Atributos
    private int id;
    private String nombreUsuario;
    private String contrasena;
    private int rol; // El rol se define entre 1 y 2: (1 - Administrador), (2 - Jugador)

    // Constructor
    public Usuario(){
    }

    //Constructor por defecto
    public Usuario(int id, String nombreUsuario, String contrasena, int rol){
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int adminId) {
        this.id = adminId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", rol=" + rol +
                '}';
    }
}
