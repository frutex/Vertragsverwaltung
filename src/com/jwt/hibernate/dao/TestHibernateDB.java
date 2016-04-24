package com.jwt.hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jwt.hibernate.bean.*;

public class TestHibernateDB {

	public TestHibernateDB(){


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
}
