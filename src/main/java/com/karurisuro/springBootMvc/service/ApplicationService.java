/**
 * 
 */
package com.karurisuro.springBootMvc.service;

import java.util.List;
import java.util.Optional;

import com.karurisuro.springBootMvc.entity.Application;
import com.karurisuro.springBootMvc.exception.ApplicationNotFoundException;

/**
 * @author surajitkaruri
 *
 */
public interface ApplicationService {
	public List<Application> listApplication();

	Application fetchApplication(Long id) throws ApplicationNotFoundException;

}
