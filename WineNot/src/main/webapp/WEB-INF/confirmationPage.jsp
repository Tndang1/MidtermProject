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
<title>Confirmation Page</title>
</head>
<body>

	<hr>
	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">Navigation Bar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="homePage.do">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="checkout.do?customerOrderId=1#">Order Wine</a></li>
					<li class="nav-item"><a class="nav-link" href="wineList.do">Wine
							Cellar</a></li>
					<li class="nav-item"><a class="nav-link"
						href="createUserForm.do">Log In</a></li>

					<li class="nav-item"><a class="nav-link"
						href="updateUserForm.do?id=1#">Account Profile</a></li>
					<li class="nav-item"><a class="nav-link"
						href="favoritesList.do?id=1#">Favorites List</a></li>

					<!-- 	<li class="nav-item">
						<a class="nav-link disabled" href="#">Disabled</a>
					</li> -->
				</ul>
				<!-- 	<form action="findWineName.do" method="GET">Search By Wine Name: <input type="text" name="labelName"/>
					<input type = "submit" value="Wine Name"/>
				</form> -->
				<!--  class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
			</div>
		</nav>
		<form class="form-inline">
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
		</form>
		<hr>
		<h1>WineNot</h1>
		<form action="findWineName.do" method="GET">
			Search By Wine Name: <input type="text" name="labelName" /> <input
				type="submit" value="Wine Name" />

		</form>
		<hr>
		
		<!-- End of Navbar  -->
		
		<!-- Need to stub out more details. Have to link customer order controller to link to confirmation jsp.  -->
		
		<h3>Confirmation Details</h3>
		<c:choose>
			<c:when test="">
				<ul>
				<li>Customer Order Id</li>
				<li>Customer Order Date</li>
				<li>Customer Order Amount</li>
				<li>Customer Order Size</li>
				<li>Customer Payment Date</li>
				</ul>
			</c:when>		
		</c:choose>
		
		
</body>
</html>