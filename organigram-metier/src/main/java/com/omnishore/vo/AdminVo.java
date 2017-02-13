package com.omnishore.vo;

import java.util.ArrayList;
import java.util.Collection;

public class AdminVo extends CollaborateurVo{
	
	private Collection<EntiteVo> entites = new ArrayList<EntiteVo>();
	private Collection<ResponsableVo> responsables = new ArrayList<ResponsableVo>();
	
	
	public Collection<EntiteVo> getEntites() {
		return entites;
	}
	public void setEntites(Collection<EntiteVo> entites) {
		this.entites = entites;
	}
	public Collection<ResponsableVo> getResponsables() {
		return responsables;
	}
	public void setResponsables(Collection<ResponsableVo> responsables) {
		this.responsables = responsables;
	}

	
}
