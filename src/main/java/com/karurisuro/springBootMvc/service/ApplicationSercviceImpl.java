/**
 * 
 */
package com.karurisuro.springBootMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karurisuro.springBootMvc.entity.Application;
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

}
