package com.metatonic.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.metatonic.dsmeta.entities.Sale;
import com.metatonic.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate defaultDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? defaultDate.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? defaultDate : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
	}
}
