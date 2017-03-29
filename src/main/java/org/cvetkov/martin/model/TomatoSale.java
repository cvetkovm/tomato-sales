package org.cvetkov.martin.model;

import java.util.UUID;

public class TomatoSale {
	
	private UUID id;
	private int tomatoes;
	private String provider;
	private long saleDate;
	
	public TomatoSale(UUID id, int tomatoes, String provider, long saleDate) {
		super();
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.saleDate = saleDate;
	}

	public int getTomatoes() {
		return tomatoes;
	}

	public void setTomatoes(int tomatoes) {
		this.tomatoes = tomatoes;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public long getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(long saleDate) {
		this.saleDate = saleDate;
	}

	public UUID getId() {
		return id;
	}
	
	
}
