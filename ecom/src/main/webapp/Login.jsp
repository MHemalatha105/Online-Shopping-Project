<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserLogIn</title>
<%@ include file="header.jsp"%>

</head>
<body>

<%@ include file="navbar.jsp"%>
<h1 class="display-4 text-center text-success">User Login</h1>
<div class="container card card-body mt-5 w-50">

		<form action="./User" method="post">
  <div class="mb-3">
    <label for="EmailId" class="form-label">EmailId</label>
    <input type="email" class="form-control" id="EmailId" name="EmailId">
    
  </div>
  <div class="mb-3">
    <label for="Password" class="form-label">Password</label>
    <input type="password" class="form-control" id="Password" name="Password">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


<%@ include file="footer.jsp"%>
</body>
</html>