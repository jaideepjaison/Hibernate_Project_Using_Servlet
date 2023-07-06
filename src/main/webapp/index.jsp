<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration Page</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
  <form action="servletRegister" method="post">
    <div class="wrapper">
      <div class="form-wrapper">
        <h1>Create Account</h1>
        <form>
        <div class="form-group">
            <label for="username">Name</label>
            <input type="text" name="name" required />
          </div>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" name="username" required />
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="text" name="email" required />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="pasword"/>
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    </div>
    </form>
  </body>
</html>
