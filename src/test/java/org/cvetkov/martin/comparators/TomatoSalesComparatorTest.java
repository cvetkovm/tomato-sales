package org.cvetkov.martin.comparators;

import static org.junit.Assert.*;

import java.util.UUID;

import org.cvetkov.martin.model.TomatoSale;
import org.cvetkov.martin.utilities.TomatoConstants;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TomatoSalesComparatorTest{

	@Test
	public void testWhenSale1BeforeSale2() {
		TomatoSale sale1 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 1000);
		TomatoSale sale2 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 2000);
		TomatoSalesComparator comparator = new TomatoSalesComparator();
		assertEquals(-1, comparator.compare(sale1, sale2));
	}
	
	@Test
	public void testWhenSale1AfterSale2() {
		TomatoSale sale1 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 2000);
		TomatoSale sale2 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 1000);
		TomatoSalesComparator comparator = new TomatoSalesComparator();
		assertEquals(1, comparator.compare(sale1, sale2));
	}
	
	@Test
	public void testWhenSale1AndSale2Equal() {
		TomatoSale sale1 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 1000);
		TomatoSale sale2 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 1000);
		TomatoSalesComparator comparator = new TomatoSalesComparator();
		assertEquals(0, comparator.compare(sale1, sale2));
	}
	
	@Test
	public void testWhenSale1AndSale2AtSameTimeButSale1Smaller() {
		TomatoSale sale1 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[2], 1000);
		TomatoSale sale2 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 1000);
		TomatoSalesComparator comparator = new TomatoSalesComparator();
		assertTrue(comparator.compare(sale1, sale2) < 0);
	}
	
	@Test
	public void testWhenSale1AndSale2AtSameTimeButSale1Bigger() {
		TomatoSale sale1 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[0], 1000);
		TomatoSale sale2 = new TomatoSale(UUID.randomUUID(), 1000, TomatoConstants.TOMATO_PROVIDERS[2], 1000);
		TomatoSalesComparator comparator = new TomatoSalesComparator();
		assertTrue(comparator.compare(sale1, sale2) > 0);
	}
	
}
