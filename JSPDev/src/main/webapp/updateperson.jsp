<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Connection"%>
<%@page import="infinite.JSPDev.ConnectionHelper"%>
<%@page import="infinite.JSPDev.PersonDAO"%>
<%@page import="infinite.JSPDev.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
		<%
		
		PersonDAO dao=new PersonDAO();
		int ssn=Integer.parseInt(request.getParameter("ssn"));
		Person ps=dao.searchEmploy(ssn);
		Person ps1=new Person();
		//int id=Integer.parseInt(request.getParameter("id"));
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String name=request.getParameter("name");
		//String dob=request.getParameter("dob");
		//java.sql.Date date2=new java.sql.Date(sdf.parse(dob).getTime());
		//String gender=request.getParameter("gender");
	%>
		
		

<form action="updateperson.jsp" align="center" style=" border-color: red; border-style: solid;" method="get">
		SSN:
		<input type="text" class="mt-2" name="ssn" value="<%= ssn %>">
		<br>
		ID:
		<input type="text" class="mt-2" value="<%= ps.getId() %>" name="id">
		<br>
		Name:
		<input type="text" class="mt-2" value="<%= ps.getPersonname() %>" name="name">
		<br>
		
		Gender:
		<input type="text" class="mt-2" value="<%= ps.getGender() %>" name="gender">
		<br>
		</br>
		<input type="submit" class="btn btn-success mt-4" value="Update">
	</form>
		
		<%
			if((request.getParameter("name")!=null))
			{
				
				ps1.setPersonname(request.getParameter("name"));
				ps1.setGender(request.getParameter("gender"));
				ps1.setSsn(Integer.parseInt(request.getParameter("ssn")));
				ps1.setId(Integer.parseInt(request.getParameter("id")));
				dao.UpdatePerson(ps1);
		
				%>
				<jsp:forward page="Home.jsp"></jsp:forward>
				<% 
			}
		%>
	
</body>
</html>