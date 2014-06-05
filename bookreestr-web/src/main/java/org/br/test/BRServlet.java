package org.br.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bm.model.Person;
import org.bm.service.PersonInterface;

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
		
		
		PrintWriter pw = response.getWriter();
		pw.println(brSessionBean.method());
		
		
		
		InitialContext ic;
		try {
			ic = new InitialContext();
			PersonInterface  pi = (PersonInterface) ic.lookup("bookreestr/PersonBean/remote");
			
			List<Person> persons = pi.getPersons();
			System.out.println(persons.size());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
