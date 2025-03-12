package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.SecurityUserDAO;
import com.coletas.coletas.model.SecurityUser;

@Repository
public class SecurityUserDAOImpl extends BaseDAOImpl<SecurityUser, Integer> implements SecurityUserDAO {

	public SecurityUserDAOImpl() {
		super(SecurityUser.class);
	}

	@Override
	public SecurityUser getByUserId(Integer idUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("select su ");
		hql.append("from SecurityUser su ");
		hql.append("where su.users.id = :idUser");
		
		SecurityUser s = currentSession.createQuery(hql.toString(), SecurityUser.class).setParameter("idUser", idUser)
				.uniqueResult();
		return s != null ? s : null;
	}

	@Override
	public SecurityUser getByUserKey(String userKey) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("select su ");
		hql.append("from SecurityUser su ");
		hql.append("inner join su.users user ");
		hql.append("where lower(user.userKey) = lower(:userKey) ");
		hql.append("and user.status = true ");

		Query<SecurityUser> query = currentSession.createQuery(hql.toString(), SecurityUser.class);
		query.setParameter("userKey", userKey);

		Optional<SecurityUser> result = query.uniqueResultOptional();

		return result.orElse(null);
	}

}
