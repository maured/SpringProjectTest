package com.edeal;

import com.edeal.old.server.bean.ClasseBean;
import com.edeal.old.server.jdbc.DAOFactory;

public class MainCore{

	public static void main(String[] args) {

		ClasseBean bean = DAOFactory.getInstance().getClasseDao().trouver("test");
		System.out.println(bean.getClasseId());
	}
}
