package com.omnishore.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.omnishore.dao.EntiteDao;
import com.omnishore.entities.Entite;
import com.omnishore.services.api.IEntityService;
import com.omnishore.vo.EntiteVo;

public class EntityServiceImpl implements IEntityService {

	@Inject
	private EntiteDao entiteDao;
	
	@Override
	public void enregistrerEntite(EntiteVo entiteVo) {
		entiteDao.enregistrerEntite(populateEntiy(entiteVo));
	}

	private Entite populateEntiy(EntiteVo entiteVo) {
		return new Entite(0, entiteVo.getNom(), entiteVo.getDescription(), null, null, null, null);
	}

	@Override
	public EntiteVo trouverEntite(int entiteID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntiteVo> getEntites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierEntite(int idEntite, EntiteVo entite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEntite(int idEntite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifierNom(String nomEntite) {
		// TODO Auto-generated method stub
		return false;
	}

}
