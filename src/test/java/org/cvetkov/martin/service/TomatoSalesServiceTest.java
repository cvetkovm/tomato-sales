package org.cvetkov.martin.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.cvetkov.martin.model.TomatoSale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.hamcrest.collection.IsEmptyCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TomatoSalesServiceTest {

	@Autowired
	private TomatoSalesService tomatoService;

	@Test
	public void testIfReturnsThreeObjectsWhenArgumentIsNull() {
		List<TomatoSale> sales = tomatoService.getLatestTomatoSales(null);
		assertThat(sales.size(), is(3));	
	}
	
	@Test
	public void testIfReturnsEmptyListWhenArgumentIsZero() {
		List<TomatoSale> sales = tomatoService.getLatestTomatoSales(0);
		assertThat(sales, IsEmptyCollection.empty());	
	}
	
	@Test
	public void testIfReturnsEmptyListWhenArgumentIsNegative() {
		List<TomatoSale> sales = tomatoService.getLatestTomatoSales(-1);
		assertThat(sales, IsEmptyCollection.empty());	
	}
	
	@Test
	public void testIfReturnsTenObjectsWhenArgumentIsTen() {
		List<TomatoSale> sales = tomatoService.getLatestTomatoSales(10);
		assertThat(sales.size(), is(10));	
	}
}
