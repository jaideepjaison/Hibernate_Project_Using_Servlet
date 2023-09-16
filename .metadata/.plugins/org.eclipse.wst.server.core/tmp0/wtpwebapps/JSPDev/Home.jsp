<%@page import="infinite.JSPDev.Person"%>
<%@page import="infinite.JSPDev.PersonDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<%
	PersonDAO dao=new PersonDAO();
	Person[] arrPerson=dao.showPersonData();
	String status=request.getParameter("status");
	
	%>
	
	<%
	if(status!=null)
	{
		%>
		<script>
		swal("Good job!", "You clicked the button!", "success");
		</script>
		<% 
	}
	%>
	<table align="center" style="padding: 20px" class="table table-hover">
		<tr>
			<th>SSN</th>
			<th>ID</th>
			<th>Person Name</th>
			<th>DOB</th>
			<th>gender</th>
			<th>UPDATE</th>
			<th>DELETE</th>
	    </tr>
	    
	    <%
	    	for(Person ps: arrPerson)
	    	{
	    %>
	    <tr>
	    <th><%= ps.getSsn() %></th>
	    <th><%= ps.getId() %></th>
	    <th><%= ps.getPersonname() %></th>
	    <th><%= ps.getDob() %></th>
	    <th><%= ps.getGender() %></th>
	    <th><a href="updateperson.jsp?ssn=<%= ps.getSsn() %>" class="btn btn-info">UPDATE</a> </th>
	    <th><a href="deleteperson.jsp?ssn=<%= ps.getSsn() %>" class="btn btn-danger">DELETE</a> </th>
	    
	    </tr>
	    <%
	    	}
	    %>
	</table>
	<a href="adddata.jsp" type="submit">ADD DATA</a>
</body>
</html>