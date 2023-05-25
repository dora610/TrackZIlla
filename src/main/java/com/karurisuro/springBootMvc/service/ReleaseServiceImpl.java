/**
 * 
 */
package com.karurisuro.springBootMvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karurisuro.springBootMvc.entity.Release;
import com.karurisuro.springBootMvc.repository.ReleaseRepository;

/**
 * @author surajitkaruri
 *
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {
	
	@Autowired
	private ReleaseRepository releaseRepository;

	@Override
	public Iterable<Release> listReleases() {
		return releaseRepository.findAll();
	}

}
