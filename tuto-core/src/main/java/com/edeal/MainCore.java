package com.edeal;

import com.edeal.service.ClasseService;


public class MainCore{
	public static void main(String[] args) {
		ClasseService classeService = new ClasseService();
		String name = "test";
		try {
			classeService.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
