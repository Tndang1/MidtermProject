<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<title>Past Reviews</title>
</head>
<body>
	<!-- <h1>User Reviews</h1>
	<hr> -->


	<div class="container-fluid">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="homePage.do" style="color: DarkRed"><strong>WineNot</strong>
				<i class='fas fa-wine-glass' style='font-size: 24px'></i></a> <img
				src="https://images.squarespace-cdn.com/content/v1/5cf129c75bf4f50001c8b2f3/1588283318954-X25V1XW9WC42W3F8PHMJ/ke17ZwdGBToddI8pDm48kG0sXzLG2I85QyZp8ZpOahl7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0vIHRucUU7a1Vci15HXS8HIyFOUrT9_OnKWFj0z76vvMsMQu7p6EAYImZh1X2UKwEQ/r1.jpg?format=1500w"
				style="width: 200px; height: 200px;">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="homePage.do">Home <i class='fas fa-home'></i><span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="createUserForm.do">Log In <i class='fas fa-sign-in-alt'></i></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="checkout.do?customerOrderId=1#">Order Wine <i
							class='fas fa-shopping-cart'></i></a></li>
					<li class="nav-item"><a class="nav-link" href="wineList.do">Wine
							Cellar <i class='fas fa-wine-glass'
							style='font-size: 18px; color: red'></i>
					</a></li>

					<li class="nav-item"><a class="nav-link"
						href="updateUserForm.do?id=1#">Account Profile <i
							class='fas fa-address-card'></i></a></li>
					<li class="nav-item"><a class="nav-link"
						href="favoritesList.do?id=1#">Favorites List <i
							class='fas fa-list-alt'></i></a></li>
				</ul>
			</div>
		</nav>


		<h1><center>User Reviews</center></h1>
	<hr>
		<hr>
		<h1>Your Reviews:</h1>

		<div class="container-fluid">
			<table>

			<!-- 	<ul> -->
				<%-- 	<c:forEach items="${reviews}" var="reviews">
						<li>${reviews.id } ${reviews.rating } ${reviews.review}</li> --%>

						<tr>
						<th>Image</th>
						<th>Wine Name</th>
						<th>Rating</th><br>
						<th>Review</th>
						</tr>
						<c:forEach items="${reviews}" var="review">
							<tr>
								<c:choose>
									<c:when test="${review.image != null}">
										<td><img src="${review.image}"
											alt="${review.wine.labelName}"
											style="width: 50px; height: 50px;">
											<!-- style="width: 50%; height: 50%;" -->
									</c:when>
									<c:otherwise>
										<td>No image uploaded! Link an image from imgur or
											similar!</td>
									</c:otherwise>
								</c:choose>
								<td><a href="getWine.do?wid=${review.wine.id}">${review.wine.labelName},
										${review.wine.vineyard}, ${review.wine.vintageYear}</a></td>
								
								<td>${review.rating}</td>
								<td>${review.review}</td>
								 <%-- <td>
									<form action="updateReviewReview.do">
										<input type="hidden" name="custId"
											value="${review.id.customerId}" /> <input type="hidden"
											name="wineId" value="${review.id.wineId}" /> <input
											type="text" name="reviewUpdate">
										<button type="submit">Update Review Content</button>
									</form>
									<form action="updateReviewRating.do">
										<input type="hidden" name="custId"
											value="${review.id.customerId}" /> <input type="hidden"
											name="wineId" value="${review.id.wineId}" /> <input
											type="number" name="rating">
										<button type="submit">Update Review Rating</button>
									</form>
									<form action="updateReviewImage.do">
										<input type="hidden" name="custId"
											value="${review.id.customerId}" /> <input type="hidden"
											name="wineId" value="${review.id.wineId}" /> <input
											type="text" name="image">
										<button type="submit">Update Review Image</button>
									</form>
								 </td>  --%>
								<td><form action="removeReview.do">
										<input type="hidden" name="custId"
											value="${review.id.customerId}" /> <input type="hidden"
											name="wineId" value="${review.id.wineId}" />
										<button type="submit">Delete Review</button>
									</form></td>
							
								<td><form action="getUpdatedReviewOfWines.do">
										<input type="hidden" name="custId"
											value="${review.id.customerId}" /> <input type="hidden"
											name="wineId" value="${review.id.wineId}" />
										<button type="submit">Update Review of Wine</button>
									</form></td>
							</tr>
						</c:forEach>
					
				<!-- </ul> -->
			</table>
		</div> 
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