package com.coletas.coletas.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.dao.DeliveryItemDAO;
import com.coletas.coletas.dto.DeliveryDTO;
import com.coletas.coletas.dto.DeliveryReportDTO;
import com.coletas.coletas.dto.DeliveryTypeReportDTO;
import com.coletas.coletas.dto.RegionDeliveryReportDTO;
import com.coletas.coletas.dto.RegionTypeProjection;
import com.coletas.coletas.dto.ReportRequestDTO;
import com.coletas.coletas.model.Delivery;

@Repository
public class DeliveryDAOImpl extends BaseDAOImpl<Delivery, Integer> implements DeliveryDAO {

	@Autowired
	private DeliveryItemDAO deliveryItemDAO;

	public DeliveryDAOImpl() {
		super(Delivery.class);
	}

	@Override
	public Integer countDeliveriesByUserAndDate(Integer idUser, LocalDate date) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("select count(de.idDelivery) ");
		hql.append("from Delivery de ");
//		hql.append("inner join de.motoboy mo ");
		hql.append("where de.date = :date ");
//		hql.append("and mo.idUser = :idUser ");

		Query<Long> query = currentSession.createQuery(hql.toString(), Long.class);
		query.setParameter("date", date);
//		query.setParameter("idUser", idUser);

		Optional<Long> result = query.uniqueResultOptional();
		return result.map(Long::intValue).orElse(0);
	}

	@Override
	public List<DeliveryDTO> getDTOByUserAndDate(Integer idMotoboy, String deliveryStatus, LocalDate finalDate,
			Integer idCoordinator, Integer idDeliveryRegion, LocalDate initialDate) {

		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = searchDTO(idMotoboy, idCoordinator, idDeliveryRegion);

		if (deliveryStatus != null && !"todos".equals(deliveryStatus)) {
			hql.append(
					" AND EXISTS (SELECT di FROM DeliveryItems di WHERE di.delivery.id = de.idDelivery AND di.deliveryStatus = :deliveryStatus)");
		}

		Query<DeliveryDTO> query = currentSession.createQuery(hql.toString(), DeliveryDTO.class);
		query.setParameter("initialDate", initialDate);
		query.setParameter("finalDate", finalDate);

		if (idMotoboy != null) {
			query.setParameter("idMotoboy", idMotoboy);
		}
		if (deliveryStatus != null) {
			query.setParameter("deliveryStatus", deliveryStatus);

		}
		if (idCoordinator != null) {
			query.setParameter("idCoordinator", idCoordinator);
		}
		if (idDeliveryRegion != null) {
			query.setParameter("idDeliveryRegion", idDeliveryRegion);
		}
		if (deliveryStatus != null && !"todos".equals(deliveryStatus)) {
			query.setParameter("deliveryStatus", deliveryStatus);
		}

		List<DeliveryDTO> resultList = query.getResultList();

		for (DeliveryDTO deliveryDTO : resultList) {
			deliveryDTO.setDeliveryItemDTO(
					deliveryItemDAO.searchDTOByDelivery(deliveryDTO.getIdDelivery(), deliveryStatus));
		}

		return resultList.isEmpty() ? new ArrayList<>() : resultList;
	}

	private StringBuilder searchDTO(Integer idMotoboy, Integer idCoordinator, Integer idDeliveryRegion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.coletas.coletas.dto.DeliveryDTO(");
		hql.append("de.idDelivery idDelivery ");
		hql.append(", de.deliveryKey deliveryKey");
		hql.append(", de.value value");
		hql.append(", us.idUser idMotoboy");
		hql.append(", us.name nameMotoboy");
		hql.append(", co.idUser idCoordinator");
		hql.append(", co.name nameCoordinator");
		hql.append(", dr.idDeliveryRegion idDeliveryRegion");
		hql.append(", dr.deliveryRegion deliveryRegion");
		hql.append(", de.date date ");
		hql.append(", de.status status ");
		hql.append(", de.deliveryStatus deliveryStatus ");
		hql.append(" ) ");

		hql.append(" From Delivery de");
		hql.append(" inner join de.motoboy us ");
		hql.append(" inner join de.deliveryRegion dr ");
		hql.append(" left join Hierarchy hi on hi.motoboy.idUser = us.idUser ");
		hql.append(" left join hi.coordinator co ");

		hql.append(" where 1=1 ");

		hql.append(" and de.date >= :initialDate ");
		hql.append(" and de.date <= :finalDate ");

		if (idMotoboy != null) {
			hql.append(" and us.idUser = :idMotoboy ");
		}
		if (idCoordinator != null) {
			hql.append(" and hi.coordinator.idUser = :idCoordinator ");
		}
		if (idDeliveryRegion != null) {
			hql.append(" and dr.idDeliveryRegion = :idDeliveryRegion ");
		}

		return hql;

	}

	@Override
	public DeliveryReportDTO deliveriesByDay(ReportRequestDTO report) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.coletas.coletas.dto.DeliveryReportDTO(");
		hql.append(" de.date ");
		hql.append(", count(distinct de.idDelivery) ");
		hql.append(", sum(di.totalToPay) ");
		hql.append(") ");
		hql.append(" from DeliveryItems di ");
		hql.append(" inner join di.delivery de ");
		hql.append(" where de.date = :date ");
		hql.append(" group by de.date ");


		try {
			Query<DeliveryReportDTO> query = currentSession.createQuery(hql.toString(), DeliveryReportDTO.class);
			query.setParameter("date", report.getDate());
			DeliveryReportDTO result = query.getSingleResult();
			List<RegionTypeProjection> projectionList = findDeliveryRegionTypeDetails(report.getDate());

			// Agrupa por região
			Map<String, List<RegionTypeProjection>> groupedByRegion = projectionList.stream()
					.collect(Collectors.groupingBy(RegionTypeProjection::getRegion));

			List<RegionDeliveryReportDTO> regions = new ArrayList<>();

			for (Map.Entry<String, List<RegionTypeProjection>> entry : groupedByRegion.entrySet()) {
				String region = entry.getKey();
				List<RegionTypeProjection> types = entry.getValue();

				List<DeliveryTypeReportDTO> deliveries = types.stream()
						.map(p -> new DeliveryTypeReportDTO(p.getType(), p.getQuantity(), p.getValue()))
						.collect(Collectors.toList());

				RegionDeliveryReportDTO regionDTO = new RegionDeliveryReportDTO();
				regionDTO.setRegion(region);
				regionDTO.setDeliveries(deliveries);

				regions.add(regionDTO);
			}

			result.setByRegion(regions);

			return result;

		} catch (Exception e) {
			System.err.println("Erro ao criar/executar a query HQL: " + hql.toString());
			e.printStackTrace();
			throw new RuntimeException("Falha na execução da query: " + e.getMessage(), e);
		}
	}

	public List<RegionTypeProjection> findDeliveryRegionTypeDetails(LocalDate date) {
	    Session currentSession = entityManager.unwrap(Session.class);

	    String hql = """
	        select new com.coletas.coletas.dto.RegionTypeProjection(
	            dr.deliveryRegion,
	            dt.description,
	            count(distinct d.idDelivery),
	            sum(di.totalToPay)
	        )
	        from DeliveryItems di
	        join di.delivery d
	        join d.deliveryRegion dr
	        join di.deliveryType dt
	        where d.date = :date
	        group by dr.deliveryRegion, dt.description
	    """;

	    Query<RegionTypeProjection> query = currentSession.createQuery(hql, RegionTypeProjection.class);
	    query.setParameter("date", date);
	    return query.getResultList();
	}
}
