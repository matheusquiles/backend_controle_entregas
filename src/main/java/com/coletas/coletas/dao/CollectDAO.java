package com.coletas.coletas.dao;

import java.time.LocalDate;
import java.util.List;

import com.coletas.coletas.dto.CollectDTO;
import com.coletas.coletas.dto.CollectReportDTO;
import com.coletas.coletas.dto.ReportRequestDTO;
import com.coletas.coletas.model.Collect;

public interface CollectDAO extends BaseDAO<Collect, Integer>{
	
	List<Collect> getByUserKeyAndDate(String userKey, LocalDate date);
	List<Collect> getByUserKeyAndDate(String userKey);
	Integer countCollectByUserAndDate(Integer userId, LocalDate date);
	Collect getByCollectKey(String collectKey);
	List<CollectDTO> getDTOByUserAndDate(Integer idUser, LocalDate initialDate, LocalDate finalDate, Integer idSupervidor, Integer idEdress, String deliveryStatus);
	CollectReportDTO collectsByDay(ReportRequestDTO report);
	
}
