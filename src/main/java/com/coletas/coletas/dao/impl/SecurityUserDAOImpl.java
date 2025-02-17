package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
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
	public Optional<SecurityUser> getByUserId(Integer idUser) {
		Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM SecurityUser s WHERE u.idUser = :idUser";
        SecurityUser s = currentSession.createQuery(hql, SecurityUser.class)
                .setParameter("idUser", idUser)
                .uniqueResult();
        return Optional.ofNullable(s);
	}
	
}
