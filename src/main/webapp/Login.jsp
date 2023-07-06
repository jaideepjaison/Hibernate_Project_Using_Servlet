<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Page</title>
    <link rel="stylesheet" href="style.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body>
  <!-- login.jsp -->

<%-- retrieve success message from session --%>
<%
String successMessage = (String) request.getSession().getAttribute("InsertMessage");
if (successMessage != null) {
%>
    <div class="alert alert-success" role="alert">
   <p><%=successMessage %></p>
</div>

<%
    // remove success message from session
    request.getSession().removeAttribute("successMessage");
}

String loginErrorMessage = (String) request.getSession().getAttribute("loginErrorMessage");
if (loginErrorMessage != null) {
%>
    <div class="alert alert-danger" role="alert">
   <p><%=loginErrorMessage %></p>
</div>

<%
    // remove success message from session
    request.getSession().removeAttribute("loginErrorMessage");
}
%>
<!-- login form here -->
  
  <form action="servletLogin" method="post">
    <div class="wrapper">
      <div class="form-wrapper">
        <h1>Login</h1>
        
        
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" name="username" required />
          </div>
         
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password"/>
          </div>
          <button type="submit">Log In</button>
        </form>
      </div>
    </div>
    
  </body>
</html>