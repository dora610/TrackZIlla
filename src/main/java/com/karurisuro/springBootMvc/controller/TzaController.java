 /**
 * 
 */
package com.karurisuro.springBootMvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.karurisuro.springBootMvc.entity.Application;
import com.karurisuro.springBootMvc.service.ApplicationService;
import com.karurisuro.springBootMvc.service.ReleaseService;
import com.karurisuro.springBootMvc.service.TicketService;

/**
 * @author surajitkaruri
 *
 */

@Controller
public class TzaController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TzaController.class);
	
	private ApplicationService applicationService;
	private ReleaseService releaseService;
	private TicketService ticketService;
	
	@Autowired
	public void setApplicationService(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	@Autowired
	public void setReleaseService(ReleaseService releaseService) {
		this.releaseService = releaseService;
	}

	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/applications")
	public String retieveApplication(Model model) {
		LOGGER.info("inside applications");
		List<Application> li = applicationService.listApplication();
		li.stream().map(Application::toString).forEach(LOGGER::info);
		model.addAttribute("applications", li);
		
		return "applications";
	}
	
	@GetMapping("/tickets")
	public String retrieveTickets(Model model) {
		model.addAttribute("applications", releaseService.listReleases());
		return "applications";
	}
	
	@GetMapping("/releases")
	public String retrieveReleases(Model model) {
		model.addAttribute("applications", ticketService.listTickets());
		return "applications";
	}
	

}
