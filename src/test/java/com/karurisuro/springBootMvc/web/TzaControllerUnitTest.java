package com.karurisuro.springBootMvc.web;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.karurisuro.springBootMvc.controller.TzaRestController;
import com.karurisuro.springBootMvc.repository.ApplicationRepository;
import com.karurisuro.springBootMvc.service.ApplicationService;


@WebMvcTest(TzaRestController.class)
public class TzaControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ApplicationService applicationService;
	
	@MockBean
	private ApplicationRepository applicationRepository;

	@Test
	void testGetAllApplications() throws Exception {
		mvc.perform(get("/tza/applications").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(content().json("[]"));
		
		verify(applicationService, times(1)).listApplication();
	}

}
