/**
 * 
 */
package com.karurisuro.springBootMvc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.karurisuro.springBootMvc.entity.Application;

/**
 * @author surajitkaruri
 *
 */
public interface ApplicationRepository extends ListCrudRepository<Application, Long> {

	Optional<Application> findByName(String name);
	List<Application> findByOwner(String owner);

}
