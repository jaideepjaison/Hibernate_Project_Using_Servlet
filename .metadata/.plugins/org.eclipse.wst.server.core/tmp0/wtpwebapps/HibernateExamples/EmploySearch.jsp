<%@page import="com.java.hib.Employ"%>
<%@page import="com.java.hib.EmployDAO"%>
<%@page import="com.java.hib.SessionHelper"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="EmploySearch.jsp">
		Employ No : 
		<input type="number" name="empno" /> <br/><br/>
		<input type="submit" value="Search" /> <br/><Br/>
	</form>
	<%
		if (request.getParameter("empno") !=null) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			Employ employ = new EmployDAO().searchEmploy(empno);
			if (employ!=null) {
				out.println("Employ Name  " +employ.getName() + "<br/>");
				out.println("Gender  " +employ.getGender() + "<Br/>");
				out.println("Department   " +employ.getDept() + "<Br/>");
				out.println("Designation  " +employ.getDesig() + "<br/>");
				out.println("Basic   " +employ.getBasic() + "<Br/>");
			} else {
				out.println("Record Not Found  ");
			}
		}
	%>
</body>
</html>