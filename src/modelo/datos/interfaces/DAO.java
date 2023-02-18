package modelo.datos.interfaces;

import java.util.List;

public interface DAO<T>{

    boolean insertar(T obj);
    T obtener(int id);
    List<T> obtenerTodos();
    boolean actualizar(T obj);
    boolean eliminar();

}
