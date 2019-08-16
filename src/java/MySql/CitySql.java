/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySql;

import Pojo.City;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class CitySql {
	
   private  SQLConnection instance = SQLConnection.getInstance();
   
   public List<City> findAllCity(){
	   List<City> city = new ArrayList<>();
	   try(Connection connection = instance.getConnection()) {
		   PreparedStatement preparedStatement = connection.prepareStatement("Select * from city");
		   ResultSet resultSet = preparedStatement.executeQuery();
		   while(resultSet.next()){
			   city.add(new City(
					 resultSet.getInt(1), 
					 resultSet.getString(2)));
		   }
	   } catch (Exception e) {
	   }
	   return city;
   }


}
