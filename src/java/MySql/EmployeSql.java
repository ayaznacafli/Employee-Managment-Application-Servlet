/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySql;

import Pojo.Employe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EmployeSql {
	
	private  SQLConnection instance = SQLConnection.getInstance();
	// Search
	public List<Employe> Search(String search){
		List<Employe> employe = new ArrayList<>();
		try(Connection  connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select e.id, e.ad,e.soyad,e.ata_adi,e.maas,e.mail,e.tel,c.cityname from ayaz.employe e "
					
+" inner join city c on c.idcity=e.city where e.ad like ? or e.soyad like ?");
			preparedStatement.setString(1, "%"+search+"%");
			preparedStatement.setString(2, "%"+search+"%");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				employe.add(new Employe(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getInt(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8)));
			}
			
		} catch (Exception e) {
			System.out.println("burda search problemi var");
			e.printStackTrace();
		}
		return employe;
	}
	// Update
	public void Update(Employe employe){
		try(Connection connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("Update employe set ad=?,soyad=?,ata_Adi=?,maas=?,mail=?,tel=?,city=? where id=?");
			preparedStatement.setString(1, employe.getAd());
			preparedStatement.setString(2, employe.getSoyad());
			preparedStatement.setString(3, employe.getAta_adi());
			preparedStatement.setInt(4, employe.getMaas());
			preparedStatement.setString(5, employe.getMail());
			preparedStatement.setString(6, employe.getTel());
			preparedStatement.setInt(7, employe.getCity_id());
			preparedStatement.setInt(8, employe.getId());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Update xetasi....");
		}
	}
	
	// Delete
	public void Delete(int id){
		try(Connection connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from employe where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Delete xetasi..");
		}
	}
	
	public Employe findById(int id){
		try(Connection connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employe where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Employe employe = new Employe(
					resultSet.getInt(1), 
					resultSet.getString(2), 
					resultSet.getString(3),
					resultSet.getString(4),
					resultSet.getInt(5),
					resultSet.getString(6), 
					resultSet.getString(7),
			                   resultSet.getInt(8));
		return employe;
			
		} catch (Exception e) {
			System.out.println("findById xetasii....");
		}
		return null;
	}
		

	//  Find ALl
	public List<Employe> findAll(){
		List<Employe> employe = new ArrayList<>();
		try(Connection connection = instance.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select e.id, e.ad, e.soyad, e.ata_adi, e.maas, e.mail, e.tel, c.cityname from ayaz.employe e inner join ayaz.city c on c.idcity=e.city");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				employe.add(new Employe(
						resultSet.getInt(1), 
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4), 
						resultSet.getInt(5), 
						resultSet.getString(6), 
						resultSet.getString(7),
						resultSet.getString(8)));
			}
		} catch (Exception e) {
		}
		return employe;
	}
	// INSERT
         public void insert(Employe employe){
			 try(Connection connection = instance.getConnection()) {
				 PreparedStatement preparedStatement = connection.prepareStatement("Insert into employe(ad,soyad,ata_adi,maas,mail,tel,city) value(?,?,?,?,?,?,?)");
			          preparedStatement.setString(1, employe.getAd());
				preparedStatement.setString(2, employe.getSoyad());
				preparedStatement.setString(3, employe.getAta_adi());
				preparedStatement.setInt(4, employe.getMaas());
				preparedStatement.setString(5, employe.getMail());
				preparedStatement.setString(6, employe.getTel());
				preparedStatement.setInt(7, employe.getCity_id());
				
				preparedStatement.executeUpdate();
			 } catch (Exception e) {
				 System.out.println("Insert xetasi..");
			 }
		 
         }
}
