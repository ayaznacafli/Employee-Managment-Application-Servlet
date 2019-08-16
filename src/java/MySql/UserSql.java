/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySql;

import Pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserSql {
	
	private final SQLConnection instance = SQLConnection.getInstance();
	private List<User> user;
	
	// Login
	public User Login(String username, String password){
		User user = null;
		try(Connection connection = instance.getConnection()) {
		    PreparedStatement preparedStatement = connection.prepareStatement("Select id,name,surname,mail,status,role_id from user where mail=? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
			user = new User();
				
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setSurname(resultSet.getString(3));
			user.setEmail(resultSet.getString(4));
			user.setStatus(resultSet.getInt(5));
			user.setRoleId(resultSet.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println("User Login xetasi....");
			e.printStackTrace();
			
		}
		return user;
	}
	/// Confirmation
	public User  findByUserConfirmationCode(String ConfirmationCode){
		User user = null;
		try(Connection connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT  id,name,surname,mail,status,role_id  FROM ayaz.user where confirmation_code=? and status=0 and TIMESTAMPDIFF(DAY, registr_data, NOW()) <=10");
		         preparedStatement.setString(1, ConfirmationCode);
				 
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
			user = new User();
				
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setSurname(resultSet.getString(3));
			user.setEmail(resultSet.getString(4));
			user.setStatus(resultSet.getInt(5));
			user.setRoleId(resultSet.getInt(6));
			}

				 
		} catch (Exception e) {
			System.out.println("UserSql findByUserConfirmationCode xetasi ....");
		}
		return user;
	}
	/// Confirmatin
	public void confirmUser(int id){
		try(Connection connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("Update user set status=1,confirmation_code=null where id=?");
		         preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("UserSql confirmUser xetas...");
		}
	}
	/////////////////////
	public int getActionId(String actionName){
		try(Connection  connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("Select id from ayaz.action where name=?");
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				int id = resultSet.getInt(1);
				return id;
			}
		} catch (Exception e) {
			System.out.println("UserSgl getActionId xetasi....");
		}
		return -1;
	}
	////////////////////////
	public boolean   isAccessForAction(int roleId, int actionId){
		try(Connection connection =instance.getConnection()) {
		       PreparedStatement preparedStatement = connection.prepareStatement("Select id form ayaz.role_action where role_id=? and action_id=?");
			   preparedStatement.setInt(1, roleId);
			   preparedStatement.setInt(2, actionId);
			   
			   ResultSet resultSet = preparedStatement.executeQuery();
			   if(resultSet.next()){
				   int id = resultSet.getInt(1);
				   if(id>0){
					   return true;
				   }
			   }
		} catch (SQLException e) {
			System.out.println("UserSgl isAccessForAction xetasi... ");
		}
		return false;
		
	}
	
	// Save
	public void save(User user){
		try(Connection connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name,surname,mail,password,confirmation_code,imagepath) values(?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getConfirmation_code());
			preparedStatement.setString(6, user.getImagePath());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("User save xetasi...");
			e.printStackTrace();
		}
	}
		

	
	
	

}
