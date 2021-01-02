package com.possoul.hibernateBasics.FetchingDB;



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
        
        Allien possoul = new Allien();
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Allien.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        possoul = session.get(Allien.class,1);	
        tx.commit();
        
        System.out.println(possoul);
    }
     
}
