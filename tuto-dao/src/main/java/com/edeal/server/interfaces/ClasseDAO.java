package com.edeal.server.interfaces;
import com.edeal.server.jdbc.DAOException;
import com.edeal.server.bean.ClasseBean;

public interface ClasseDAO {
	
	void create(ClasseBean uneClasse) throws DAOException;
	
	void delete(ClasseBean uneClasse) throws DAOException;
	
	void update(ClasseBean uneClasse) throws DAOException;
	
	ClasseBean trouver (String nom) throws DAOException;
	
}
