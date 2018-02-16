package com.edeal.server.impl;

import com.edeal.server.bean.ClasseBean;
import com.edeal.server.interfaces.ClasseDAO;
import com.edeal.server.jdbc.DAOException;
import com.edeal.server.jdbc.DAOFactory;
import com.edeal.server.jdbc.DAOUtilitaire;
import org.springframework.stereotype.Service;

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
			preparedStatement = DAOUtilitaire
					.initialisationRequetePreparee(connection, SQL_INSERT, true, uneClasse.getClasseName());
			int statut = preparedStatement.executeUpdate();
			
			if (statut == 0)
				uneClasse.setClasseId(valeursAutoGenerees.getInt(1));
			else
				throw new DAOException("Echec de la création de la classe en base, aucun ID auto-généré retourné.");
		} catch (SQLException e){
			throw new DAOException(e);
		} finally {
			DAOUtilitaire.fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connection);
		}
	}

	@Override
	public void delete(ClasseBean uneClasse) throws IllegalArgumentException, DAOException {
		//a ecrire
	}

	@Override
	public void update(ClasseBean uneClasse) throws IllegalArgumentException, DAOException {
		//a ecrire
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
			System.out.println("Je m connect");
			preparedStatement = DAOUtilitaire.initialisationRequetePreparee(connection, SQL_SELECT_PAR_ID, false, nom);
			System.out.println("je charge mon statement");
			resultSet = preparedStatement.executeQuery();
			System.out.println("J'execute la query");
			
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
