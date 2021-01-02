package com.possoul.hibernateBasics.ManupulationDB;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        AllienName aname = new AllienName();
        aname.setFname("ashwin");
        aname.setLname("rao");
        aname.setMname("raj");
        
        Allien possoul = new Allien();

        possoul.setAid(3);
        possoul.setAname(aname);
        possoul.setColour("grey");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Allien.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(possoul);	
        tx.commit();
        
        System.out.println(possoul);
    }
     
}
