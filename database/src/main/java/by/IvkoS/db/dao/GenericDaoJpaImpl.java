package by.IvkoS.db.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

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
    @Transactional
    public T create(T t) {
        this.hibernateTemplate.persist(t);
        return t;
    }

    @Override
    public T read(PK id) {
        return this.hibernateTemplate.get(entityClass, id);
    }

    @Override
    @Transactional
    public T update(T t) {
        return this.hibernateTemplate.merge(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        t = this.hibernateTemplate.merge(t);
        this.hibernateTemplate.delete(t);
    }
}
