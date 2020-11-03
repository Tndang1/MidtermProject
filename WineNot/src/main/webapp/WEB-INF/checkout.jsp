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
<title>Confirm Order and Checkout</title>
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
			
				</ul>
			
			</div>
		</nav>
		<hr>

		<!-- ===================== End of Navbar =================== -->

		<strong>Wine Order</strong>

		<form action="create.do" method="POST">
			<div class="form-check"> Flavor of Wine: <br> 
				<input type="hidden" value="1" name="custId">
				<input class="form-check-input" type="checkbox" value="1" id="id" name = "wineColor"> 
				<label class="form-check-label" for="id"> Red </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="2" id="id" name = "wineColor">
				<label class="form-check-label" for="id"> White </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="3" id="id" name = "wineColor">
				<label class="form-check-label" for="id"> Rose </label>
			</div>
			<br>
			<!-- End of Flavors of wine -->
			

				<!-- <div class="form-check">
					Type of Wine: <br> <input class="form-check-input"
						type="checkbox" value="1" id="id"> <label
						class="form-check-label" for="id"> Bordeaux </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="2" id="id">
					<label class="form-check-label" for="id"> Cabernet </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="3" id="id">
					<label class="form-check-label" for="id"> Chardonnay </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="4" id="id">
					<label class="form-check-label" for="id"> Malbec </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="5" id="id">
					<label class="form-check-label" for="id"> Merlot </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="6" id="id">
					<label class="form-check-label" for="id"> Moscato </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="7" id="id">
					<label class="form-check-label" for="id"> Pinot Grigio </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="8" id="id">
					<label class="form-check-label" for="id"> Pinot Noir </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="9" id="id">
					<label class="form-check-label" for="id"> Port </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="10" id="id">
					<label class="form-check-label" for="id"> Red Blend </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="11" id="id">
					<label class="form-check-label" for="id"> Riesling </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="12" id="id">
					<label class="form-check-label" for="id"> Rose </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="13" id="id">
					<label class="form-check-label" for="id"> Rosso </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="14" id="id">
					<label class="form-check-label" for="id"> Sangria </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="15" id="id">
					<label class="form-check-label" for="id"> Sauvignon Blanc </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="16" id="id">
					<label class="form-check-label" for="id"> Sparkling </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="17" id="id">
					<label class="form-check-label" for="id"> Syrah </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="18" id="id">
					<label class="form-check-label" for="id"> Zinfandel </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="19" id="id">
					<label class="form-check-label" for="id"> Sangiovese </label>
				</div> <br>
	 -->
			<!-- End of checkboxes for type of wine -->
			
			<div class="form-check">Quantity: <br> 
				<input type ="hidden" value="129.99" name ="amount"> 
				<input class="form-check-input" type="checkbox" value="6" id="id" name = "size"> 
				
				<label class="form-check-label" for="id"> 6 <strong>Amount: $129.99</strong> </label> 
			</div>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="12" id="id" name = "size">
				<label class="form-check-label" for="id"> 12 <strong>Amount: $220.99</strong> </label>
			</div>

		
	


		<!-- Old code for list of wines in cart. -->
		<%-- 	<ul> 
		<c:forEach items="${wines}" var="wine">
			<li>
			<form action="removeWineFromCheckout.do" method="GET">
			${wine.labelName}, ${wine.vineyard }. ${wine.vintageYear}
				<input type="hidden" name="customerOrderId" value="${custOrder.id}"/>
				<input type="hidden" name="wineId" value="${wine.id}"/>
				<button type="submit">Remove From Cart</button>
			</form>
			</li>
		</c:forEach>
--%>
	
<!-- 		<form>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Email</label> <input type="email"
						class="form-control" id="inputEmail4">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Password</label> <input type="password"
						class="form-control" id="inputPassword4">
				</div>
			</div>
			<div class="form-group">
				<label for="inputAddress">Address</label> <input type="text"
					class="form-control" id="inputAddress" placeholder="1234 Main St">
			</div>
			<div class="form-group">
				<label for="inputAddress2">Address 2</label> <input type="text"
					class="form-control" id="inputAddress2"
					placeholder="Apartment, studio, or floor">
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">City</label> <input type="text"
						class="form-control" id="inputCity">
				</div>
				<div class="form-group col-md-4">
					<label for="inputState">State</label> <select id="inputState"
						class="form-control">
						<option selected>Choose...</option>
						<option>...</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<label for="inputZip">Zip</label> <input type="text"
						class="form-control" id="inputZip">
				</div>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> Check me
						out </label>
				</div>
			</div> -->
		<!-- 	<button type="submit" class="btn btn-primary">Sign in</button> -->
			
			 <br>
				<input class="btn btn-primary" type="submit" value="Add to Cart">
				<!-- <div><a href="createAddressForm.do" ></a></div> -->
		</form>
		
			<p>
		<table>
			<tr>
				<th>Shipping Details</th>
				<th>Billing Address</th>
			</tr>
			<tr>
				<td>${customerAddress.street}${customerAddress.street2}</td>
				<td>${paymentInfo.address.street}
					${paymentInfo.address.street2}</td>
			</tr>
			<tr>
				<td>${customerAddress.city}, ${customerAddress.state}</td>
				<td>${paymentInfo.address.city}, ${paymentInfo.address.state}</td>
			</tr>
			<tr>
				<td>${customerAddress.zip}</td>
				<td>${paymentInfo.address.zip}</td>
			</tr>
			<tr>
				<td>${customerAddress.country}</td>
				<td>${paymentInfo.address.country}</td>
			</tr>
		</table>
		</p>
		<p>
			Payment Info<br> ${paymentInfo.cardNumber}<br> Expiration
			Date: ${paymentInfo.exprDate.month} ${paymentInfo.exprDate.year} <br>
		</p>
		

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