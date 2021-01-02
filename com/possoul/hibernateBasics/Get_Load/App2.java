package com.possoul.hibernateBasics.Get_Load;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App2 {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Laptop.class);    
        SessionFactory sf = config.buildSessionFactory();   
        Session session = sf.openSession();
        
        session.beginTransaction();
        Random r = new Random();       
      for(int i=1;i<=50;i++)
     {
     	Laptop s = new Laptop();
     	s.setLid(i);
     	s.setBrand("brand" + i);
     	s.setPrice(r.nextInt(100));
     	session.save(s);
     }
      session.getTransaction().commit();
	}

}
