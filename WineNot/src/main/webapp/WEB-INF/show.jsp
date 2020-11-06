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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>${wine.labelName}, ${wine.vintageYear}.</title>
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
	<!-- Replace style size limits with CSS -->
	<p>
    <img src="${wine.image}" alt="${wine.labelName} ${wine.vineyard} ${wine.vintageYear}" class="wine-img">
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
		<c:if test="${review.review != null}">
		<li><strong>Review: </strong>${review.review}</li>
		</c:if>
		</ul>
		<%-- <form action="addWineToOrder.do" method="GET">
			<input type="hidden" name="id" value="${custOrder.id}"/>
			<input type="hidden" name="wine" value="${wine}"/>
			<button type="submit">Add To Cart</button>
		</form> --%>
<c:choose>
	<c:when test = "${customer != null}">
			<c:choose>
				<c:when test = "${favorited}">
					<strong>This wine is in your favorites list!</strong>
				</c:when>
				<c:otherwise>
					<form action="addToFavoritesList.do" method="GET">
					<input type="hidden" name="id" value="${customer.id}"/>
					<input type="hidden" name="wid" value="${wine.id}"/>
					<button type="submit" class="btn btn-primary">Add To Favorites</button>
					</form><br>
				</c:otherwise>
			</c:choose>
			<c:choose>
					<c:when test = "${reviewed == false}">
					<form action="addAReview.do" method="GET">
					<input type="hidden" name="custId" value="${customer.id}"/>
					<input type="hidden" name="wineId" value="${wine.id}"/>
					<button type="submit" class="btn btn-dark">Review this wine</button>
					</form>
					</c:when>
					<c:otherwise>
					<form action="getUpdatedReviewOfWines.do" method="GET">
					<input type="hidden" name="custId" value="${customer.id}"/>
					<input type="hidden" name="wineId" value="${wine.id}"/>
					<button type="submit" class="btn btn-success">Update your review?</button>
					</form>			
					</c:otherwise>
			</c:choose>	
	</c:when>		 
	<c:otherwise>
		<form action="checkCredentials.do" method="GET">
		<button name="logIn" type="submit" class="btn btn-danger">Please LogIn</button>
		</form>
	</c:otherwise>
</c:choose>
	</ul>
	<br>
	
<ul class="pager">
    <li class="previous">
    <form action="getPreviousWine.do">
    <button class="previous_button" type="submit" name="wid" value="${wine.id}"> Previous </button>
    </form>
    </li>
    <li class="next">
     <form action="getNextWine.do">
    <button class="next_button" type="submit" name="wid" value="${wine.id}">  Next  </button>
    </form>
    </li>
 </ul>
	
	</div>
	
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