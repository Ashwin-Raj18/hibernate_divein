package com.possoul.hibernateBasics.FetchCriteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;


public class FetchCriteria {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		 Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
	     ServiceRegistry reg = new  StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
	     
	     SessionFactory sf = con.buildSessionFactory(reg);
	     Session session = sf.openSession();
	     Transaction tx = session.beginTransaction();
		
		List<Laptop> lapList = session.createCriteria(Laptop.class).addOrder(Order.desc("id")).list();
		
		lapList.stream().forEach(em->{
			System.out.println(em.getLid()+"  "+em.getBrand());
		});
		
		//Like example
		List<Laptop> lapList2 = session.createCriteria(Laptop.class)
						.add(Restrictions.like("brand", "%2%"))
						.list();
		
		lapList2.stream().forEach(em->{
			System.out.println(em.getLid()+"  "+em.getBrand());
		});
		
		//sum of price
		long sumPrice = (long) session.createCriteria(Laptop.class)
				.setProjection(Projections.sum("price"))
				.uniqueResult();
			System.out.println("Sum of Price = "+sumPrice);
		
		tx.commit();
		session.close();
	}

	
}
