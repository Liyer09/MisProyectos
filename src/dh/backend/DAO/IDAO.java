package dh.backend.DAO;

import java.util.List;

public interface IDAO <T>{

    T registrar(T objeto);

    List<T> ConsultarTodos();

    T ConsultarByID(Integer id);

    T BuscarPorCampo(String nombreCampo, String valorCampo);
}
