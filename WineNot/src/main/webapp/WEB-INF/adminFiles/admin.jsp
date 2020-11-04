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
<title>Administrative Controls</title>
</head>
<body>
 <hr>
    <div class ="container-fluid">

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="homePage.do"style="color:DarkRed"><strong>WineNot</strong> <i class='fas fa-wine-glass' style='font-size:24px'></i></a>
			<img src="https://images.squarespace-cdn.com/content/v1/5cf129c75bf4f50001c8b2f3/1588283318954-X25V1XW9WC42W3F8PHMJ/ke17ZwdGBToddI8pDm48kG0sXzLG2I85QyZp8ZpOahl7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0vIHRucUU7a1Vci15HXS8HIyFOUrT9_OnKWFj0z76vvMsMQu7p6EAYImZh1X2UKwEQ/r1.jpg?format=1500w" style="width:200px;height:200px;">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
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
		<h2><center>Welcome Money Maker!</center></h2>
		<hr>
		<h6>Please selection an option:</h6>
		<table>
		<ul>
		<li><form action="adminWineList.do"><button type="submit" class="btn btn-danger btn-lg">See all Wines <i class='fas fa-wine-glass' style='font-size:18px;'></i></button></form></li><br>
		<li><form action="adminReviewList.do"><button type="submit" class="btn btn-danger btn-lg">See all Reviews <i class='fas fa-list-alt'></i></button></form></li><br>
		<li><form action="adminUserList.do"><button type="submit" class="btn btn-danger btn-lg">See all Users <i class='fas fa-address-card'></i></button></form></li><br>
		<li><form action="adminWineForm.do"><button type="submit" class="btn btn-danger btn-lg">Add a wine <i class='fas fa-wine-glass' style='font-size:18px;'></i></button></form></li><br>
		</ul>
		</table>
		<hr>
		
		
<%-- 		<h6><center>List of Wines:</center></h6> --%>
<table class="table">
<c:if test="${wineResults != null}">
		<c:forEach items="${wineResults}" var="wine">
		<tr>
			<td>${wine.id}</td><td>${wine.labelName}</td><td>${wine.vineyard}</td><td><c:choose><c:when test="${wine.enabled == 1}">Enabled</c:when><c:otherwise>Disabled</c:otherwise></c:choose></td>
			<td><form action="adminUpdateWineForm.do"><input type="hidden" name="wineId" value="${wine.id}"><button type="submit" class="btn btn-success btn-sm">Update this wine.</button></form></td>
			<td><c:choose><c:when test="${wine.enabled == 1}">
			<form action="adminDisableWine.do"><input type="hidden" name="wineId" value="${wine.id}"><button type="submit" class="btn btn-danger btn-sm">Disable this wine.</button></form>
			</c:when><c:otherwise>
			<form action="adminEnableWine.do"><input type="hidden" name="wineId" value="${wine.id}"><button type="submit" class="btn btn-primary btn-sm">Enable this wine.</button></form>
			</c:otherwise></c:choose></td>
		</tr>
		</c:forEach>
</c:if>
		
<c:if test="${userResults != null}">
		<c:forEach items="${userResults}" var="user">
		<tr>
			<td>${user.id}</td><td>${user.email}</td><td>${user.password}</td><td><c:choose><c:when test="${user.enabled == 1}">Enabled</c:when><c:otherwise>Disabled</c:otherwise></c:choose></td>
			<td><form action="adminUpdateUserForm.do"><input type ="hidden" name="userId" value="${user.id}"><button type="submit">Update this user.</button></form>
			<td><c:choose><c:when test="${user.enabled == 1}">
			<form action="adminDisableUser.do"><input type="hidden" name="userId" value="${user.id}"><button type="submit">Disable this user.</button></form>
			</c:when><c:otherwise>
			<form action="adminEnableUser.do"><input type="hidden" name="userId" value="${user.id}"><button type="submit">Enable this user.</button></form>
			</c:otherwise></c:choose></td>
		</tr>
		</c:forEach>
</c:if>
		
<c:if test="${reviewResults != null}">
		<c:forEach items="${reviewResults}" var="review">
		<tr>
			<td>Customer Id:${review.id.customerId}</td><td>Wine Id:${review.id.wineId}</td><td>${review.review}</td><td>${review.rating}</td>
			<td><form action="adminUpdateReviewForm.do">			
			<input type ="hidden" name="custId" value="${review.id.customerId}">
			<input type ="hidden" name="wineId" value="${review.id.wineId}">
			<button type="submit">Update this review.</button></form>
			<td><form action="adminDeleteReview.do">
			<input type="hidden" name="custId" value="${review.id.customerId}">
			<input type="hidden" name="wineId" value="${review.id.wineId}">
			<button type="submit">Delete this review.</button></form>
		</tr>
		</c:forEach>
</c:if>
</table>
</div>		
		
		
		
		
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>