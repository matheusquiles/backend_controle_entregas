package com.coletas.coletas.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.model.Collect;

@Repository
public class CollectDAOImpl extends BaseDAOImpl<Collect, Integer> implements CollectDAO {

	public CollectDAOImpl() {
		super(Collect.class);
	}

	@Override
	public List<Collect> getByUserKeyAndDate(String userKey, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collect> getByUserKeyAndDate(String userKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countCollectByUserAndDate(Integer idUser, LocalDate date) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("select count(co.idCollect) ");
		hql.append("from Collect co ");
		hql.append("inner join co.userId user ");
		hql.append("where co.date = :date ");
		hql.append("and user.idUser = :idUser ");
		
		Query<Long> query = currentSession.createQuery(hql.toString(), Long.class);
		query.setParameter("date", date);
		query.setParameter("idUser", idUser);

        Optional<Long> result = query.uniqueResultOptional();
        return result.map(Long::intValue).orElse(0);
	}

	@Override
	public Collect getByCollectKey(String collectKey) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("from Collect c ");
		hql.append("where c.collectKey = :collectKey");

		Query<Collect> query = currentSession.createQuery(hql.toString(), Collect.class);
		query.setParameter("collectKey", collectKey);
		Collect c = query.uniqueResult();
		
		return c != null ? c : null;
	}



}
