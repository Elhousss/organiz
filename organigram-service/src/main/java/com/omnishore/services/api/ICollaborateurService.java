package com.omnishore.services.api;

import java.util.List;

import com.omnishore.vo.ResponsableVo;

public interface ICollaborateurService {
	
	public void enregistrerCollaborateur(ResponsableVo Collaborateur);
	public ResponsableVo trouverCollaborateur(int CollaborateurID);
	public List<ResponsableVo> getCollaborateurs();
	public void modifierCollaborateur(ResponsableVo Collaborateur);
	public void supprimerCollaborateur(int idCollaborateur);
	public boolean verifierNom(String nomCollaborateur);
	

}
