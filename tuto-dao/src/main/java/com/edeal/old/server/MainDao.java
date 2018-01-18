package com.edeal.old.server;

import com.edeal.old.server.jdbc.DAOFactory;
import com.edeal.old.server.bean.ClasseBean;
import com.edeal.old.server.interfaces.ClasseDAO;

public class MainDao{
	public static void main(String[] args)
	{
		try
		{
			DAOFactory daoFactory = DAOFactory.getInstance();
			ClasseDAO classeDao = daoFactory.getClasseDao();
			ClasseBean bean = classeDao.trouver("test");
			if(bean!=null) {
				System.out.println("Affichage de l'id depuis l'MainDao : " + bean.getClasseId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
