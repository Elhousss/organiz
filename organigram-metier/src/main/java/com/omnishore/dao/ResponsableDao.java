package com.omnishore.dao;

import java.util.List;

import com.omnishore.entities.Responsable;

public interface ResponsableDao {
	
	public void createResponsable(Responsable Responsable);
	public Responsable findResponsable(int ResponsableId);
	public List<Responsable> getResponsables();
	public void updateResponsable(Responsable Responsable);
	int getMaxID();
}
