package com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model.Novel;

@Repository
@Transactional
public class NovelDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String saveNovel(Novel novel) {
        Long isSuccess = (Long)getSession().save(novel);
        if(isSuccess >= 1){
            return "Success";
        }else{
            return "Error while Saving Novel";
        }
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