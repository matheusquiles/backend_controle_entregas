package com.coletas.coletas.dao;

import java.util.List;

import com.coletas.coletas.dto.HierarchyDTO;
import com.coletas.coletas.model.Hierarchy;

public interface HierarchyDAO extends BaseDAO<Hierarchy, Integer> {
	
	Hierarchy getByMotoboy(Integer idMotooby);
	List<HierarchyDTO> avaliableHierarchy();

}
