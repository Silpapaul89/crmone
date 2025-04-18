package vtiger.crm.datasecurity;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBUtility {
	
Connection con;
	
	public void getDbConnection(String url,String username, String password) {
		
		try {
		 Driver d = new Driver();
		DriverManager.registerDriver(d);
		con= DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			
		}
		
	}
	public void getDbConnection() {
		
		try {
		 Driver d = new Driver();
		DriverManager.registerDriver(d);
		con= DriverManager.getConnection("jsbc:mysql://localhost:3306/projects", "root", "root");
		}catch(Exception e) {
		}
		}
	
	public void closeDbconnection() throws SQLException {
		try {
		con.close();
	} catch(Exception e) {
		
	}

}
	public ResultSet executeSelectQuery(String query) {
		
		ResultSet result= null;
		try {
			Statement stat = con.createStatement();
			result= stat.executeQuery(query);
		}catch(Exception e) {
		
	}
		return result;
		
	}
	public 	int executeNonSelectQuery(String query) {
		int result=0;
	
		try {
			Statement stat = con.createStatement();
			result= stat.executeUpdate(query);
		}catch(Exception e) {
		
	}
		return result;
		
	
	
}
}
