package com.edeal.server;

import com.edeal.server.jdbc.DAOFactory;
import com.edeal.server.bean.ClasseBean;
import com.edeal.server.interfaces.ClasseDAO;
import com.edeal.server.loggertest.Bar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MainDao{
	private static final Logger logger = LogManager.getLogger(MainDao.class);
	public static void main(String[] args)
	{
//		try
//		{
//			DAOFactory daoFactory = DAOFactory.getInstance();
//			ClasseDAO classeDao = daoFactory.getMyClasseDAO();
//			ClasseBean bean = classeDao.trouver("test");
//			if(bean!=null) {
//				System.out.println("Affichage de l'id depuis l'MainDao : " + bean.getClasseId());
//				System.out.println("Affichage de l'id depuis l'MainDao : " + bean.getClasseName());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Bar bar = new Bar();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		if (str == " error")
		{
			logger.error("Didn't do it.");
		}
		else if (str == "info")
			logger.trace("Exiting application.");
		else
		{
			logger.error("Didn't do it.");
			logger.trace("Exiting application.");
		}
			
//		logger.trace("Entering application.");
//		if (!bar.doIt()) {
//			S
//		}
//		else
//			bar.testInfo();
//		
	}
}
