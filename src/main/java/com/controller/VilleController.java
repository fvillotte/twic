package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeBLOService;
	
	// Methode GET
		@RequestMapping(value = "/ville", method = RequestMethod.GET)
		@ResponseBody
		public ArrayList<Ville> appelGet() {
			System.out.println("Appel GET");
			
			
			ArrayList<Ville> listVille = villeBLOService.getInfoVille();
			//Ville ville = villeBLOService.getInfoVille();
			
			return listVille;
		}

//	// Methode GET
//	@RequestMapping(value = "/ville", method = RequestMethod.GET)
//	@ResponseBody
//	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam ) {
//		System.out.println("Appel GET");
//		
//		
//		ArrayList<Ville> listVille = villeBLOService.getInfoVille(monParam);
//		//Ville ville = villeBLOService.getInfoVille();
//		
//		return listVille;
//	}
	
	
	// Methode POST
		@RequestMapping(value = "/ville", method = RequestMethod.POST)
		@ResponseBody
		public void appelPost(@RequestBody Ville ville) {
			System.out.println("Appel POST");
			
			
			villeBLOService.creerVille(ville);
			
		}
		
	// Methode PUT
		@RequestMapping(value = "/ville", method = RequestMethod.PUT)
		@ResponseBody
		public void appelPut(@RequestBody Ville ville, String codeCommuneIni) {
			System.out.println("Appel PUT");
			
			
			villeBLOService.modifierVille(ville, codeCommuneIni);
			
		}
	

}
