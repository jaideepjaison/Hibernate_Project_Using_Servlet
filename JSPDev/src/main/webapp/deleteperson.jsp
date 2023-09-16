<%@page import="infinite.JSPDev.Person"%>
<%@page import="infinite.JSPDev.PersonDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<%
		if(request.getParameter("ssn")!=null){
		int ssn=Integer.parseInt(request.getParameter("ssn"));
		PersonDAO dao=new PersonDAO();
		Person ps=new Person();
		dao.deletePerson(ssn);
		
		%>
		<jsp:forward page="Home.jsp"></jsp:forward>
		<% 
		}
	%>
</body>
</html>