package com.edeal.server.impl;

import com.edeal.server.bean.ClasseBean;
import com.edeal.server.interfaces.ClasseDAO;
import com.edeal.server.jdbc.ConnexionBDD;
import com.edeal.server.jdbc.DeconnexionBDD;
import com.edeal.server.jdbc.ExtractionBDD;
import com.edeal.server.jdbc.QuerysUser;

import java.sql.SQLException;

//maTableDAOImplementation(le réel) implemente mon InterfaceDAO(abstrait).
public class ClasseDAOImpl implements ClasseDAO{
	
	/*@Override public ClasseBean getAll() {
		ConnexionBDD connexionBDD = new ConnexionBDD();
		QuerysUser querysUser = new QuerysUser();
		ExtractionBDD extractionBDD = new ExtractionBDD();
		DeconnexionBDD deconnexionBDD = new DeconnexionBDD();
		try {
			connexionBDD.setUpConnexion();
			querysUser.doASelect();
			extractionBDD.doAnExtrat();
			deconnexionBDD.setUpDeconnexion();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	//Modifier ici pour n'afficher que l'id (je pourrais modifier mon select en dur par ex.
	
	@Override
	public ClasseBean getClasseById(int id) {
		ConnexionBDD connexionBDD = new ConnexionBDD();
		QuerysUser querysUser = new QuerysUser();
		ExtractionBDD extractionBDD = new ExtractionBDD();
		DeconnexionBDD deconnexionBDD = new DeconnexionBDD();
		
		try {
			
			connexionBDD.setUpConnexion();
			querysUser.doAQuery();
			extractionBDD.doAnExtrat();
			deconnexionBDD.setUpDeconnexion();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return extractionBDD;
	}
}
