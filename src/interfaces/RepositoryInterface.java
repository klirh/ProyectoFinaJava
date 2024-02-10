package interfaces;

import java.util.List;


public interface RepositoryInterface<T>{
    public T recuperarId(Long id); //si quiero recuperar mano la id
    public List<T> recuperarTodos(); //Si quiero recuprar todos no le mando nada
    public void agregar(T entidad); //Si quiero agregar Le mando la entidad que quiero agregar
    public void modificar(T entidad); // Si quiero modificar Le mando la entidad que quiero modificar
    public void eliminar(T entidad); // Si quiero eliminar le mando la entidad que quiero eliminar
}