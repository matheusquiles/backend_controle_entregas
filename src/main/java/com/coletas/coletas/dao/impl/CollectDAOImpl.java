package com.coletas.coletas.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.dao.CollectItensDAO;
import com.coletas.coletas.dto.CollectDTO;
import com.coletas.coletas.model.Collect;

@Repository
public class CollectDAOImpl extends BaseDAOImpl<Collect, Integer> implements CollectDAO {

	@Autowired
	private CollectItensDAO collectItensDAO;

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

	private StringBuilder searchDTO(Integer idUser, LocalDate initialDate, LocalDate finalDate, Integer idSupervidor,
			Integer idEdress) {

		StringBuilder hql = new StringBuilder();
		hql.append("select new com.coletas.coletas.dto.CollectDTO(");
		hql.append(" co.idCollect idCollect");
		hql.append(" , co.collectKey collectKey");
		hql.append(" , us.name collectUser");
		hql.append(" , ed.edress edress");
		hql.append(" , ed.description edressDescription");
		hql.append(" , co.date date");
		hql.append(" , co.status status");
		hql.append(" , coo.name coordinator");
		hql.append(" ) ");

		hql.append(" From Collect co ");
		hql.append(" inner join co.userId us ");
		hql.append(" inner join co.edress ed ");
		hql.append(" left join Hierarchy h on h.motoboy.idUser = us.idUser ");
		hql.append(" left join h.coordinator coo ");

		hql.append(" where 1=1 ");

		hql.append(" and co.date >= :initialDate ");
		hql.append(" and co.date <= :finalDate ");

		if (idUser != null) {
			hql.append(" and us.idUser = :idUser ");
		}

		if (idEdress != null) {
			hql.append(" and ed.idEdress = :idEdress ");
		}
		if (idSupervidor != null) {
			hql.append(" and h.coordinator.idUser = :idSupervidor ");
		}

		return hql;
	}

	@Override
	public List<CollectDTO> getDTOByUserAndDate(Integer idUser, LocalDate initialDate, LocalDate finalDate,
			Integer idSupervidor, Integer idEdress, String deliveryStatus) {
		Session currentSession = entityManager.unwrap(Session.class);

		StringBuilder hql = searchDTO(idUser, initialDate, finalDate, idSupervidor, idEdress);

		if (deliveryStatus != null && !"todos".equals(deliveryStatus)) {
			hql.append(
					" AND EXISTS (SELECT ci FROM CollectItens ci WHERE ci.collect.id = co.idCollect AND ci.deliveryStatus = :deliveryStatus)");
		}

		Query<CollectDTO> query = currentSession.createQuery(hql.toString(), CollectDTO.class);
		query.setParameter("initialDate", initialDate);
		query.setParameter("finalDate", finalDate);

		if (idUser != null) {
			query.setParameter("idUser", idUser);
		}
		if (idSupervidor != null) {
			query.setParameter("idSupervidor", idSupervidor);
		}
		if (idEdress != null) {
			query.setParameter("idEdress", idEdress);
		}
		if (deliveryStatus != null && !"todos".equals(deliveryStatus)) {
			query.setParameter("deliveryStatus", deliveryStatus);
		}

		List<CollectDTO> resultList = query.getResultList();

		// Popula os itens de cada CollectDTO
		for (CollectDTO collectDTO : resultList) {
			collectDTO.setItens(collectItensDAO.searchDTOByIdCollect(collectDTO.getIdCollect(), deliveryStatus));
		}

		return resultList.isEmpty() ? new ArrayList<>() : resultList;
	}

}
