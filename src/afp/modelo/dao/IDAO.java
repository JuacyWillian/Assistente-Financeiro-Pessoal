package afp.modelo.dao;

import java.util.List;

public interface IDAO<T> {

    T insert(T obj);

    T update(T obj);

    boolean delete(T obj);

    List<T> findAll();

    T findById(int id);
}
