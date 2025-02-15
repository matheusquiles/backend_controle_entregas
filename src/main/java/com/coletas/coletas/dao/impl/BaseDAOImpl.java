package com.coletas.coletas.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.coletas.coletas.dao.BaseDAO;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Transactional
public abstract class BaseDAOImpl<T, ID> implements BaseDAO<T, ID> {
	
	@Autowired
    protected EntityManager entityManager;

 	private final Class<T> entityClass;


	public BaseDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
	
    @Override
    public List<T> getAll() {
        Session session = entityManager.unwrap(Session.class);
        return ((EntityManager) session).createQuery("from " + entityClass.getName(), entityClass).getResultList();
    }

    @Override
    public Optional<T> get(ID id) {
        Session session = entityManager.unwrap(Session.class);
        return Optional.ofNullable(session.get(entityClass, id));
    }
    
    @Override
    public void save(T entity) {
        Session session = entityManager.unwrap(Session.class);
        ((EntityManager) session).merge(entity);
    }

    @Override
    public void delete(ID id) {
        Session session = entityManager.unwrap(Session.class);
        T entity = session.get(entityClass, id);
        if (entity != null) {
            session.remove(entity);
        }
    }

    @Override
    public Optional<T> getByDescription(String description) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM " + entityClass.getName() + " t WHERE LOWER(t.descriptionField) = LOWER(:description)";
        return Optional.ofNullable(session.createQuery(hql, entityClass)
                                          .setParameter("description", description)
                                          .uniqueResult());
    }
	

}
