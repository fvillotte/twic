package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	
	@Bean
	public static Connection getConnection() {
		
		String BDD = "ville_france";
	    String url = "jdbc:mysql://localhost:8889/" + BDD;
	    String user = "root";
	    String password = "root";
	    
	    Connection connection = null;
	    // L'essaie de connexion à votre base de donées
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection(url, user, password);
	        System.out.println("Connecter");
	    } catch (Exception e){
	        e.printStackTrace();
	        System.out.println("Erreur");
	        System.exit(0);
	    }
	    return connection;
		
	}
	
	

}
