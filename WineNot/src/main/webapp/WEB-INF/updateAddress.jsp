<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
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
<title>Update Address Information</title>
</head>
<body>
	<hr>
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
		<!-- 			<li class="nav-item active"><a class="nav-link"
						href="homePage.do">Home <i class='fas fa-home'></i><span
							class="sr-only">(current)</span></a></li> -->
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
		
<<<<<<< HEAD
<%-- 		<c:choose>
=======
		<%-- <c:choose>
>>>>>>> 09225f0e132277414774c183c33b518b8bbaa487
		<c:when test="${! empty payInfo}">
		<ul>
				<li><strong>Street: </strong>${payInfo.address.street}</li>
				<li><strong>City: </strong>${payInfo.address.city}</li>
				<li><strong>State: </strong>${payInfo.address.state}</li>
				<li><strong>Zip: </strong>${payInfo.address.zip}</li>
				<li><strong>Country: </strong>${payInfo.address.country}</li>
		</ul>
				
				
			
		</c:when>
		<c:otherwise>
		<p>No payment Info found.</p>
		</c:otherwise>
<<<<<<< HEAD
	</c:choose> 
 --%>		
=======
	</c:choose>  --%>
		
>>>>>>> 09225f0e132277414774c183c33b518b8bbaa487

	
		<hr>
<!-- FIX SUBMIT BUTTON FOR UPDATE ADDRESS. -->
<h1>Update Address:</h1>
<hr>
	<form action="updateAddressInfo.do" method="POST">
	<input type="hidden" value="${address.id}">
		<table>
			
			<tr>
			<td>Street: ${address.street }</td>
			<td><input type= "text" name="street" value="${address.street}"/></td>
			</tr>
			
			<tr>
			<td>Street2: ${address.street2 }</td>
			<td><input type= "text" name="street2" value="${address.street2 }"/></td>
			</tr>
			
			<tr>
			<td>City: ${address.city }</td> 
		 	<td><input type= "text" name="city" value="${address.city }"/></td>
			</tr>
			
			 <tr>
			 <td>State: ${address.state }</td>
			<td><input type= "text" name="state" value="${address.state }"/></td>
			</tr>
			
			<tr>
			<td>Zip Code: ${address.zip }</td>
			<td><input type= "text" name="zip" value="${address.zip }"/><td>
			</tr>
			
			<tr>
			<td>Country: ${address.country}</td>
			<td><input type= "text" name="country" value="${address.country }"/></td>
			</tr>
			
			<button type= "submit">Update Address</button>
			<!-- </tr><br><br>  -->
			</table> 
			</form>
			
			    
			<form>

<<<<<<< HEAD

							
							 <%-- 	<td><form action="getUpdatedReviewOfWines.do">
						<input type="hidden" name="custId"
								value="${review.id.customerId}" /> <input type="hidden"
								name="wineId" value="${review.id.wineId}" />
											
					<button type="submit">Update Review of Wine</button>
				</form></td>  --%>
<%-- 
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
				</form></td> --%>




	<ul class="navbar-nav mr-auto">
=======
<!-- 	<ul class="navbar-nav mr-auto">
>>>>>>> 09225f0e132277414774c183c33b518b8bbaa487
		<li class="nav-item">
			<a class="nav-link" href="deleteAddressForm.do">Delete Address</a>
		</li>
	</ul>
<<<<<<< HEAD
</form>
			<%--  <form action="deleteAddressForm.do">
					<input type="hidden" name="custId"
						   value="${address.address}" />
						   <input type="hidden"
						   name="address" value="${address.address}" />
					<button type="submit">Delete Address</button>
				</form> --%>
=======
</form> -->
			 
			</table> 
>>>>>>> 09225f0e132277414774c183c33b518b8bbaa487

	
			<!-- <tr>
			<td><button type= "submit">Update Address</button></td>
			</tr> -->
			 
<<<<<<< HEAD
=======
		</table>
	</form>
<br>
<br>
>>>>>>> 09225f0e132277414774c183c33b518b8bbaa487
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>