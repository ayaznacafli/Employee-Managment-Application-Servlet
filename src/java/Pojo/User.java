/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pojo;

import javax.xml.crypto.Data;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class User {
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private int status;
	private String confirmation_code;
	private Data registrData;
	private int roleId;
	private String imagePath;

	public User() {
	}

	public User(int id, String name, String surname, String email, String password, int status, String confirmation_code, Data registrData, int roleId, String imagePath) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.status = status;
		this.confirmation_code = confirmation_code;
		this.registrData = registrData;
		this.roleId = roleId;
		this.imagePath = imagePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getConfirmation_code() {
		return confirmation_code;
	}

	public void setConfirmation_code(String confirmation_code) {
		this.confirmation_code = confirmation_code;
	}

	public Data getRegistrData() {
		return registrData;
	}

	public void setRegistrData(Data registrData) {
		this.registrData = registrData;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Users{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password + ", status=" + status + ", confirmation_code=" + confirmation_code + ", registrData=" + registrData + ", roleId=" + roleId + ", imagePath=" + imagePath + '}';
	}
	

}
