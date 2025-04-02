<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserSignUp</title>
<%@ include file="header.jsp"%>
</head>
<body>

<%@ include file="navbar.jsp"%>
<h1 class="display-4 text-center text-success">Please Signup</h1>
<div class="container card card-body mt-5 w-50">

		<form action="./UserServlet" method="post">
<div class="mb-3">
    <label for="Name" class="form-label" >Name</label>
    <input type="text" class="form-control" id="Name" name="Name">
    
  </div>
  <div class="mb-3">
    <label for="EmailId" class="form-label">EmailId</label>
    <input type="email" class="form-control" id="EmailId" name="EmailId">
    
  </div>
  <div class="mb-3">
    <label for="MobileNo" class="form-label">MobileNo</label>
    <input type="number" class="form-control" id="MobileNo" name="MobileNo">
    
    <div class="mb-3">
    <label for="Password" class="form-label">Password</label>
    <input type="password" class="form-control" id="Password" name="Password">
  </div>
  
  </div>
  <div class="mb-3">
    <label for="Address" class="form-label">Address</label>
    <input type="text" class="form-control" id="Address" name="Address">
    
  </div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<%@ include file="footer.jsp"%>
</body>
</html>