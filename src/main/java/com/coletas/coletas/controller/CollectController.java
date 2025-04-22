package com.coletas.coletas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.dto.CollectDTO;
import com.coletas.coletas.dto.CollectReportDTO;
import com.coletas.coletas.dto.ReportRequestDTO;
import com.coletas.coletas.dto.request.CollectEditRequestDTO;
import com.coletas.coletas.dto.request.CollecttRequestDTO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.service.CollectService;
import com.coletas.coletas.service.impl.CollectServiceImpl;

@RestController
@RequestMapping("/api/collects")
public class CollectController extends BaseControllerImpl<Collect, Integer> {

	@Autowired
	private CollectService service;

	public CollectController(CollectServiceImpl service) {
		super(service);
	}

	@Override
	public Boolean save(Collect entity) {

		try {
			service.saveCollect(entity);
			return true;

		} catch (Exception e) {
			throw new RuntimeException("Failed to save collect: " + entity.getIdCollect(), e);
		}

	}

	@PostMapping("/getDTO")
	public List<CollectDTO> getDTOByUserAndDate(@RequestBody CollecttRequestDTO request) {
		try {
			List<CollectDTO> list = service.getDTOByUserAndDate(request.getIdUser(), request.getInitialDate(),
					request.getFinalDate(), request.getIdSupervisor(), request.getIdEdress(),
					request.getDeliveryStatus());
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@PostMapping("/editCollect")
	public Boolean editCollect(@RequestBody List<CollectEditRequestDTO> collect) {
		try {
			service.editCollect(collect);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao editar usuário!");
		}

	}

	@PostMapping("/batch")
	public ResponseEntity<Collect> createCollectBatch(@RequestBody List<Collect> collects) {

		try {
			for (Collect collect : collects) {
				service.saveCollect(collect);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().build();
	}

	@PostMapping("/report/collects")
	public ResponseEntity<CollectReportDTO> collectsByDay(@RequestBody ReportRequestDTO report) {

		try {	
			CollectReportDTO result = service.collectsByDay(report);
			return ResponseEntity.ok(result);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}