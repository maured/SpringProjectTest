/*package com.test.server.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingleConnection
{

	private static String url = "jdbc:postgresql://localhost:5432/Ecole";
	private static String user = "postgres";
	private static String passwd = "@dm!n";

	private static Connection connection;
	public static Statement state;
	public static ResultSet resultSet;

	//Constructeur privé
	private SingleConnection(){
		
	}

	//Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	public static synchronized Connection getInstance(){
		if(connection == null){
			try {
				connection = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("CONNEXION SQL EXISTANTE ! ");
		}
		return connection;
	}
}
*/