package com.edeal.old.server.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The type Dao utilitaire.
 */
public class DAOUtilitaire {
	
	private DAOUtilitaire(){
	}
	
	/*
	 * Initialise la requête préparée basée sur la connexion passée en argument,
	 * avec la requête SQL et les objets donnés.
	 */
	
	/**
	 * Initialisation requete preparee prepared statement.
	 *
	 * @param connexion           the connexion
	 * @param sql                 the sql
	 * @param returnGeneratedKeys the return generated keys
	 * @param objets              the objets
	 * @return the prepared statement
	 * @throws SQLException the sql exception
	 */
	public static PreparedStatement initialisationRequetePreparee(Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets)
			throws SQLException 
	{
		PreparedStatement preparedStatement;
		preparedStatement = null;
		
		try {
			preparedStatement = connexion.prepareStatement(sql,
					returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
			for (int i = 0; i < objets.length; i++) {
				preparedStatement.setObject(i + 1, objets[i]);
			}
		} catch (SQLException e) {
			throw new DAOConfigurationException("Clé pas générée");
		}
		finally {
			return preparedStatement;
		}
	} 
		
		

	/* Fermeture silencieuse du resultset */
	public static void fermetureSilencieuse(ResultSet resultSet)
	{
		if(resultSet != null)
		{
			try {
				resultSet.close();
			} catch ( SQLException e ) {
				System.out.println( "Echec de la fermeture du ResultSet : " + e.getMessage() );
			}
		}
	}

	/* Fermeture silencieuse du statement */
	public static void fermetureSilencieuse(Statement statement)
	{
		if(statement != null)
		{
			try {
				statement.close();
			} catch ( SQLException e ) {
				System.out.println( "Echec de la fermeture du Statement : " + e.getMessage() );
			}
		}
	}

	/* Fermeture silencieuse de la connexion */
	public static void fermetureSilencieuse(Connection connexion)
	{
		if(connexion != null) {
			try {
				connexion.close();
			} catch ( SQLException e ) {
				System.out.println( "Echec de la fermeture de la connexion : " + e.getMessage() );
			}
		}
	}

	/* Fermetures silencieuses du statement et de la connexion */
	public static void fermeturesSilencieuses(Statement statement, Connection connexion) 
	{
		fermetureSilencieuse( statement );
		fermetureSilencieuse( connexion );
	}

	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void fermeturesSilencieuses(ResultSet resultSet, Statement statement, Connection connexion)
	{
		fermetureSilencieuse( resultSet );
		fermetureSilencieuse( statement );
		fermetureSilencieuse( connexion );
	}
}
