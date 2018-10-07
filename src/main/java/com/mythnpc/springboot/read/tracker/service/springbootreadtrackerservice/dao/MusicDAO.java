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
public class MusicDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
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