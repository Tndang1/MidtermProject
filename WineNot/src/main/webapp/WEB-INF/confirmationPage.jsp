<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Confirmation Page</title>
</head>
<body>
<hr>
    <div class ="container">

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="homePage.do"style="color:DarkRed"><strong>WineNot</strong> <i class='fas fa-wine-glass' style='font-size:24px'></i></a>
			<img src="https://images.squarespace-cdn.com/content/v1/5cf129c75bf4f50001c8b2f3/1588283318954-X25V1XW9WC42W3F8PHMJ/ke17ZwdGBToddI8pDm48kG0sXzLG2I85QyZp8ZpOahl7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0vIHRucUU7a1Vci15HXS8HIyFOUrT9_OnKWFj0z76vvMsMQu7p6EAYImZh1X2UKwEQ/r1.jpg?format=1500w" style="width:200px;height:200px;">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<!-- <li class="nav-item active">
						<a class="nav-link" href="homePage.do">Home <i class='fas fa-home'></i><span class="sr-only">(current)</span></a>
					</li> -->
					<c:if test="${customer == null}">
					<li class="nav-item">
						<a class="nav-link" href="createUserForm.do">Log In <i class='fas fa-sign-in-alt'></i></a>
					</li>
					</c:if>
					<li class="nav-item">
						<a class="nav-link" href="wineList.do">Wine Cellar <i class='fas fa-wine-glass' style='font-size:18px;color:red'></i></a>
					</li>
					<c:if test = "${customer != null}">
					<li class="nav-item">
						<a class="nav-link" href="checkout.do">Order Wine <i class='fas fa-shopping-cart'></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="updateUserForm.do">Account Profile <i class='fas fa-address-card'></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="favoritesList.do">Favorites List <i class='fas fa-list-alt'></i></a>
					</li>
					<c:if test = "${customer.user.role == 'admin'}">
					<li class="nav-item">
						<a class="nav-link" href="admin.do">Administrative Controls<i class='fas fa-list-alt'></i></a>
					</li>
					</c:if>
					<li class="nav-item">
						<a class="nav-link" href="logOutOfAccount.do">Log Out<i class='fas fa-list-alt'></i></a>
					</li>
					</c:if>
			
				</ul>
			
			</div>
		</nav>
		<hr>
<!-- 		<form class="form-inline">
			<div class="form-group mb-2">
				<label for="staticEmail2" class="sr-only">Email</label> <input
					type="text" readonly class="form-control-plaintext"
					id="staticEmail2" value="email@example.com">
			</div>
			<div class="form-group mx-sm-3 mb-2">
				<label for="inputPassword2" class="sr-only">Password</label> <input
					type="password" class="form-control" id="inputPassword2"
					placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary mb-2">Confirm
				identity</button>
		</form> -->
		<hr>
		<!-- <h1>WineNot</h1>
		<form action="findWineName.do" method="GET">
			Search By Wine Name: <input type="text" name="labelName" /> <input
				type="submit" value="Wine Name" />
		</form> -->
		<hr>
		
		<!-- End of Navbar  -->
		
		<!-- Need to stub out more details. Have to link customer order controller to link to confirmation jsp.  -->
		
		<h3>Confirmation Details</h3>
		<c:choose>
			<c:when test="${! empty order}">
				<ul>
				<li><strong>Customer Order Id: </strong>${order.id}</li>
				<li><strong>Customer Order Date: </strong><fmt:parseDate  value="${order.orderDate}"  type="date" pattern="yyyy-MM-dd'T'HH:mm:ss.SSS" var="parsedDate" /><fmt:formatDate type="both" value="${parsedDate}"/></li>		
				<li><strong>Customer Order Amount: $</strong>${order.amount}</li>
				<li><strong>Customer Order Size: </strong>${order.size}</li>
				</ul>
			</c:when>
			<c:otherwise>
			<p> No order found </p>
			</c:otherwise>		
		</c:choose>
		
		
		<h3>Shipping Details</h3>
			<c:choose>
			<c:when test="${! empty addressInfo}">
		<ul>
		<li><strong>Street: </strong>${addressInfo.street }</li>
		<li><strong>City: </strong>${addressInfo.city }</li>
		<li><strong>State: </strong>${addressInfo.state }</li>
		<li><strong>Zip: </strong>${addressInfo.zip }</li>
		<li><strong>Country: </strong>${addressInfo.country }</li>
		</ul>
			</c:when>
			<c:otherwise>
			<p> No Shipping Details Found</p>
			</c:otherwise>		
		</c:choose>
		
		<h3>Payment Details</h3>
			<c:choose>
			<c:when test="${! empty customer.paymentInfo}">
		<ul>
		<li><strong>Card Number: </strong>${customer.paymentInfo.cardNumber}</li>
		<li><strong>Expiration Date: </strong>${customer.paymentInfo.exprDate}</li>
		</ul>
			</c:when>
			<c:otherwise>
			<p> No Payment Details Found</p>
			</c:otherwise>		
		</c:choose>
		
	
</div>
		
	 <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>	

</body>
</html>