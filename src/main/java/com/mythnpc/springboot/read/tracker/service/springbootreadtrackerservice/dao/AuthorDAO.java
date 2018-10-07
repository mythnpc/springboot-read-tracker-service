package com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model.Author;
import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model.Music;
import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model.Novel;

@Repository
@Transactional
public class AuthorDAO {
    @Autowired
    private SessionFactory sessionFactory;
    Set<Music> musics = new HashSet<>();

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void fun(){
    	Music m = new Music(1, "GACT", "Rock"); 
    	Music m2 = new Music(2, "DSADSADSA", "Rock"); 
    	musics.add(m);
    	musics.add(m2);
    	
    	Author a = new Author(1, "AER");
    	a.setMusics(musics);
    	
    	getSession().persist(a);
    }

    public boolean delete(Novel novel) {
        getSession().delete(novel);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List getAllNovel() {
        return getSession().createQuery("from Novel").list();
    }
}