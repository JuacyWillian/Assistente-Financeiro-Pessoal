package afp.modelo.dao;

import java.util.List;

public interface IDAO<T> {

    boolean insert(T obj);

    boolean update(T obj);

    boolean delete(T obj);

    List<T> findAll();

    T findOne(T obj);

    T findById(int id);
}
