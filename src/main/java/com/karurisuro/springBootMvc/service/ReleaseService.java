/**
 * 
 */
package com.karurisuro.springBootMvc.service;

import com.karurisuro.springBootMvc.entity.Release;

/**
 * @author surajitkaruri
 *
 */
public interface ReleaseService {
	
	public Iterable<Release> listReleases();
}
