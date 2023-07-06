package com.hib.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.FactoryConnection;
import com.hib.Student;
import org.mindrot.jbcrypt.BCrypt;
/**
 * Servlet implementation class servletLogin
 */
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletLogin() {
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
		// TODO Auto-generated method stub
		doGet(request, response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform authentication against database
        
        boolean isAuthenticated = authenticateUser(username, password);

        if (isAuthenticated) {
            // Set session attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to home page
            response.sendRedirect("home.jsp");
        } else {
            // Show login error message
        	request.getSession().setAttribute("loginErrorMessage", "Invalid username or password");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        }
    }

    private boolean authenticateUser(String username, String password) {
        // Perform authentication against database using Hibernate
        try {
            // Load Hibernate configuration and create session factory
        	FactoryConnection fact=new FactoryConnection();
        	
    		Session session =fact.getfactory().openSession();
            Transaction transaction = session.beginTransaction();
//
//            // Create HQL query to retrieve user with matching username and password
//            String hql = "FROM Student WHERE username=:username";
//            Query query = session.createQuery(hql);
//            query.setParameter("username", username);
//            query.setParameter("password", password);
//
//            // Execute query and check if a result is returned
//            Student user = (Student) query.uniqueResult();
//            if (user != null) {
//                return true; // Authentication successful
//            } else {
//                return false; // Authentication failed
//            }
            
            Student user = session.createQuery("FROM Student WHERE username = :username", Student.class)
                    .setParameter("username", username)
                    .getSingleResult();
            System.out.println("password :"+password+""+"Encry password :"+ user.getPassword());
            boolean flag=BCrypt.checkpw(password, user.getPassword());
            System.out.println(flag);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Authentication failed due to an error
        }
    }

	

}
