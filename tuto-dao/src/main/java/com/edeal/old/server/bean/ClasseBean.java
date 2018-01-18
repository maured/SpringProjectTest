package com.edeal.old.server.bean;

import java.io.Serializable;

//maTableBean
public class ClasseBean implements Serializable{
	
	private int classeId;
	private String classeName;
	
	public ClasseBean() {
		
	}
	
	public int getClasseId() {
		return classeId;
	}

	public void setClasseId(int classeId) {
		this.classeId = classeId;
	}

	public String getClasseName() {
		return classeName;
	}

	public void setClasseName(String classeName) {
		this.classeName = classeName;
	}
}
