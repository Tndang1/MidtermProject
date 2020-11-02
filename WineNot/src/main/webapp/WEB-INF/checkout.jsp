<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Confirm Order and Checkout</title>
</head>
<body>

    <hr>
    <div class ="container">

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Navigation Bar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="homePage.do">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="checkout.do">Order Wine</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="wineList.do">Wine Cellar</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Contact me at
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="https://www.linkedin.com/in/jourdan-rentschler-b16b4a13b" target="_blank">LinkedIn Profile</a>
							<a class="dropdown-item" href="JOURDAN RENTSCHLER - Resume_PersonalPortfolio.pdf" target="_blank">Resume</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</li>
					<li class="nav-item">
						<a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
    <hr>
	Items in cart
	<ul>
		<c:forEach items="${wines}" var="wine">
			<li>
			<form action="removeWineFromCheckout.do" method="GET">
			${wine.labelName}, ${wine.vineyard }. ${wine.vintageYear}
				<input type="hidden" name="customerOrderId" value="${custOrder.id}"/>
				<input type="hidden" name="wineId" value="${wine.id}"/>
				<button type="submit">Remove From Cart</button>
			</form>
			</li>
		</c:forEach>
	</ul>
	<p>
	<table>
	<tr>
	<th>Shipping Details</th>
	<th>Billing Address</th>
	</tr>
	<tr>
	<td>${customerAddress.street} ${customerAddress.street2}</td>
	<td>${paymentInfo.address.street} ${paymentInfo.address.street2}</td>
	</tr>
	<tr>
	<td>${customerAddress.city}, ${customerAddress.state}</td>
	<td>${paymentInfo.address.city}, ${paymentInfo.address.state}</td>
	</tr>
	<tr>
	<td>${customerAddress.zip}</td>
	<td>${paymentInfo.address.zip}</td>
	</tr>
	<tr>
	<td>${customerAddress.country}</td>
	<td>${paymentInfo.address.country}</td>
	</tr>
	</table>
	</p>
	<p>
	Payment Info<br>
	${paymentInfo.cardNumber}<br>
	Expiration Date: ${paymentInfo.exprDate.month} ${paymentInfo.exprDate.year}
	<br>
	Total: ${custOrder.amount}
	</p>
	
<form action="orderMade.do">
<!--   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Password</label>
      <input type="password" class="form-control" id="inputPassword4">
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Address 2</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control">
        <option selected>Choose...</option>
        <option>...</option>
      </select>
    </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" id="inputZip">
    </div>
  </div> -->
  <button type="submit" class="btn btn-primary">Check me out!</button>
</form>
	
	  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	
</body>
</html>