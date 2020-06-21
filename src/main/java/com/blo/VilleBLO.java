package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVille();

	public void creerVille(Ville ville);
	
	public void modifierVille(Ville ville, String codeCommuneIni);
		
	

}
