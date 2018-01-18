package com.edeal.old.server.impl;

import com.edeal.old.server.bean.ClasseBean;
import com.edeal.old.server.interfaces.ClasseDAO;
import com.edeal.old.server.jdbc.DAOException;
import com.edeal.old.server.jdbc.DAOFactory;
import com.edeal.old.server.jdbc.DAOUtilitaire;

import static com.edeal.old.server.jdbc.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//maTableDAOImplementation(le réel) implemente mon InterfaceDAO(abstrait).
public class ClasseDAOImpl implements ClasseDAO{
	
	private DAOFactory daoFactory;
	private static final String SQL_SELECT_PAR_ID = "SELECT cls_id, nom FROM classe WHERE nom = ?";
	
	private static final String SQL_INSERT = "INSERT INTO Classe (nom) VALUES (?, NOW())";
	
	public ClasseDAOImpl(DAOFactory daoFactory)
	{
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(ClasseBean uneClasse) throws IllegalArgumentException, DAOException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;
		
		try{
			connection = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connection, SQL_INSERT, true, uneClasse.getClasseName());
			int statut = preparedStatement.executeUpdate();
			
			if (statut == 0)
				uneClasse.setClasseId(valeursAutoGenerees.getInt(1));
			else
				throw new DAOException("Echec de la création de la classe en base, aucun ID auto-généré retourné.");
		} catch (SQLException e){
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connection);
		}
	}

	@Override
	public void delete(ClasseBean uneClasse) throws IllegalArgumentException, DAOException {

	}

	@Override
	public void update(ClasseBean uneClasse) throws IllegalArgumentException, DAOException {

	}

	@Override
	public ClasseBean trouver(String nom) throws DAOException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ClasseBean classeBean = null;
		
		try{
			connection = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_PAR_ID, false, nom);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
				classeBean = map(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DAOUtilitaire.fermeturesSilencieuses(resultSet, preparedStatement, connection);
		}
		return classeBean;
	}
	
	private static ClasseBean map(ResultSet resultSet)
		throws SQLException
	{
		ClasseBean classeBean = new ClasseBean();
		classeBean.setClasseId(resultSet.getInt("cls_id"));
		classeBean.setClasseName(resultSet.getString("nom"));
		
		return classeBean;
	}
}
