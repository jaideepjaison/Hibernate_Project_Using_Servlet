package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUPDBServlet
 */
public class SignUPDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUPDBServlet() {
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
		PrintWriter pw=response.getWriter();
		try {
			Connection con=ConectionHelper.getConnection();
			String cmd="Insert into users (username,password) values (?,?)";
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setString(1, request.getParameter("user"));
			pst.setString(2, request.getParameter("pass"));
			pst.executeUpdate();
			pw.println("Inserted");
		}
	catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		pw.println("<p style='color:red';>SOMETHING WENT WRONG</p>");
	}
			
	}

}