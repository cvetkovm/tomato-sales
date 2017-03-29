package org.cvetkov.martin.service;

import java.util.Collections;
import java.util.List;

import org.cvetkov.martin.comparators.TomatoSalesComparator;
import org.cvetkov.martin.model.TomatoSale;
import org.cvetkov.martin.repository.TomatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TomatoSalesServiceImpl implements TomatoSalesService{
	
	@Autowired
	TomatoRepository repository;

	@Override
	public List<TomatoSale> getLatestTomatoSales(Integer numberOfSales) {
		List<TomatoSale> sales;
		if(numberOfSales == null) {
			sales = repository.getLatestTomatoSales();
		} else {
			sales = repository.getLatestTomatoSales(numberOfSales);
		}
		Collections.sort(sales, new TomatoSalesComparator());
		return sales;
	}
	
}
