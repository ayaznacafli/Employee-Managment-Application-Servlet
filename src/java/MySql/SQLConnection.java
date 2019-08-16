/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.gjt.mm.mysql.Driver;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
class SQLConnection {
	private Connection connection;
	private static SQLConnection instance;
          private SQLConnection() {
		try {
			DriverManager.registerDriver(new Driver());
		} catch (SQLException ex) {
			System.out.println("DriverManager xetasi...");
			ex.printStackTrace();
		}
	}
		  
	public static SQLConnection getInstance(){
		if(instance==null){
			instance=new SQLConnection();
		}return instance;
	}
	
	public Connection getConnection(){
		try {
			if(connection==null|| connection.isClosed()){
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ayaz", "root", "ayaz1997");
			}
		} catch (Exception e) {
			System.out.println("Connection xetasi..");
			e.printStackTrace();
		}
		return connection;
	}	

}
