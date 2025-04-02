<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OnlineShoping</title>
<%@ include file="header.jsp"%>

</head>
<body>

<%@ include file="navbar.jsp"%>


<div class="container my-3">
		<div class="d-flex py-5">
			<h3>
				Total Price:  <span>${toatlPrice}</span>
			</h3>
			<a class="mx-3 btn btn-primary" href="./CheckoutAllProducts">Check Out</a>
		</div>


		<table class="table table-light">
			<thead>
				<tr>
					<td scope="col">Name</td>
					<td scope="col">Category</td>
					<td scope="col">Price</td>
					<td scope="col">Buy Now</td>
					<td scope="col">Cancel</td>
				</tr>
			</thead>
			<tbody>


				<c:forEach var="product" items="${oldCartList}">
<tr>
						<td>${product.getName()}</td>
						<td>${product.getCategory()}</td>
						<td>${product.getPrice()}</td>
						<td>${product.getQuantity()}</td>
						
						
						
						<td>
							<form action="./OrderServlet" method="post" class="form-inline">
								<input type="hidden" name="id" value="${product.getId()}"
									class="form-input">
								<div class="form-group d-flex justify-content-between">
									<a class="btn bnt-sm btn-incre"
										href="IndAndDecServlet?Action=inc&id=${product.getId()}">
										
										 <i class="fas fa-plus-square"></i> </a> 
										<input type="text"name="quantity" class="form-control"
										value="${product.getQuantity()}" readonly>
										
										<c:if test="${product.getQuantity()>1}">
										 <a class="btn btn-sm btn-decre"
										href="IndAndDecServlet?Action=dec&id=${product.getId()}">
										
										<i class="fas fa-minus-square"></i> </a>
										</c:if>
								</div>
								<button type="submit" class="btn btn-primary btn-sm">Buy</button>
							</form>
						</td>


						<td><a href="./RemoveProductServlet?id=${product.getId()}"
							class="btn btn-sm btn-danger">Remove</a></td>
					</tr>
				</c:forEach>
	</tbody>
	
	</table>

<%@ include file="footer.jsp"%>
</body>
</html>