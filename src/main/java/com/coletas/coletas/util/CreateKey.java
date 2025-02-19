package com.coletas.coletas.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.model.Collect;

@Service
public class CreateKey {
	
	@Autowired
	private CollectDAO dao;
	
	public String createKey(Collect entity) {
		try {
			LocalDate date = entity.getDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
			String formattedDate = date.format(formatter);

			Integer userId = entity.getUserId().getIdUser();

			Integer qtdCollects = dao.countCollectByUserAndDate(userId, date);

			return formattedDate + userId + qtdCollects;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
