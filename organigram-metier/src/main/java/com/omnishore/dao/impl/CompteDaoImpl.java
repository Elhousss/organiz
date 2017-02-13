package com.omnishore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.omnishore.dao.CompteDao;
import com.omnishore.entities.Compte;


public class CompteDaoImpl implements CompteDao{

	@Override
	public void enregistrerCompte(Compte c) {
		Session session = null;
		try{
			String pass = c.getMotDePasse();
			
			ConfigurablePasswordEncryptor cpe = new ConfigurablePasswordEncryptor();
			cpe.setAlgorithm("SHA-256");
			cpe.setPlainDigest(false);
			
			String passCrypte = cpe.encryptPassword(pass);
			c.setMotDePasse(passCrypte);

			SessionFactory sf = (new Configuration()).configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@Override
	public Compte trouverCompte(String login) {
		Session session = null;
		Compte compte = null;
		try{
			System.out.println("in the try block !");
			SessionFactory sf = (new Configuration()).configure().buildSessionFactory();
			session = sf.openSession();
			System.out.println("la session est ouverte");
			session.beginTransaction();
			compte = session.get(Compte.class, login);
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return compte;
	}

	@Override
	public boolean verifierPass(String login, String pass) {
		Session session = null;
		Compte compte = null;
		boolean correct = false;
		try{

			SessionFactory sf = (new Configuration()).configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			compte = session.get(Compte.class, login);
			if(compte!=null){
				ConfigurablePasswordEncryptor cpe = new ConfigurablePasswordEncryptor();
				cpe.setAlgorithm("SHA-256");
				cpe.setPlainDigest(false);
				if(cpe.checkPassword(pass, compte.getMotDePasse())){
					correct=true;
				}
			}
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return correct;
	}

	@Override
	public boolean estAdmin(String login) {
		boolean admin = false;
		Session session = null;
		String hql;
		try{
			hql = "select estAdmin from Compte where login = :login";
			SessionFactory sf = (new Configuration()).configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("login", login);
			List result = query.getResultList();
			if(result.get(0).equals(Boolean.valueOf(true))){
				admin = true;
			}
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}		
		return admin;
	}
	
	
}