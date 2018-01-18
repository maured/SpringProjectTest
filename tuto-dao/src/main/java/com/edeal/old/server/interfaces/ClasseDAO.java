package com.edeal.old.server.interfaces;
import com.edeal.old.server.jdbc.DAOException;
import com.edeal.old.server.bean.ClasseBean;

public interface ClasseDAO {
	
	void create(ClasseBean uneClasse) throws DAOException;
	
	void delete(ClasseBean uneClasse) throws DAOException;
	
	void update(ClasseBean uneClasse) throws DAOException;
	
	ClasseBean trouver (String nom) throws DAOException;
	
}
