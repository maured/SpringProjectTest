package com.edeal.server.jdbc;

import com.edeal.server.bean.ClasseBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SetUpConnectivity
{
	//Set up connexion
	static Connection conn = null;
	static Statement st = null;
	static ResultSet rs = null;
	static int rowUpdate;
	static String query;
	static ResultSetMetaData metadata;
}	


	
