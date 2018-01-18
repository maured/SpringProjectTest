package com.edeal.server.jdbc;

public class MyExtractionExeption extends Exception{
	public MyExtractionExeption()
	{
		System.out.println("You are trying to communicate with a column whitch doesn't exist or no supported by the programme.");
		System.out.println("You will be redirected on the deconnexion service to prevent against lossyness of network connection.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
