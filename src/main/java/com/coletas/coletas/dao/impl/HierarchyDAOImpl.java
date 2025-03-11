package com.coletas.coletas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.HierarchyDAO;
import com.coletas.coletas.dto.HierarchyDTO;
import com.coletas.coletas.model.Hierarchy;

@Repository
public class HierarchyDAOImpl extends BaseDAOImpl<Hierarchy, Integer> implements HierarchyDAO {

	public HierarchyDAOImpl() {
		super(Hierarchy.class);
	}

	@Override
	public Hierarchy getByMotoboy(Integer idMotooby) {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "FROM Hierarchy h WHERE h.motoboy.id = :idMotooby";

		Query<Hierarchy> query = currentSession.createQuery(hql.toString(), Hierarchy.class);
		query.setParameter("idMotooby", idMotooby);
		Hierarchy u = query.uniqueResult();

		return u != null ? u : null;
	}

	@Override
	public List<HierarchyDTO> avaliableHierarchy() {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();

		hql.append("select new com.coletas.coletas.dto.HierarchyDTO(");
		hql.append(" co.idUser id");
		hql.append(", co.name name");
	    hql.append(" ) ");
		
		hql.append("from Hierarchy hi ");
		hql.append("inner join hi.coordinator co ");
		hql.append("inner join co.userType ut ");
		
		hql.append("where ut.idUserType = 2");
		
		hql.append("group by co.idUser");
		hql.append(", co.name");
		
		Query<HierarchyDTO> query = currentSession.createQuery(hql.toString(), HierarchyDTO.class);
		
		return query != null ? query.getResultList() : new ArrayList<>(); 
		

	}

}
