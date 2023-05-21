/**
 * 
 */
package com.karurisuro.springBootMvc.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.karurisuro.springBootMvc.entity.Release;

/**
 * @author surajitkaruri
 *
 */
public interface ReleaseRepository extends ListCrudRepository<Release, Long> {

}
