package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pojo.Product;

public class BLManager {

	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	
	
	public List<Product> serchbyproduct()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Product.class);
		
		List<Product> l=cr.list();
		
		return l;
	}



	public Product serchbyid(int id1) {
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Product.class);
		cr.add(Restrictions.eq("id", id1));

		Product id=(Product) cr.uniqueResult();

				return id;
	}




}
