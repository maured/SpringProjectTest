package com.edeal.server;

import com.edeal.server.bean.ClasseBean;
import com.edeal.server.impl.ClasseDAOImpl;
import com.edeal.server.interfaces.ClasseDAO;
import com.edeal.server.jdbc.*;

public class main{
	public static void main(String[] args) {
		
		try {
			ClasseDAO classeDAO = new ClasseDAOImpl();
			ClasseBean toto = classeDAO.getClasseById(1);
			
			System.out.println("Affichage de l'id depuis le MainDao : " + toto.getClasseId());
//			System.out.println("Affichage du nom depuis le MainDao : " + toto.getClasseName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
