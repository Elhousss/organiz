package com.omnishore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.omnishore.dao.ResponsableDao;
import com.omnishore.entities.Responsable;


public class ResponsableDaoImpl implements ResponsableDao{

	@Override
	public void createResponsable(Responsable Responsable) {

		Session session = null;
		SessionFactory sessionFactory = null;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(Responsable);
			session.getTransaction().commit();
			System.out.println("Entité enregistrée");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
	
		
	}

	@Override
	public Responsable findResponsable(int responsableId) {
		Session session = null;
		SessionFactory sessionFactory = null;
		Responsable responsable = null;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			responsable = session.get(Responsable.class, responsableId);
			session.getTransaction().commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
		return responsable;
	}

	@Override
	public List<Responsable> getResponsables() {
		String hql;
		SessionFactory sessionFactory = null;
		Session session = null;
		List<Responsable> responsables = null;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			hql = "from Collaborateur where isResponsable is true";
			Query query = session.createQuery(hql);
			responsables = query.getResultList();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sessionFactory.close();
			session.close();
		}
		return responsables;
	}

	@Override
	public void updateResponsable(Responsable Responsable) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public int getMaxID() {
		String hql;
		SessionFactory sessionFactory = null;
		Session session = null;
		int id = -1;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			hql = "select max(idCollaborateur) from Collaborateur";
			Query query = session.createQuery(hql);
			List<Object> results = query.getResultList();
			if(results.get(0)==null){
				id = 1;
			}
			else{
				id = (int) results.get(0) + 1;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sessionFactory.close();
			session.close();
		}
		return id;
	}
	
}





