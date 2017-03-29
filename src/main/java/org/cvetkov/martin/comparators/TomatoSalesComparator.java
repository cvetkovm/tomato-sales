package org.cvetkov.martin.comparators;

import java.util.Comparator;

import org.cvetkov.martin.model.TomatoSale;

public class TomatoSalesComparator implements Comparator<TomatoSale>{

	@Override
	public int compare(TomatoSale sale1, TomatoSale sale2) {
		if(sale1.getSaleDate() < sale2.getSaleDate()) {
			return -1;
		} else if(sale1.getSaleDate() == sale2.getSaleDate()){
			return sale1.getProvider().compareTo(sale2.getProvider());
		} else {
			return 1;
		}
	}
	
}
