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
    <a class="btn btn-primary btn-lg" href="createNewAccount.do" role="button">Sign Up</a>
    <a class="btn btn-primary btn-lg btn-block" href="createNewAccount.do" role="button">Sign Up</a>
   
    <!-- <a class="btn btn-primary btn-lg" href="createNewAccount.do" role="button">Sign Up</a>
   <button href="createNewAccount.do"type="button" class="btn btn-primary btn-lg btn-block">Sign Up</button> -->
    
    </div>
    <hr>
    
    <h1 style="color:DarkRed"><center>WineNot   <img src="https://images.crateandbarrel.com/is/image/Crate/HipRedWine31ozSHF15/$web_pdp_main_carousel_high$/190411135118/hip-red-wine-glass.jpg" alt="wine glass" style="width:200px;height:200px;"></center>
    </h1> 
    
    <hr>
  
				
    <div class="jumbotron">
  <h1 class="display-4">Hello, WineNot Lovers!</h1>
  <p class="lead">Our website is catered to the wine lovers/enthusiasts and those who want to learn more about wine! 
  				Here at WineNot, we provide a monthly subscription of 6 to 12 different style wines. 
  				You are able to choose the color of wine and we will randomly pick the perfect style of wines for your liking.
  				We have hand picked only the finest wines in the world for you to try! After you place your order, you will receive 
  				our selected wines for you at your doorstep! After you have tried our beautiful wines, don't forget to come back to the website
  				and give the wine a rating! You can also see others ratings of that wine as well! You are able to update your reviews as needed. Don't forget
  				you can also add these wines to your MyFavorites list for future orders.  
  				</p>
  				<p>
  				This one of kind service saves you the hassle of aimlessly walking up and down the aisle of the Wine Store not knowing what kind of wine you should try. 
  				At WineNot you are able to see a full details page of each of the wines that includes the vineyard, vintage year, flavor, pairs with, and so much more! 
  				This also provides you with a unique experience of getting to try different styles of wine but still being able to choose the color of wine you prefer. 
  				As you continue to order your monthly wines, each delivery is unique and is a mystery as to what style of wines you will get. 
  				It is like waking up on Christmas morning, to open up your package to see what the Wine Fairies have delivered! 
  				</p>
  				<p>
  				Here at WineNot we pride ourselves in the very best customization of wines for our customers to try. 
  				This also saves our customers time and money on the best product we can provide for them! 
  				So don't wait! Go ahead and click on the "Sign Up" button above and start your next monthly wine subscription delivery! 
  				
  				We promise you, YOU WON'T REGRET IT!
  				
  				</p>
  <hr class="my-4">
  <p>To see our full list of wines and reviews click on the Learn More button below!</p>
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