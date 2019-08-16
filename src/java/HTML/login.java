/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import Pojo.City;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class login extends HttpServlet {

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
		out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Login</title>");
			out.println("<link href=\"css/insert.css\" rel=\"stylesheet\" type=\"text/css\">");
			out.println("</head>");
			out.println("<body>");
			
		          out.println("<div>"); 
			out.println("<form  action=loginServlet  method=post>");
			
		
			//  Username
			out.println("<label for=\"username\">Username:</label>");
			out.println("<input type=\"text\" id=\"ad\" name=\"txtemail\" placeholder=\"Username ve ya Mail..\">");
			
		
			
			// Username
			out.println(" <label for=\"password\">Password:</label>");
			out.println("<input type=\"password\" id=\"password\" name=\"txtpassword\" placeholder=\"Password..\">");
			
			
			
			
			
			out.println("<input type=\"submit\" value=\"Login\"  name=\"btnLogin\">");
			out.println("<input type=\"submit\" value=\"Cancel\" style=background:red name=\"btnCancel\">");
			
			
			out.println("</form>");
			out.println("</div>");
			
			out.println("</body>");
			out.println("</html>");
			
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
