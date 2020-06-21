package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;


@Service
public class VilleBLOImpl implements VilleBLO{
	
	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVille() throws SQLException{
		ArrayList<Ville> listVille = null;
		
		//TODO DAO
//		if(monParam != null) {
//			listVille = villeDAO
//		}
		listVille = villeDAO.getInfoVille();
		return listVille;
	}
	
	
	public void creerVille(Ville ville) throws SQLException{
		villeDAO.creerVille(ville);
	}
	
	public void modifierVille(Ville ville, String codeCommuneIni) throws SQLException {
		villeDAO.modifierVille(ville, codeCommuneIni);
	}
	

}
