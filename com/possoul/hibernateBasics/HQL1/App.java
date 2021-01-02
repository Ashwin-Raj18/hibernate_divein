package com.possoul.hibernateBasics.HQL1;

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
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);    
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(registry);   
        Session session = sf.openSession();
        
        session.beginTransaction();
        Random r = new Random();       
     
      session.getTransaction().commit();  //ignore the error
        
       

//        Query q = session.createQuery("from Student where rollno=7");
//        Student student = (Student) q.uniqueResult();
//        System.out.println(student);
        
////        Query q1 = session.createQuery("from Student where marks > 50");      		
//        Query q1 = session.createQuery("from Student"); //(Fetch all student data)
//		  List<Student> students = q1.list(); 
//		  for(Student s : students) 
//		  {
//		  System.out.println(s); 
//		  }
        
        
//        Query q2 = session.createQuery("select rollno, name, marks from Student where rollno = 7");
//		  Object[] student = (Object[]) q2.uniqueResult();
////        System.out.println(student[0]+": "+student[1]+": "+student[2]);   ///object array is for only one rows
//        for(Object o : student) {
//        	System.out.println(o);
//        }
        
        
        
        
        
//          Query q3 = session.createQuery("select rollno, name, marks from Student"); 
//          List<Object[]> students = (List<Object[]>) q3.list();                         //we cant use uniqueResult because fetching entire list
//          for(Object[] o: students) {
//        	  System.out.println(o[0]+": "+o[1]+": "+o[2]);
          }
        
        
        ///////*****Here we are fetching student object not values*******///////////
//            Query q4 = session.createQuery("select * from Student where marks > 60"); 
//    		q4.addEntity(Student.class);     ///for getting student object
//    		List<Student> student = q4.list();
//    		for (Student s: student) {
//    			System.out.println(s);
//    		}
    
    
    
    
    
        
        
        
        
///////FOR ADDING TABLE TO DB//////////        
//         Random r = new Random();       
//         for(int i=1;i<=50;i++)
//        {
//        	Student s = new Student();
//        	s.setRollno(i);
//        	s.setName("Name" + i);
//        	s.setMarks(r.nextInt(100));
//        	session.save(s);
//        }
  
    

    }

