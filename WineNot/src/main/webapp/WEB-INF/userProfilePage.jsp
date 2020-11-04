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
<title>User Profile</title>
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
	<!-- 				<li class="nav-item active">
						<a class="nav-link" href="homePage.do">Home <i class='fas fa-home'></i><span class="sr-only">(current)</span></a>
					</li> -->
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
		<h1>User Account Profile</h1>
		<hr>
		<nav class="navbar navbar-expand-lg navbar-light bg-light"><h5>User Information</h5></nav>
		<p>
		<table>
		<tr>
			<td>Username: ${user.username}</td> 
			<td>
				<form action= "updateUsernameForm.do">
				<input type= "text" name="username" value="${user.username }"/>
				<button type= "submit">Change Username</button><br>
				</form>
			</td>
		</tr>
		<tr>
			<td>Email: ${user.email}</td> 
			<td><form action= "updateEmailForm.do">
			<input type= "text" name="email" value="${user.email }"/>
			<button type= "submit">Change Email</button><br>
			</form>
			</td>
		</tr>
		<tr>
			<td>Password: ${user.password }</td>
			<td><form action= "updatePasswordForm.do">
			<input type= "text" name="pass" value="${user.password } "/>
			<button type= "submit">Change Password</button>
			</form></tr><br><br>

			<form action ="createAddressForm.do"></form>
		
		<form>
		<nav class="navbar navbar-expand-lg navbar-light bg-light"></t>Payment Information</nav></form><br>
			
			</form>
			</td>
		</tr>
</table>

<hr>
			

<br><br>	

		
		<form>
		<nav class="navbar navbar-expand-lg navbar-light bg-light"></t>Payment Information</nav></form><br>

  <c:choose>
  <c:when test="${! empty customer.paymentInfo}">
  <ul>
  <li><strong>Card Number: </strong>${customer.paymentInfo.cardNumber}</li>
  <li><strong>Expiration Date: </strong>${customer.paymentInfo.exprDate}</li>
  </ul>
  </c:when>
  <c:otherwise>
  <p>No payment information found</p>
  </c:otherwise>
  </c:choose>
  
</form>

<c:choose>
<c:when test="${! empty address}">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">Address Information</nav><br>
  <ul>
  <li><strong>Street: </strong>${address.street }</li>
  <li><strong>Street2: </strong>${address.street2 }</li>
  <li><strong>City: </strong>${address.city }</li>
  <li><strong>State: </strong>${address.state }</li>
  <li><strong>Zip: </strong>${address.zip }</li>
  <li><strong>Country: </strong>${address.country }</li>
  </ul>
</form>
  <%-- <div class="form-group">
    <label for="inputAddress">Street</label>
    <input type="text" class="form-control" name="inputAddress" value="${address.street }">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Street 2</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="${address.street2 }">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control">
        <option selected>Choose...</option>
        <option>...</option>
      </select>
    </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" id="inputZip">
    </div>
  </div>
  <div class="form-group">
  </div> --%>

</c:when>
<c:otherwise>
<nav class="navbar navbar-expand-lg navbar-light bg-light">No Address Information Found</nav><br>
</c:otherwise>
</c:choose>

<hr>
<form>
<ul class="navbar-nav mr-auto">

	<li class="nav-item">
		<a class="nav-link" href="listAllCustomerOrders.do">Order History</a>
	</li>
	<li class="nav-item">
		<a class="nav-link" href="getAllReviews.do">Past Reviews</a> 
	</li>
<li class="nav-item">
		<a class="nav-link" href="createAddressForm.do">Create Address</a> 
		
	</li>
 <li class="nav-item">
		<a class="nav-link" href="updateAddressForm.do">Update Address</a> 
		
	</li>
		<li class="nav-item">
		<a class="nav-link" href="createPaymentInfoForm.do">Payment Info</a>
	</li>

</ul>
</form>

<form>

	<ul class="navbar-nav mr-auto">
		<li class="nav-item">
			<a class="nav-link" href="deleteUser.do">Delete Account</a>
		</li>
	</ul>
</form>
<hr>
	</div>
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