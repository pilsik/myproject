package by.IvkoS.db.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {

    T create(T t);
    T read(PK id);
    T update(T t);
    T delete(T t);
    List<T> readList();
    T deleteById(PK id);
}
