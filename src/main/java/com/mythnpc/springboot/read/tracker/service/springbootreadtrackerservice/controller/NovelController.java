package com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.controller;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.dao.AuthorDAO;
import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.dao.NovelDAO;
import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model.Author;
import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model.Music;
import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.model.Novel;
import com.mythnpc.springboot.read.tracker.service.springbootreadtrackerservice.hystrix.*;

@RestController
public class NovelController {
	
    @Autowired
    private NovelDAO novelDao;
    
    @Autowired
    private AuthorDAO authorDao;
    
    @Autowired
    private SessionFactory sessionFactory;

    Set<Music> musics = new HashSet<>();
    
    @GetMapping("/novels")
	public List getAllNovel(){
    	authorDao.fun();
	  	  Calculator c = new Calculator();
	 	 
	 	  CalculatorSoap cs = c.getCalculatorSoap();
	 	  int a = cs.add(22,4);
    	
    	
        return null;

		
//	  exchangeValue.setPort(
//			Integer.parseInt(environment.getProperty("local.server.port")));

	}
    
    @GetMapping("/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b){
    	
    	int total = new CommandAdd(a, b).execute();
    	
        return total;

		
//	  exchangeValue.setPort(
//			Integer.parseInt(environment.getProperty("local.server.port")));

	}
}
