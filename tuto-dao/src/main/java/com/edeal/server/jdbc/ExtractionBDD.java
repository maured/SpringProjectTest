package com.edeal.server.jdbc;

import com.edeal.server.bean.ClasseBean;
import com.edeal.server.jdbc.QuerysUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static com.edeal.server.jdbc.SetUpConnectivity.*;

public class ExtractionBDD extends ClasseBean{
	
	public void doAnExtrat() throws SQLException
	{
		//Map<String, String> map = new HashMap<String, String>();
		//Extraction des données du ResultSet !
		//ColumnName mesNomsColonnes = new ColumnName();
		
		String[] tab = query.split(" ");
		//String[] nomColonnes = mesNomsColonnes.getNomsColonnes(rs);
		//System.out.println(nomColonnes);
		int i = 1;
		
		while(rs.next())
		{
			if (tab[i].equals("cls_id"))
			{
				int id = rs.getInt("cls_id");
				setClasseId(id);
				System.out.println("ID depuis ma methode doAnextract: " + id);
			}
			else if (tab[i].equals("nom"))
			{
				String nameColumn = rs.getString("nom");
				setClasseName(nameColumn);
				System.out.println("Name depuis ma methode doAnextract: " + nameColumn);
			}
			else if (tab[i].equals("*"))
			{
				int id = rs.getInt("cls_id");
				setClasseId(id);
				System.out.println("ID depuis ma methode doAnextract: " + id);

				String nameColumn = rs.getString("nom");
				setClasseName(nameColumn);
				System.out.println("Name depuis ma methode doAnextract: " + nameColumn);
			}
			else
			{
				System.out.println("You are trying to communicate with a column whitch doesn't exist or no supported by the programme.");
				System.out.println("You will be redirected on the deconnexion service to prevent against lossyness of network connection.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				QuerysUser userHaveTo = new QuerysUser();
				userHaveTo.doAQuery();
			}
		}
	}
}
