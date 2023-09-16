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

import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class LoginDBServlet
 */
public class LoginDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDBServlet() {
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
		String user,pass;
		PrintWriter pw=response.getWriter();
		try {
			Connection con=ConectionHelper.getConnection();
			String cmd="select count(*) cnt from users where username=? and password=?";
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setString(1, request.getParameter("user"));
			pst.setString(2, request.getParameter("pass"));
			ResultSet rs=pst.executeQuery();
			rs.next();
			int cnt=rs.getInt("cnt");
			if(cnt==1)
			{
				pw.println("DONE LOGIN");
			}
			else
			{
				pw.println("SOME thing went wrong");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
