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
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int author_id;

	@Column(name="name")
	private String name;

	public Author() {

	}

	public Author(int music_id, String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return author_id;
	}

	public String getName() {
		return name;
	}
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Music_Author", 
        joinColumns = { @JoinColumn(name = "author_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "music_id") }
    )
    
    Set<Music> musics = new HashSet<>();
    
    public void setMusics(Set<Music> musics){
    	this.musics = musics;	
    }

}