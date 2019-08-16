/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import MySql.CitySql;
import MySql.EmployeSql;
import Pojo.City;
import Pojo.Employe;
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
public class duzenle extends HttpServlet {

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
			EmployeSql employeSql = new EmployeSql();
			if(request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
			Employe employe = employeSql.findById(id);
			
			
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
                             out.println("<form  action=\"../duzenleServlet\"  method=post>");			
		
		// Id
		out.println("<input type=\"hidden\" name=\"txtid\"  value=\""+employe.getId()+"\">");	
			
			//  Ad
			out.println("<label for=\"ad\">Ad:</label>");
			out.println("<input type=\"text\" id=\"ad\" name=\"txtad\"  value=\""+employe.getAd()+"\" placeholder=\"Adiniz\">");
			
			// Soyad
			out.println(" <label for=\"soyad\">Soyad:</label>");
			out.println("<input type=\"text\" id=\"soyad\" name=\"txtsoyad\" value=\""+employe.getSoyad()+"\" placeholder=\"Soyadiniz\">");
			
			// Ata adi
			out.println(" <label for=\"ataadi\">Ata adi:</label>");
			out.println("<input type=\"text\" id=\"ataadi\" name=\"txtataadi\" value=\""+employe.getAta_adi()+"\" placeholder=\"Ata Adiniz\">");
			
			// Maas
			out.println(" <label for=\"maas\">Maas:</label>");
			out.println("<input type=\"text\" id=\"maas\" name=\"txtmaas\"  value=\""+employe.getMaas()+"\" placeholder=\"Maas\">");
			
			// Mail
			out.println(" <label for=\"mail\">Mail:</label>");
			out.println("<input type=\"text\" id=\"mail\" name=\"txtmail\"  value=\""+employe.getMail()+"\" placeholder=\"Mail\">");
			
			// Tel
			out.println(" <label for=\"tel\">Tel:</label>");
			out.println("<input type=\"text\" id=\"tel\" name=\"txttel\"  value=\""+employe.getTel()+"\" placeholder=\"Tel\">");
			
			//Seher
			out.println("<label for=\"seher\">Region:</label>");
			out.println("<select id=\"region\" name=\"txtregion\">");
			
			for(City citys:city){
				
			if(citys.getId()==employe.getCity_id()){
				
			out.println("<option selected value=\""+citys.getId()+"\">"+citys.getCityname()+"</option>");	
			}else
			out.println("<option value=\""+citys.getId()+"\">"+citys.getCityname()+"</option>");
			}
			out.println(" </select>");
			
			
			
			
			
			
			
			
			
			
			out.println("<input type=\"submit\" value=\"Save\"  name=\"btnSave\">");
			out.println("<input type=\"submit\" value=\"Cancel\" style=background:red name=\"btnCancel\">");
			
			out.println("</form>");
			out.println("</div>");
			
			
			out.println("</body>");
			out.println("</html>");
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
