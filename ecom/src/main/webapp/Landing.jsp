<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Shoping</title>
<%@ include file="header.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container">
		<div class="card-header m-3">All Products</div>

		<div class="row">

			<div class="row">

				<c:forEach var="product" items="${AllproductList}">

					<div class="col-md-3 my-3">

						<div class="card w-100">
							<img class="card-img-top"
								src="pictures/${product.getImage()}" alt="Card image cap">
							<div class="card-body">
								<h4 class="card-title">${product.getName()}</h4>
								<h5 class="price">Price: ${product.getPrice()}</h5>
								<h5 class="category">Category: ${product.getCategory()}</h5>
								<div class="mt-3 d-flex justify-content-between">
									<a class="btn btn-dark"
										href="CartServlet?id=${product.getId()}">Add to Cart</a> 
										<a class="btn btn-primary"
										href="./ProductMainBUYservlet?quantity=1&id=${product.getId()}">Buy Now</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
        </div>

pId, uId, quantity
<%@ include file="footer.jsp"%>
</body>
</html>