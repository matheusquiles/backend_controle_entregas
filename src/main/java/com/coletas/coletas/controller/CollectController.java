package com.coletas.coletas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.dto.CollectDTO;
import com.coletas.coletas.dto.CollectRequestDTO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.service.CollectItensService;
import com.coletas.coletas.service.CollectService;
import com.coletas.coletas.service.impl.CollectServiceImpl;

@RestController
@RequestMapping("/api/collects")
public class CollectController extends BaseControllerImpl<Collect, Integer> {

	@Autowired
	private CollectService service;
	
	@Autowired
	private CollectItensService serviceCollectItens;

	public CollectController(CollectServiceImpl service) {
		super(service);
	}

	@Override
	public Boolean save(Collect entity) {

		try {
			Collect collect = service.saveCollect(entity);
			if (collect!=null) {
				serviceCollectItens.saveCollectItens(collect);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to save collect: " + entity.getIdCollect(), e);
		}

	}
    @PostMapping("/getDTO")
	public List<CollectDTO> getDTOByUserAndDate(@RequestBody CollectRequestDTO request){
		try {
			List<CollectDTO> list = service.getDTOByUserAndDate(request.getUserKey(), request.getInitialDate(), request.getFinalDate());
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		
	}

	

}