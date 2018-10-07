package com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "novel")
public class Novel {

	@Id
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="author")
	private String author;
	
	@Column(name="description")
	private String description;
	
	public Novel() {

	}

	public Novel(Long id, String name, String author, String description) {
		super();
		this.name = name;
		this.author = author;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

}