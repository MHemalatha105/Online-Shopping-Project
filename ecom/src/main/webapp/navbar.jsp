
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<nav class="navbar navbar-expand-lg navbar-light bg-info">
	<div class="container">
		<a class="navbar-brand" href="#">Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
			
			
                   
                   <c:if test="${user!=null}">
				<li class="nav-item"><a class="nav-link link-success" href="./Landing.jsp">Home</a></li>
			
				
				<li class="nav-item"><a class="nav-link link-success" href="CheckoutServlet">Cart
						<span class="nav-cart-icon nav-sprite badge rounded-pill bg-danger ">${oldCartList.size() }</span></a></li>
			
				
				<li class="nav-item"><a class="nav-link link-success" href="orders.jsp">Orders</a></li>
			
			
				<li class="nav-item"><a class="nav-link link-success" href="./LogoutServlet">Logout</a></li>

				 </c:if>
				 <c:if test="${user==null}">
				<li class="nav-item"><a class="nav-link link-success" href="Signup.jsp">Signup</a></li>
				 </c:if>
				<c:if test="${user==null}">
				
				<li class="nav-item"><a class="nav-link link-success" href="Login.jsp">Login</a></li>
                   </c:if>
				<c:if test="${user!=null}">
				<li class="nav-item"><a class="nav-link link-success" href="#"> Welcome..   <span>${user.getName()}</span></a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>