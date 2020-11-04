<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>${wine.labelName}, ${wine.vintageYear}.</title>
</head>
<body>
 <hr>
   <div class ="container">

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="homePage.do" style="color:DarkRed"><strong>WineNot</strong> <i class='fas fa-wine-glass' style='font-size:24px'></i></a>
			<img src="https://www.wvv.com/assets/client/Image/WVV-Estate-VistiUsPage.jpg" style="width:200px;height:200px;">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="homePage.do">Home <i class='fas fa-home'></i><span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="createUserForm.do">Log In <i class='fas fa-sign-in-alt'></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="checkout.do?customerOrderId=1#">Order Wine <i class='fas fa-shopping-cart'></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="wineList.do">Wine Cellar <i class='fas fa-wine-glass' style='font-size:18px;color:red'></i></a>
					</li>
					
					<li class="nav-item">
						<a class="nav-link" href="updateUserForm.do?id=1#">Account Profile <i class='fas fa-address-card'></i></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="favoritesList.do?id=1#">Favorites List <i class='fas fa-list-alt'></i></a>
					</li>
						<li class="nav-item">
						<a class="nav-link" href="logOutOfAccount.do">Log Out<i class='fas fa-list-alt'></i></a>
					</li>
			
				</ul>
			
			</div>
		</nav>
		<hr>
    <img src="${wine.image}" alt="${wine.labelName} ${wine.vineyard} ${wine.vintageYear}" style="width:128px;height:256px;">
	<!-- Replace style size limits with CSS -->
	<p>
	<ul>
		<li><strong>Label Name: </strong>${wine.labelName}</li>
		<li><strong>Vineyard: </strong>${wine.vineyard}</li>
		<li><strong>Vintage Year: </strong>${wine.vintageYear}</li>
		<li><strong>Color: </strong>${wine.wineColor.wineColor}</li>
		<li><strong>Type: </strong>${wine.wineType.wineType}</li>
		<li><strong>Flavor: </strong>${wine.flavor}</li>
		<li><strong>Dietary: </strong>${wine.dietary}</li>
		<li><strong>Description: </strong>${wine.description}</li>
		<li><strong>Pairs with: </strong>${wine.pairs}</li>
		<li><strong>Review: </strong>${review.review}</li>
		
		<p>
		<%-- <form action="addWineToOrder.do" method="GET">
			<input type="hidden" name="id" value="${custOrder.id}"/>
			<input type="hidden" name="wine" value="${wine}"/>
			<button type="submit">Add To Cart</button>
		</form> --%>
		<c:choose>
		<c:when test = "${customer != null }">
		<form action="addToFavoritesList.do" method="GET">
			<input type="hidden" name="id" value="${customer.id}"/>
			<input type="hidden" name="wid" value="${wine.id}"/>
			<button type="submit">Add To Favorites!</button>
			
		</form>
		<form action="addAReview.do" method="GET">
			<input type="hidden" name="custId" value="${customer.id}"/>
			<input type="hidden" name="wineId" value="${wine.id}"/>
			<button type="submit">Review this wine.</button>
		</form>
		</c:when>					 
		<c:otherwise>
		<form action="checkCredentials.do" method="GET">
			<button name="logIn" type="submit">Please LogIn</button>
		</form>
		</c:otherwise>
			
			
		</c:choose>
		
		</p>
	</ul>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>
</body>
</html>