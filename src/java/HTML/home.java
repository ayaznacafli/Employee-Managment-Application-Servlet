/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import MySql.EmployeSql;
import Pojo.Employe;
import Pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class home extends HttpServlet {

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
			EmployeSql employeSql = new EmployeSql();
			List<Employe> employe = employeSql.findAll();
			
			HttpSession session = request.getSession();
			User user=(User) session.getAttribute("user");
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Employes</title>");	
			// CSS
			out.println("<link href=\"css/table.css\" rel=\"stylesheet\" type=\"text/css\">");
			out.println("<link href=\"css/search.css\" rel=\"stylesheet\" type=\"text/css\">");
			out.println("<link href=\"css/menu.css\" rel=\"stylesheet\" type=\"text/css\">");
			// JS
			out.println("<script src=\"js/jquery.min.js\"></script>");
			out.println("<script src=\"js/search.js\"></script>");
			
			out.println("</head>");
			out.println("<body>");
			
			
			// MENU
			out.println("<ul>");
			out.println("<li><a href=\"#home\">Home</a></li>");
			out.println("<li><a href=\"#news\">News</a></li>");
			out.println("<li><a href=\"#contact\">Contact</a></li>");
			out.println("<li><a href=\"#about\">About</a></li>");
			if(user==null){
			out.println("<li style=\"float:right\"><a href=\"login\"  >Sign In</a></li>");
			out.println("<li style=\"float:right\"><a href=\"registr\">Sign Up</a></li>");
			}else{
				out.println("<li style=\"float:right\"><a href=\"\">"+user.getEmail()+"</a></li>");
				out.println("<li style=\"float:right\"><a href=\"safe/logout\">Logout</a></li>");
			}
			
			out.println("</ul>");
			
			// Search
                             out.println("<input type=\"text\"  id=\"search\"  name=\"txtsearch\"  placeholder=\"Search..\">");
                           //  out.println("<input type=hidden name=hidden id=hidden/>");
			
			out.println("`<div class=\"container\">");
			out.println("<form  action=\"safe/elaveEt\"  method=post>");
			out.println("<table>");
			
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
			out.println("<td> <a href=\"safe/duzenle?id="+employes.getId()+"\">Duzenle</a>");
			out.println(" <a href=\"safe/sil?id="+employes.getId()+"\">Sil</a></td>");
			out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			
			out.println("<input type=\"submit\" value=\"Elave Et\"  name=\"btnElaveEt\">");
			
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
