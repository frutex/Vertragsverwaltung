package com.jwt.hibernate.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jwt.hibernate.bean.*;

//@ManagedBean(name = "searchMAresults", eager = true)
//@SessionScoped
public class MitarbeiterDAO {

	public MitarbeiterDAO(){


	}

	@SuppressWarnings("finally")
	public static boolean storeMA(String name, String vorname, String telnr, String adresse) {
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		session = sessionFactory.openSession();

		MitarbeiterEO test = new MitarbeiterEO();
		test.setM_name(name);
		test.setM_vorname(vorname);
		test.setM_telnr(telnr);
		test.setM_adresse(adresse);

		Transaction tx;
		tx = session.beginTransaction();
		try {
			session.save(test);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			return true;
		}

	}
	
	public MitarbeiterEO findMA(String id, String name) throws Exception {
		Session session = null;
		SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		session = sessionFactory.openSession();
		if (!id.equals("")) {
			return (MitarbeiterEO) session.get(MitarbeiterEO.class, new Integer(id));
		} else {
			String hql="FROM "+MitarbeiterEO.class.getName()+" WHERE M_NAME = :name";
			Transaction tx;
			tx = session.beginTransaction();
			try {
				MitarbeiterEO tmp= (MitarbeiterEO) session
						.createQuery(hql).setParameter("name", name).list().get(0);
				tx.commit();
				return tmp;
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
			} finally {
			}
			
			
		}
	}
}
