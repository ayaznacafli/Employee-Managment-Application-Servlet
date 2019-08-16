/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HTML;

import JavaClass.MD5PasswordHash;
import MySql.EmployeSql;
import MySql.UserSql;
import Pojo.Employe;
import Pojo.User;
import java.util.List;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Test {
	public static void main(String[] args) {
		EmployeSql employeSql  = new EmployeSql();
		List<Employe> em = employeSql.Search("Aygun");
		System.out.println(em);
	}

}
