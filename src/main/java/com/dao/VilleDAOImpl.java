package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	public ArrayList<Ville> getInfoVille() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		Connection connection = JDBCConfiguration.getConnection();
		
		ResultSet results = null;
		Statement stmt = null;
		String requete = "SELECT * FROM ville_france";

		try {
		   stmt = connection.createStatement();
		   results = stmt.executeQuery(requete);
		   
		   while (results.next()) {
			   Ville ville = new Ville();
			   
			   ville.setCodeCommune(results.getString("Code_commune_INSEE"));
			   ville.setNomCommune(results.getString("Nom_commune"));
			   ville.setLibelleAcheminement(results.getString("Libelle_acheminement"));
			   ville.setCodePostal(results.getString("Code_postal"));
			   ville.setLatitude(results.getString("Latitude"));
			   ville.setLigne_5(results.getString("Ligne_5"));
			   ville.setLongitude(results.getString("Longitude"));
			   
			   listVille.add(ville);
			   
			}
		   
		} catch (SQLException e) {
		   //traitement de l'exception
		} 
		
		return listVille;
	}
	
	public void creerVille(Ville ville) {
		
		String requete = "INSERT INTO ville_france ('Code_commune_INSEE', 'Nom_commune', 'Libelle_acheminement', 'Code_postal', 'Latitude', 'Ligne_5', 'Longitude') "
				+ "VALUES (" + ville.getCodeCommune() + ", " + ville.getNomCommune() + ", " + ville.getLibelleAcheminement() + ", " + ville.getCodePostal() + ", " + ville.getLatitude() + ", " + 
				ville.getLigne_5() + ", " + ville.getLongitude() + ")";

		Connection connection = null;
		Statement stmt = null;
		
		try {
		   connection = JDBCConfiguration.getConnection();
		   stmt = connection.createStatement();
		   stmt.executeUpdate(requete);
		} catch (SQLException e) {
		   //traitement de l'exception
		} 
		
	}
	
	public void modifierVille(Ville ville, String codeCommuneIni) {
		
		String requete = "UPDATE ville_france SET Code_commune_INSEE = 'ville.getCodeCommune()', Nom_commune = 'ville.getNomCommune()', Libelle_acheminement = 'ville.getLibelleAcheminement()', Code_postal = 'ville.getCodePostal()', Latitude = 'ville.getLatitude()', Ligne_5 = 'ville.getLigne_5()', Longitude = 'ville.getLongitude()' WHERE Code_commune_INSEE = codeCommuneIni ";
		
		Statement stmt = null;
		
		try {
			   Connection connection = JDBCConfiguration.getConnection();
			   stmt = connection.createStatement();
			   stmt.executeUpdate(requete);
			} catch (SQLException e) {
			   //traitement de l'exception
			} 
		
	}

}
