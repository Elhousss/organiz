package com.omnishore.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.omnishore.dao.ResponsableDao;
import com.omnishore.entities.Responsable;
import com.omnishore.services.api.ICollaborateurService;
import com.omnishore.vo.ResponsableVo;

public class CollaborateurServiceImpl implements ICollaborateurService {

	@Inject
	private ResponsableDao collaborateurDao;
	
	@Override
	public void enregistrerCollaborateur(ResponsableVo ResponsableVo) {
		collaborateurDao.createResponsable(populateResponsable(ResponsableVo));
	}

	private Responsable populateResponsable(ResponsableVo ResponsableVo) {
		return new Responsable(ResponsableVo.getNom(),
				ResponsableVo.getPrenom(),
				ResponsableVo.getDateNaissance(),
				ResponsableVo.getDateEmbauche(),
				ResponsableVo.getDatePremierRec(), Boolean.TRUE, null,
				ResponsableVo.getIsResponsable());
	}

	@Override
	public ResponsableVo trouverCollaborateur(int CollaborateurID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResponsableVo> getCollaborateurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierCollaborateur(ResponsableVo Collaborateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerCollaborateur(int idCollaborateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifierNom(String nomCollaborateur) {
		// TODO Auto-generated method stub
		return false;
	}

}
