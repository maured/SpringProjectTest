package com.edeal.server.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static com.edeal.server.jdbc.SetUpConnectivity.*;

public class QuerysUser{

	Scanner sc = new Scanner(System.in);
	
	public void doAQuery() throws SQLException
	{
		try {
			//Execution d'une requête
			System.out.println("Preparing statement...");
			System.out.println("Please write the query you want : ");
			query = sc.nextLine();

			String[] tab = query.split(" ");
			if (tab[0].equals("SELECT") || tab[0].equals("select")) 
				doASelect(query);
			else if (tab[0].equals("INSERT") || tab[0].equals("insert") || tab[0].equals("UPDATE")
					|| tab[0].equals("update") || tab[0].equals("DELETE") || tab[0].equals("delete"))
				doAModifyingQuery(query);
			else
			{
				System.out.println("I don't have understand your query, please write it again....");
				Thread.sleep(2000);
				doAQuery();	
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static void doASelect(String str) throws SQLException
	{
		try {
			System.out.println("Creating statement...");
			st = conn.createStatement();
			rs = st.executeQuery(str);
			//metadata = rs.getMetaData();
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	public void doAModifyingQuery(String str) throws SQLException
	{
		System.out.println("Creating statement...");
		st = conn.createStatement();
		rowUpdate = st.executeUpdate(str);
		//metadata = rowUpdate.getMetaData();
	}
}
