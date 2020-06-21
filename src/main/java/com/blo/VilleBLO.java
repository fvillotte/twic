package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVille() throws SQLException;

	public void creerVille(Ville ville) throws SQLException;
	
	public void modifierVille(Ville ville, String codeCommuneIni) throws SQLException;
		
	

}
