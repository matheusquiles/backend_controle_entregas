package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
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
	public Optional<Users> getByDescription(String nome) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM users e WHERE LOWER(e.nome) = LOWER(:nome)";
        Users e = currentSession.createQuery(hql, Users.class)
                .setParameter("nome", nome)
                .uniqueResult();
        return Optional.ofNullable(e);
	}

}
