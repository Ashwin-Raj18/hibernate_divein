package com.possoul.hibernateBasics.MappingRelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class App {

	public static void main(String[] args) {
		
		Laptop laptop = new Laptop();
		Student student = new Student();
		
		laptop.setLid(456);
		laptop.setLname("lenovo");
		laptop.getStudents().add(student);
		
		student.setSname("ashwin");
		student.setRollNo(01);
		student.setMarks(97);
		student.getLaptop().add(laptop);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(laptop);
        session.getTransaction().commit();
        
        
	}

}
