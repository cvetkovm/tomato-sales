package org.cvetkov.martin.service;

import java.util.List;

import org.cvetkov.martin.model.TomatoSale;

public interface TomatoSalesService {

	List<TomatoSale> getLatestTomatoSales(Integer numberOfSales);
}
