package com.possoul.hibernateBasics.Get_Load;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);    
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(registry);   
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Laptop l = session.get(Laptop.class,2);        //get gives the object no matter what
        System.out.println(l.getPrice());
      
        Laptop l2 = session.load(Laptop.class,16);		//It gives proxy object unless its called to print or used to process 
        Laptop l3 = session.load(Laptop.class,11);
        Laptop l4 = session.load(Laptop.class,18);
        Laptop l5 = session.load(Laptop.class,45);
        
        List<Laptop> lapList = new ArrayList<Laptop>();         
        														//STILL
        lapList.add(l2);										//IT WONT 						
        lapList.add(l3);										//CREATE
        lapList.add(l4);										//OBJECT
        lapList.add(l5);
        
        
        System.out.println(lapList.toString());    //now it will create all objects.
        
        
        
      session.getTransaction().commit();  
    
    }
}