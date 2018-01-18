package com.edeal.server.jdbc;

import java.sql.SQLException;

import static com.edeal.server.jdbc.SetUpConnectivity.*;

/**
 * 
 */
public class DeconnexionBDD{
	
	public void setUpDeconnexion()
	{
		try
		{
			rs.close();
			st.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(st != null)
				{
					st.close();
					System.out.println("Statement close");
				}
			}
			catch(SQLException se2){
			}// nothing we can do
			try
			{
				if(conn != null)
				{
					conn.close();
					System.out.println("Connection close");
				}
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}
