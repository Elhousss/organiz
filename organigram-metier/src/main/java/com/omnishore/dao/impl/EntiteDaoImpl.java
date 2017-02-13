package com.omnishore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.omnishore.dao.EntiteDao;
import com.omnishore.entities.Entite;

public class EntiteDaoImpl implements EntiteDao{

	@Override
	public void enregistrerEntite(Entite entite){
		Session session = null;
		SessionFactory sessionFactory = null;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(entite);
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
	public Entite trouverEntite(int entiteID) {
		Session session = null;
		SessionFactory sessionFactory = null;
		Entite entite = null;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			entite = session.get(Entite.class, entiteID);
			session.getTransaction().commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
		return entite;
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
			hql = "select max(idEntite) from Entite";
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

	@Override
	public List<Entite> getEntites() {
		String hql;
		SessionFactory sessionFactory = null;
		Session session = null;
		List<Entite> entites = null;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			hql = "from Entite";
			Query query = session.createQuery(hql);
			entites = query.getResultList();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			sessionFactory.close();
			session.close();
		}
		return entites;
	}
	
	@Override
	public void modifierEntite(int idEntite, Entite entite) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Entite ent = null;
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			ent = trouverEntite(idEntite);
			if(ent!=null){
				ent.setIdEntite(entite.getIdEntite());
				ent.setNom(entite.getNom());
				ent.setDescription(entite.getDescription());
				session.update(ent);
				session.getTransaction().commit();
				System.out.println("Entite ("+ent.getIdEntite()+" "+ent.getNom()+" "+ent.getDescription()+") modifiée");

			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void supprimerEntite(int EntiteID) {
		Session session = null;
		SessionFactory sessionFactory = null;
		System.out.println("l'id à supprimer est : "+EntiteID);
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Entite entite = trouverEntite(EntiteID);
			if(entite!=null){
				session.delete(entite);
				System.out.println("Entite "+entite.getNom()+"supprimé");
				session.getTransaction().commit();
			}
			else{
				System.out.println("pas d'entite avec l'id "+EntiteID);
			}
			
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
	public boolean verifierNom(String nomEntite) {
		boolean estUnique = true;
		String hql;
		Session session = null;
		SessionFactory sessionFactory = null;
		try{
			hql = "from Entite where nom =:nomNouvelleEntite";
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("nomNouvelleEntite", nomEntite);
			List result = query.getResultList();
			if(!result.isEmpty()){
				estUnique = false;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
		
		return estUnique;
	}
}





