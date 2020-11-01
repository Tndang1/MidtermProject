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
<title>${wine.labelName}, ${wine.vintageYear}.</title>
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
						<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Link</a>
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
    <img src="${wine.image}" alt="${wine.labelName} ${wine.vineyard} ${wine.vintageYear}" style="width:128px;height:256px;">
	<!-- Replace style size limits with CSS -->
	<p>
	<ul>
		<li>${wine.labelName}</li>
		<li>${wine.vineyard}</li>
		<li>${wine.vintageYear}</li>
		<li>${wine.wineColor.wineColor}</li>
		<li>${wine.wineType.wineType}</li>
		<li>${wine.flavor}</li>
		<li>${wine.dietary}</li>
		<li>${wine.description}</li>
		<li>${wine.pairs}</li>
		<li>${review.review}</li>
		<p>
		<form action="addWineToOrder.do" method="GET">
			<input type="hidden" name="id" value="${custOrder.id}"/>
			<input type="hidden" name="wine" value="${wine}"/>
			<button type="submit">Add To Cart</button>
		</form>
		<form action="addWineToFavorites.do" method="GET">
			<input type="hidden" name="customerId" value="${customer.id}"/>
			<input type="hidden" name="wine" value="${wine}"/>
			<button type="submit">Add To Favorites!</button>
		</form>
		</p>
	</ul>
</body>
</html>