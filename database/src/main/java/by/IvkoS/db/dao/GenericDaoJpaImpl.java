package by.IvkoS.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

public class GenericDaoJpaImpl<T, PK extends Serializable>
        implements GenericDao<T, PK>  {

    protected Class<T> entityClass;

    @Autowired
    protected HibernateTemplate hibernateTemplate;

    public GenericDaoJpaImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        this.hibernateTemplate.persist(t);
        return t;
    }

    @Override
    public T read(PK id) {
        return this.hibernateTemplate.get(entityClass, id);
    }

    @Override
    public T update(T t) {
        return this.hibernateTemplate.merge(t);
    }

    @Override
    public T delete(T t) {
        t = this.hibernateTemplate.merge(t);
        this.hibernateTemplate.delete(t);
        return t;
    }

    @Override
    public List<T> readList() {
        List<T> itemList = this.hibernateTemplate.loadAll(entityClass);
        if(itemList!=null){
            return itemList;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public T deleteById(PK id) {
        T t = this.hibernateTemplate.get(entityClass, id);
        this.hibernateTemplate.delete(t);
        return t;
    }
}
