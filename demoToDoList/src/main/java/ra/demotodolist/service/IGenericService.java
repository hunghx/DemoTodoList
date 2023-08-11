package ra.demotodolist.service;

import java.util.List;

public interface IGenericService <T,E>{
    List<T> findAll();
    void save(T t);
    void delete(E id);
    T findById(E e);
}
