package com.hib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.connection.FactoryConnection;
import com.hib.Student;

/**
 * Servlet implementation class servletRegister
 */
public class servletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		// TODO Auto-generated method stub
		try {
		String name=request.getParameter("name");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String pass=request.getParameter("pasword");
		System.out.println("name :"+name+"email :"+email+"  pass :"+pass);
		String encryptedPassword =BCrypt.hashpw(pass, BCrypt.gensalt());
		Student su=new Student( name, username, email, encryptedPassword);
    	FactoryConnection fact=new FactoryConnection();
    	
		Session session =fact.getfactory().openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(su);
		tx.commit();
		session.close();
		request.getSession().setAttribute("InsertMessage", "Registration successful. Please log in.");
		response.sendRedirect("Login.jsp");
		}
		catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("InsertMessage", "NOT Saved to Database");
			e.printStackTrace();
		}
	}

}
