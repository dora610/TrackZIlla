/**
 * 
 */
package com.karurisuro.springBootMvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author surajitkaruri
 *
 */

@Entity
public class Release {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String releaseDate;
	private String description;

	public Release(Long id, String releaseDate, String description) {
		this.id = id;
		this.releaseDate = releaseDate;
		this.description = description;
	}

	public Release() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Release [id=" + id + ", releaseDate=" + releaseDate + ", description=" + description + "]";
	}

}
