package com.edeal.old.server.jdbc;
import com.edeal.old.server.impl.ClasseDAOImpl;
import com.edeal.old.server.interfaces.ClasseDAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory{
	
	private static final String FICHIER_PROPERTIES			= "dao.properties";
	private static final String PROPERTY_URL				= "url";
	private static final String PROPERTY_DRIVER				= "driver";
	private static final String PROPERTY_NOM_UTILISATEUR	= "nomutilisateur";
	private static final String PROPERTY_MOT_DE_PASSE		= "motdepasse";
	
	private String 				url;
	private String 				username;
	private String 				password;

	DAOFactory (String url, String username, String password)
	{
		this.url = url;
		this.username = username;
		this.password =	password;
	}
	
	public static DAOFactory getInstance() throws DAOConfigurationException 
	{
		Properties properties = new Properties();
		String url;
		String driver;
		String nomutilisateur;
		String motDePasse;
		
		//C'est quoi ? On appel la methode getResourcesAsStream() de l'objet ClassLoader. Il retourne le flux demandé et retourne null en cas d'erreur.
		//Ensuite nous récupérons le ClassLoader depuis le thread courant grace a getContextClassLoader().
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream	fichierproperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);
		
		if (fichierproperties == null)
		{
			throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable."); 
		}
		
		try {
			//chargement des propriétés
			properties.load(fichierproperties);
			//lecture des propriétés
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			nomutilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);
		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
		}
		
		try{
			//On tente ici de charger le driver JDBC dont le nom est précisé dans le fichier dao.properties.
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Le driver est introuvable dans le classpath", e);
		}
		
		//Si tout s'est bien passé avant, nous instancions la DAOFactory en appelant le constructeur. 
		DAOFactory instance = new DAOFactory(url, nomutilisateur, motDePasse);
		return instance;
	}
	
	//Ici nous créons getConnection pour fournir une connexion a la base de données.
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	//cette méthode sert de getter retournant les différentes implémentations de DAO contenues dans notre app.
	//Nous avons qu'une seule Table pour le moment donc qu'un seul DAO 
	public ClasseDAO getClasseDao()
	{
		return new ClasseDAOImpl(this);
	}
}
