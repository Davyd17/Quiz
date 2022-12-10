package datos.interfaces;

import java.util.List;

public interface CrudJuegoInterface <T> {

    public T mostrar(int id);
    public List<T> listar();
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
}
