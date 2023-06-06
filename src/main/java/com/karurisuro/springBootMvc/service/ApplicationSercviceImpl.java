/**
 * 
 */
package com.karurisuro.springBootMvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karurisuro.springBootMvc.entity.Application;
import com.karurisuro.springBootMvc.exception.ApplicationNotFoundException;
import com.karurisuro.springBootMvc.repository.ApplicationRepository;

/**
 * @author surajitkaruri
 *
 */
@Service
public class ApplicationSercviceImpl implements ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<Application> listApplication() {
		return applicationRepository.findAll();
	}
	
	@Override
	public Application fetchApplication(Long id) throws ApplicationNotFoundException{
		Optional<Application> applicationOptional = applicationRepository.findById(id);
		if(applicationOptional.isPresent()) {
			return applicationOptional.get();
		}else {
			throw new ApplicationNotFoundException("No such applicationn found");
		}
		
		
	}

}
