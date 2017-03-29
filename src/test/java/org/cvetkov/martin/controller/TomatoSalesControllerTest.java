package org.cvetkov.martin.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.UUID;

import org.cvetkov.martin.controller.TomatoSalesController;
import org.cvetkov.martin.model.TomatoSale;
import org.cvetkov.martin.service.TomatoSalesService;
import org.cvetkov.martin.utils.TestUtils;
import org.cvetkov.martin.utilities.TomatoConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TomatoSalesController.class)
public class TomatoSalesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TomatoSalesService tomatoServiceMock;

	@Test
	public void getTomatoSalesWithGetRequestWithSize1ShouldReturnOneEntryAndOkStatus() throws Exception {
		UUID id = UUID.randomUUID();
		TomatoSale tomatoSale = new TomatoSale(id, 1000, TomatoConstants.TOMATO_PROVIDERS[0], 2000);

		given(tomatoServiceMock.getLatestTomatoSales(1)).willReturn(Arrays.asList(tomatoSale));

		mockMvc.perform(get("/data?size=1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(TestUtils.JSON_CONTENT_TYPE))
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].tomatoes", is(1000)))
		.andExpect(jsonPath("$[0].provider", is(TomatoConstants.TOMATO_PROVIDERS[0])))
		.andExpect(jsonPath("$[0].saleDate", is(2000)));
	}
	
	@Test
	public void getTomatoSalesWithPostRequestWithSize1ShouldReturnOneEntryAndOkStatus() throws Exception {
		UUID id = UUID.randomUUID();
		TomatoSale tomatoSale = new TomatoSale(id, 1000, TomatoConstants.TOMATO_PROVIDERS[0], 2000);

		given(tomatoServiceMock.getLatestTomatoSales(1)).willReturn(Arrays.asList(tomatoSale));

		mockMvc.perform(post("/data?size=1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(TestUtils.JSON_CONTENT_TYPE))
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0].tomatoes", is(1000)))
		.andExpect(jsonPath("$[0].provider", is(TomatoConstants.TOMATO_PROVIDERS[0])))
		.andExpect(jsonPath("$[0].saleDate", is(2000)));
	}
}