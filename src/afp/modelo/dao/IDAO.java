package afp.modelo.dao;

import java.util.List;

public interface IDAO<T> {

    void insert(T obj);

    T update(T obj);

    void delete(T obj);

    List<T> findAll();

    T findById(int id);
}
