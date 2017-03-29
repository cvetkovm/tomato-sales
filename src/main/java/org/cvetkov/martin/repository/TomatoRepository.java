package org.cvetkov.martin.repository;

import java.util.List;

import org.cvetkov.martin.model.TomatoSale;

public interface TomatoRepository {

	List<TomatoSale> getLatestTomatoSales();
	List<TomatoSale> getLatestTomatoSales(int numberOfSales);

}
