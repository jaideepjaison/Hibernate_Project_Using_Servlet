<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="infinite.JSPDev.Person"%>
<%@page import="infinite.JSPDev.PersonDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		PersonDAO dao=new PersonDAO();
		Person ps=new Person();
		//Date newdate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	%>
<form action="adddata.jsp" align="center" style=" border-color: red; border-style: solid;" method="get">
		
		ID:
		<input type="text" class="mt-2" name="id">
		<br><br/>
		Name:
		<input type="text" class="mt-2"  name="name">
		<br>
		<br/>
		Gender:
		<input type="text" class="mt-2"  name="gender">
		<br><br/>
		Date:
		<input type="text" class="mt-2"  name="gender">
		<br>
		</br/>
		<input type="submit" class="btn btn-success mt-4" value="ADD">
	</form>
	<%
		if((request.getParameter("name")!=null))
		{
			ps.setId(Integer.parseInt(request.getParameter("id")));
			ps.setPersonname(request.getParameter("name"));
			ps.setGender(request.getParameter("gender"));
			String dob1=request.getParameter("dob");
			 //Date newdate=new java.util.Date(sdf.parse(dob).getTime());  
			 java.sql.Date date2=new java.sql.Date(sdf.parse(dob1).getTime());
			 ps.setDob(date2);
			String status = dao.insertdata(ps);
	%>
			<jsp:forward page="Home.jsp?<%= status %>"></jsp:forward>
			<% 
		}
	%>
	
</body>
</html>