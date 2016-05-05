package afp.model.dao;

import java.util.List;

public interface IDAO<T> {

    boolean insert(T obj);

    int insertMany(List<T> listObject);

    boolean update(T obj);

    int updateMany(List<T> listObject);

    boolean delete(T obj);

    int deleteMany(List<T> listObject);

    List<T> findAll();

    T findOne(T obj);
}
