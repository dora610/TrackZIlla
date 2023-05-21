package com.karurisuro.springBootMvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.karurisuro.springBootMvc.entity.Application;
import com.karurisuro.springBootMvc.entity.Release;
import com.karurisuro.springBootMvc.entity.Ticket;
import com.karurisuro.springBootMvc.repository.ApplicationRepository;

@SpringBootApplication
public class SpringBootMvcApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringBootMvcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ApplicationRepository repo) {
		return (args)->{
//			Application app1 = new Application("Trackzilla","kesha.williams","Application for tracking bugs.");
//			Application app2 = new Application("Expenses","mary.jones","Application to track expense reports.");
//			Application app3 = new Application("Notifications","karen.kane","Application to send alerts and notifications to users.");
//			
//			repo.save(app1);
//			repo.save(app2);
//			repo.save(app3);
			
			repo.save(new Application("Backlogs","karen.kane","Application to track backlogs"));
			
			repo.findAll().stream().map(Application::toString).forEach(log::info);
			
			
			log.info("Get application by name");
			repo.findByName("Trackzilla")
				.ifPresentOrElse(
					a -> log.info(a.toString()), 
					()-> log.error("Application not found"));
			
			log.info("Find by owner");
			repo.findByOwner("karen.kane")
				.stream()
				.map(Application::toString)
				.forEach(log::info);
		};
	}

}
