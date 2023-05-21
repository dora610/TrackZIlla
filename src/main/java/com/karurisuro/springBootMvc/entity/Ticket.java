/**
 * 
 */
package com.karurisuro.springBootMvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

/**
 * @author surajitkaruri
 *
 */

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;

	@ManyToOne
	@JoinColumn(name = "application_id")
	private Application application;

	@ManyToOne
	@JoinTable(
			name = "ticket_release", 
			joinColumns = @JoinColumn(name = "ticket_fk"), 
			inverseJoinColumns = @JoinColumn(name = "release_fk"))
	private Release release;

	private String status;

	public Ticket(Long id, String title, String description, Application application, Release release, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.application = application;
		this.release = release;
		this.status = status;
	}

	public Ticket() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", description=" + description + ", application=" + application
				+ ", release=" + release + ", status=" + status + "]";
	}

}
