package org.cvetkov.martin.repository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.cvetkov.martin.model.TomatoSale;
import org.cvetkov.martin.utilities.TomatoConstants;
import org.springframework.stereotype.Repository;

@Repository
public class TomatoRepositoryImpl implements TomatoRepository{

	@Override
	public List<TomatoSale> getLatestTomatoSales() {
		return getLatestTomatoSales(TomatoConstants.DEFAULT_NUMBER_OF_TOMATO_SALES);
	}
	
	@Override
	public List<TomatoSale> getLatestTomatoSales(int numberOfSales) {
		List<TomatoSale> listOfTomatoSales = new ArrayList<>();
		for (int i = 0; i < numberOfSales; i++) {
			TomatoSale tomatoSale = createTomatoSale();
			listOfTomatoSales.add(tomatoSale);
		}
		return listOfTomatoSales;
	}

	private TomatoSale createTomatoSale() {
		UUID id = UUID.randomUUID();
		int tomatoes = generateNumberOfTomatoes();
		String provider = chooseRandomProvider(); 
		long timestamp = chooseRandomTimestamp();
		
		TomatoSale tomatosale = new TomatoSale(id, tomatoes, provider, timestamp);
		return tomatosale;
	}

	private String chooseRandomProvider() {
		int index = ThreadLocalRandom.current().nextInt(TomatoConstants.TOMATO_PROVIDERS.length);
		return TomatoConstants.TOMATO_PROVIDERS[index];
	}

	private int generateNumberOfTomatoes() {
		return ThreadLocalRandom.current().nextInt(TomatoConstants.MIN_NUMBER_OF_TOMATOES, TomatoConstants.MAX_NUMBER_OF_TOMATOES + 1);
	}
	
	private long chooseRandomTimestamp() {
		 
		LocalDateTime currentTime = LocalDateTime.now();
		//creates date for January the 1st
		LocalDateTime startOfYear = LocalDateTime.of(currentTime.getYear(), 1, 1, 0, 0);
		
		ZonedDateTime currentTimeZoned = currentTime.atZone(ZoneOffset.UTC);
		ZonedDateTime startOfYearZoned = startOfYear.atZone(ZoneOffset.UTC);
		
		long min = startOfYearZoned.toInstant().toEpochMilli();
		long max = currentTimeZoned.toInstant().toEpochMilli();
		
		return ThreadLocalRandom.current().nextLong(min, max + 1);
		
	}



}
