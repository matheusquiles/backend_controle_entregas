package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.model.Users;

@Repository
public class UserDAOImpl extends BaseDAOImpl<Users, Integer> implements UserDAO {

	public UserDAOImpl() {
		super(Users.class);
	}
	

	@Override
	public Optional<Users> getByDescription(String userKey) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM Users u WHERE LOWER(u.userKey) = LOWER(:userKey)";
        Users e = currentSession.createQuery(hql, Users.class)
                .setParameter("userKey", userKey)
                .uniqueResult();
        return Optional.ofNullable(e);
	}


	@Override
	public Boolean getByUserKey(String userKey) {
		Session currentSession = entityManager.unwrap(Session.class);
	    String hql = "FROM Users u WHERE LOWER(u.userKey) = LOWER(:userKey)";
	    Users e = currentSession.createQuery(hql, Users.class)
	            .setParameter("userKey", userKey)
	            .uniqueResult();
	    return e != null ? true : false;
	}


	@Override
	public Users getUserByKey(String userkey) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("from Users u ");
		hql.append("where LOWER(u.userKey) = LOWER(:userKey)");

		Query<Users> query = currentSession.createQuery(hql.toString(), Users.class);
		query.setParameter("userKey", userkey);
		Users u = query.uniqueResult();
		
		return u != null ? u : null;
	}

}
