/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import JavaClass.MD5PasswordHash;
import Mail.EmailConfing;
import MySql.UserSql;
import Pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class registrServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			if(request.getParameter("btnSave")!=null){
			
			User user = new User();
			
			String name=request.getParameter("txtname");
			String surname=request.getParameter("txtsurname");
			String  mail=request.getParameter("txtmail");
			String password=request.getParameter("txtpassword");
			String repeatpassword= request.getParameter("txtrepeatpassword");
			String ConfirmationCode = UUID.randomUUID().toString();
			
			//mail=MD5PasswordHash.MD5(mail);
			
			if(password!=null && password.equals(repeatpassword)){
				
			// Send Email
			String urlForEmail="<a href=http://localhost:18080/Employe/ConfirmationRegistr?ConfirmationCode="+ConfirmationCode+">Confirm Registr</a>";
			EmailConfing confing = new EmailConfing();
			String text="Zehmet olmasa hesabinizi dogrulayin:</br>"+urlForEmail;
				try {	
					confing.sendMail(mail, "Email Confirmation", text);
				} catch (MessagingException ex) {
					System.out.println("RegistrServlet ConfirmationCode xetasi.....");
				}
				
                     
				// Shifreleme
			          ConfirmationCode = MD5PasswordHash.MD5(ConfirmationCode);	
				password = MD5PasswordHash.MD5(password);
				
				// Save
				user.setName(name);
				user.setSurname(surname);
				user.setEmail(mail);
				user.setPassword(password);
				user.setConfirmation_code(ConfirmationCode);
				
				UserSql userSql = new UserSql();
				userSql.save(user);
				
				response.sendRedirect("login");
				
				
			}else{
				response.sendRedirect("registr");
			}
			
			}else{
				response.sendRedirect("home");
			}
			
		}
	}
	

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
