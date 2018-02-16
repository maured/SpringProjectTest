package com.edeal.connector;

import com.google.gson.Gson;

public abstract class JsonConnector{
	
	public JsonConnector(){
		
	} 
	public abstract String toJson() throws Exception;
	
	
	protected String toJson(Object o){
		Gson gson = new Gson();
		return gson.toJson(o);
	}

}
