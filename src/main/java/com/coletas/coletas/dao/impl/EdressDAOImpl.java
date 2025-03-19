package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.dto.CollectPreValueDTO;
import com.coletas.coletas.model.Edress;

@Repository
public class EdressDAOImpl extends BaseDAOImpl<Edress, Integer> implements EdressDAO {

	public EdressDAOImpl() {
		super(Edress.class);
	}

	@Override
	public Optional<Edress> getByDescription(String description) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Double getPreValue(Integer idEdress, Integer idCollectType) {
	    Session currentSession = entityManager.unwrap(Session.class);
	    StringBuilder hql = searchDTO();
	    hql.append(" and edr.idEdress = :idEdress ");
	    hql.append(" and clt.idCollectType = :idCollectType ");

	    try {
	        CollectPreValueDTO dto = currentSession.createQuery(hql.toString(), CollectPreValueDTO.class)
	                .setParameter("idEdress", idEdress)
	                .setParameter("idCollectType", idCollectType)
	                .uniqueResult();

	        return dto != null ? dto.getPreValue() : 0.0;
	    } catch (Exception e) {
	        System.err.println("Erro ao executar query: " + e.getMessage());
	        e.printStackTrace();
	        return 0.0;
	    }
	}

	private StringBuilder searchDTO() {
		StringBuilder hql = new StringBuilder();

		hql.append("select new com.coletas.coletas.dto.CollectPreValueDTO(");
		hql.append(" cpv.idCollectPreValue ");
		hql.append(", edr.idEdress ");
		hql.append(", edr.edress ");
		hql.append(", clt.idCollectType ");
		hql.append(", clt.description ");
		hql.append(", cpv.preValue ");
		hql.append(" ) ");

		hql.append("from CollectPreValue cpv ");
		hql.append("inner join cpv.edress edr ");
		hql.append("inner join cpv.collectType clt ");

		hql.append("where 1 = 1");

		return hql;
	}

}
