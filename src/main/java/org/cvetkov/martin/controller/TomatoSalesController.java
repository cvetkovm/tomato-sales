package org.cvetkov.martin.controller;

import java.util.List;

import org.cvetkov.martin.model.TomatoSale;
import org.cvetkov.martin.service.TomatoSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomatoSalesController {

	TomatoSalesService service;

	@Autowired
	public TomatoSalesController(TomatoSalesService service) {
		this.service = service;
	}

	@RequestMapping(value="/data", method={RequestMethod.GET,RequestMethod.POST}, produces="application/json")
	public List<TomatoSale> getTomatoSales( @RequestParam(value="size", required=false) Integer numberOfTomatoSales) {

		List<TomatoSale> tomatoSales = service.getLatestTomatoSales(numberOfTomatoSales);
		return tomatoSales;
	}

}