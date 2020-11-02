<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
h3 {text-align: center;}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>

	<hr>
	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">LOGO HERE</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a href="homePage.do" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>&nbsp;&nbsp;&nbsp;
					<li class="nav-item"><a href="ContactPage.jsp"> Contact us
					</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
		<div class="text-center">
			<img src="https://content.codecademy.com/courses/freelance-1/unit-2/explorer.jpeg" />
			<!-- #Imageid img{
			max-width: 72%;
			max-height: 22%;
			} -->
		</div>
		<hr>
		<nav class="navbar navbar-expand-lg navbar-light bg-light"><h5>User Information</h5></nav>
		<p>
		<table>
			<tr>Username: <td>${user.username }</td> <form action= "updateUsernameForm.do">
			${user.username }
			<input type= "text" name="username" value="${user.username }"/>
			<button type= "submit">Change Username</button>
			</form></tr>
			<tr>Email: <td>${user.email }</td> <form action= "updateEmailForm.do">
			${user.username }
			<input type= "text" name="email" value="${user.email }"/>
			<button type= "submit">Change Email</button>
			</form></tr>
			<tr>Password: <td>${user.password }</td> <form action= "updatePasswordForm.do">
			${user.password }
			<input type= "hidden" name="pass" value="${user.password }"/>
			<button type= "submit">Change Password</button>
			</form></tr><br><br>
			
			
		
		<form>
		<nav class="navbar navbar-expand-lg navbar-light bg-light"></t>Payment Information</nav><br>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputFirstName4">First Name</label>
      <input type="firstName" class="form-control" id="inputFirstName4" placeholder="FirstName">
    </div>
    <div class="form-group col-md-6">
      <label for="inputLastName4">Last Name</label>
      <input type="lastName" class="form-control" id="inputLastName4" placeholder="LastName">
    </div>
  </div>
  <div class="form-group">
    <label for="inputCardNumber">Card Number</label>
    <input type="text" class="form-control" id="inputCardNumber" placeholder="XXXX XXXX XXXX XXXX">
  </div>
  <div class="form-group">
    <label for="inputExprDate">Expiration Date</label>
    <input type="text" class="form-control" id="inputExprDate" placeholder="00/00">
  </div>
  <div class="form-group">
  </div>
</form>
		
		<br>
		<br>
		

			<form>
			<nav class="navbar navbar-expand-lg navbar-light bg-light"></t>Address Information</nav><br>
  <div class="form-row">
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
  </div>
  <div class="form-group">
  </div>
</form>


<form>
<ul class="navbar-nav mr-auto">

	<li class="nav-item">
		<a class="nav-link" href="favoritesList.do?id=1#">Favorites List</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" href="listAllCustomerOrders.do?id=1#">Order History</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" href="createReviewForm.do?id=1#">Past Reviews</a> <!-- Unsure of this -->
	</li>

</ul>
</form>
<form>
	<ul class="navbar-nav mr-auto">

		<li class="nav-item">
			<a class="nav-link" href="deleteUser.do?id=1#">Delete Account</a>
		</li>
	</ul>
</form>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
			integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
			integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
			crossorigin="anonymous"></script>
</body>
</html>