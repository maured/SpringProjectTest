package com.edeal.server.jdbc;

import java.sql.DriverManager;
import static com.edeal.server.jdbc.SetUpConnectivity.*;

public class ConnexionBDD{
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/Ecole";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "@dm!n";
	
	public void setUpConnexion() throws ClassNotFoundException
	{
		try
		{
			//Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//On ouvre la connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch (Exception e)
		{
			System.err.println("Driver non chargé !" + e);
			e.printStackTrace();
		}
	}
}
