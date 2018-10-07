package com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "music")
public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int music_id;

	@Column(name="name")
	private String name;

	@Column(name="genre")
	private String genre;

	public Music() {

	}

	public Music(int music_id, String name, String genre) {
		super();
		this.name = name;
		this.genre = genre;
	}

	public int getId() {
		return music_id;
	}

	public String getName() {
		return name;
	}

	public String getGenre() {
		return genre;
	}
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Music_Author", 
        joinColumns = { @JoinColumn(name = "music_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    Set<Author> authors = new HashSet<>();

    public void setAuthors(Set<Author> authors){
    	this.authors = authors;	
    }
}