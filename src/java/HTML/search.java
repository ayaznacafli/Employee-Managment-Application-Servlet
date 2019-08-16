/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import MySql.EmployeSql;
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
public class search extends HttpServlet {

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
			List<Employe>employe = null;
			
			if(request.getParameter("txtsearch")!=null){
			employe = employeSql.Search(request.getParameter("txtsearch"));
				
			
			
			// Search
                         
			out.println("<table id=\"costumers\">");
			
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>AD</th>");
			out.println("<th>SOYAD</th>");
			out.println("<th>ATA ADI</th>");
			out.println("<th>MAAS</th>");
			out.println("<th>MAIL</th>");
			out.println("<th>TEL</th>");
			out.println("<th>CITY</th>");
			out.println("<th>||||||||||</th>");
			out.println("</tr>");
			out.println("</thead>");
			
			out.println("<tbody>");
			
			for (Employe employes : employe) {
			out.println("<tr>");
			out.println("<td>"+employes.getId()+"</td>");
			out.println("<td>"+employes.getAd()+"</td>");
			out.println("<td>"+employes.getSoyad()+"</td>");
			out.println("<td>"+employes.getAta_adi()+"</td>");
			out.println("<td>"+employes.getMaas()+"</td>");
			out.println("<td>"+employes.getMail()+"</td>");
			out.println("<td>"+employes.getTel()+"</td>");
			out.println("<td>"+employes.getCity_name()+"</td>");
			out.println("<td> <a href=\"duzenle?id="+employes.getId()+"\">Duzenle</a>");
			out.println(" <a href=\"sil?id="+employes.getId()+"\">Sil</a></td>");
			out.println("</tr>");
			}
			out.println("</table>");
			
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
