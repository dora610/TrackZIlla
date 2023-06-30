/**
 * 
 */
package com.karurisuro.springBootMvc.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.karurisuro.springBootMvc.entity.Application;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TzaControllerIntegrationTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private final String host = "http://localhost:";
	

	@Test
	public void getAllApplicationsTest() {
		ResponseEntity<List> response =
				this.restTemplate.getForEntity(this.host+ port + "/tza/applications", List.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void getApplicationTest() {
		ResponseEntity<Application> response =
				this.restTemplate.getForEntity(this.host + port + "/tza/application/1", Application.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}
	
	@Test
	public void getApplicationNotFoundTest() {
		ResponseEntity<Application> response =
				this.restTemplate.getForEntity(this.host + port + "/tza/application/100", Application.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
	}

}
