package org.br.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BRServlet
 */
@WebServlet("/BRServlet")
public class BRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB BRSessionBean 	brSessionBean;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering BRServlet doGet");
		
		PrintWriter pw = response.getWriter();
		pw.println(brSessionBean.method());
		
		System.out.println("Exiting BRServlet doGet");
	}
}
