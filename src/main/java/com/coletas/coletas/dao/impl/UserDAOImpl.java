package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.dto.UserDTO;
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
		Users e = currentSession.createQuery(hql, Users.class).setParameter("userKey", userKey).uniqueResult();
		return Optional.ofNullable(e);
	}

	@Override
	public Boolean getByUserKey(String userKey) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "FROM Users u WHERE LOWER(u.userKey) = LOWER(:userKey)";
		Users e = currentSession.createQuery(hql, Users.class).setParameter("userKey", userKey).uniqueResult();
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

	@Override
	public UserDTO getUserDTOByKey(String userKey) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = searchDTO();

		hql.append(" and LOWER(u.userKey) = LOWER(:userKey) ");

		UserDTO dto = currentSession.createQuery(hql.toString(), UserDTO.class).setParameter("userKey", userKey)
				.uniqueResult();

		return dto;
	}

	private StringBuilder searchDTO() {

		StringBuilder hql = new StringBuilder();
		hql.append("select new com.coletas.coletas.dto.UserDTO(");
		hql.append(" u.idUser idUser");
		hql.append(", u.name name");
		hql.append(", u.cpf cpf");
		hql.append(", u.email email");
		hql.append(", u.userKey userKey");
		hql.append(", u.status status");
		hql.append(", ut.description userType");
		hql.append(" ) ");

		hql.append(" From Users u ");
		hql.append(" inner join u.userType ut ");
		hql.append(" where 1=1 ");

		return hql;
	}

}
