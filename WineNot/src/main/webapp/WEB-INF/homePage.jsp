<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Home Page</title>
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
						<a class="nav-link" href="createUserForm.do">Log In</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="checkout.do?customerOrderId=1#">Order Wine</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="wineList.do">Wine Cellar</a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link" href="updateUserForm.do?id=1#">Account Profile</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="favoritesList.do?id=1#">Favorites List</a>
					</li>
			
				</ul>
			
			</div>
		</nav>
		<hr>
		  <div>
    <a class="btn btn-primary btn-lg" href="wineList.do" role="button">Sign Up</a>
    </div>
    <hr>
    <h1>WineNot </h1> 
    <hr>
  
				
    <div class="jumbotron">
  <h1 class="display-4">Hello, Wine Lovers!</h1>
  <p class="lead">This is where we will have the description of our website!</p>
  <hr class="my-4">
  <p>give more details here.</p>
  <a class="btn btn-primary btn-lg" href="wineList.do" role="button">Learn more</a>
</div>
    <p>
    
    </p>
    
    <hr>
   
 

      
   <hr> 
<span class="byline">CREATED BY: Thomas Dang, Tevon Patterson, Justin Livingston, and Jourdan Rentschler</span>
	  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
  </div>
</body>
</html>