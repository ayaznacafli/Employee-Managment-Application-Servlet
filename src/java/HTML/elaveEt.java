/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import MySql.CitySql;
import Pojo.City;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class elaveEt extends HttpServlet {

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
			/* TODO output your page here. You may use following sample code. */
			CitySql citySql = new CitySql();
			List<City> city = citySql.findAllCity();
			
		          out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet insert</title>");
			out.println("<link href=\"../css/insert.css\" rel=\"stylesheet\" type=\"text/css\">");
			
			out.println("</head>");
			out.println("<body>");
			
			out.println("<div>"); 
			out.println("<form  action=\"../elaveEtServlet\"  method=post>");
			
		
			//  Ad
			out.println("<label for=\"ad\">Ad:</label>");
			out.println("<input type=\"text\" id=\"ad\" name=\"txtad\" placeholder=\"Adiniz..\">");
			
			// Surname
			out.println(" <label for=\"soyad\">Soyad:</label>");
			out.println("<input type=\"text\" id=\"soyad\" name=\"txtsoyad\" placeholder=\"Soyadiniz..\">");
			
			// Username
			out.println(" <label for=\"ataadi\">Ata adi:</label>");
			out.println("<input type=\"text\" id=\"ataadi\" name=\"txtataadi\" placeholder=\"Ata adiniz..\">");
			
			// Password
			out.println(" <label for=\"maas\">Maas:</label>");
			out.println("<input type=\"text\" id=\"maas\" name=\"txtmaas\" placeholder=\"Maas..\">");
			
			// Mail
			out.println(" <label for=\"mail\">Mail:</label>");
			out.println("<input type=\"text\" id=\"mail\" name=\"txtmail\" placeholder=\"Mail..\">");
			
			// Tel
			out.println(" <label for=\"tel\">Tel:</label>");
			out.println("<input type=\"text\" id=\"tel\" name=\"txttel\" placeholder=\"tel..\">");
			
			//Seher
			
			out.println("<label for=\"seher\">Region:</label>");
			
			out.println("<select id=\"region\" name=\"txtregion\">");
			for(City citys:city){
			out.println("<option value=\""+citys.getId()+"\">"+citys.getCityname()+"</option>");
			}
			out.println(" </select>");
			
			
			// Tevellud
			//out.println(" <label for=\"tevellud\">Tevellud:</label>");
			//out.println("<input type=\"date\" id=\"tevellud\" name=\"tevellud\"");
                           // out.println("value=\"2018-07-22\""); 
                           // out.println("min=\"1920-01-01\" max=\"2020-12-31\">");   
			
			
			
			
			out.println("<input type=\"submit\" value=\"Save\"  name=\"btnSave\">");
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
