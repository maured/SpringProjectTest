package com.edeal.service;

import com.edeal.server.bean.ClasseBean;
import com.edeal.server.interfaces.ClasseDAO;
import com.edeal.server.jdbc.DAOFactory;

public class ClasseService{
	
	public ClasseBean findByName(String name) throws Exception{
		ClasseDAO classeDao = DAOFactory.getInstance().getMyClasseDAO();
		return  classeDao.trouver(name);
	}
	
}
