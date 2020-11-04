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
<title>Add a Wine</title>
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
	</div>
	<div class="container-fluid">
	
	<form action="adminAddWine.do">
	<div class="form-group">
	<label for="name">Label name</label>
	<input type="text" id="name" name="labelName" required>
	</div>
	<div class="form-group">
	<label for="origin">Origin/Vineyard</label>
	<input type="text" id="origin" name="vineyard">
	</div>
	<div class="form-group">
	<label for="year">Year</label>
	<input type="text" id="year" name="vintageYear" required>
	</div>
	<div class="form-group">
	<label for="flav">Flavor</label>
	<input type="text" id="flav" name="flavor" required>
	</div>
	<div class="form-group">
	<label for="diet">Dietary</label>
	<input type="text" id="diet" name="dietary">
	</div>
	<div class="form-group">
	<label for="desc">Description</label>
	<input type="text" id="desc" name="description" required>
	</div>
	<div class="form-group">
	<label for="img">Image</label>
	<input type="text" id="img" name="image">
	</div>
	<div class="form-group">
	<label for="pair">Food Pairing</label>
	<input type="text" id="pair" name="pairs">
	</div>
	<div class="form-group">
	<label for="type">Type</label>
		<select name="wineTypeId" id="type" required>
			<option value="1" id="id">1. Bordeaux</option>
			<option value="2">2. Cabernet</option>
			<option value="3">3. Chardonnay</option>
			<option value="4">4. Malbec</option>
			<option value="5">5. Merlot</option>
			<option value="6">6. Moscato</option>
			<option value="7">7. Pinot Grigio</option>
			<option value="8">8. Pinot Noir</option>
			<option value="9">9. Port</option>
			<option value="10">10. Red Blend</option>
			<option value="11">11. Riesling</option>
			<option value="12">12. Rose</option>
			<option value="13">13. Rosso</option>
			<option value="14">14. Sangria</option>
			<option value="15">15. Sauvignon Blanc</option>
			<option value="16">16. Sparkling</option>
			<option value="17">17. Syrah</option>
			<option value="18">18. Zinfandel</option>
			<option value="19">19. Sangiovese</option>
		</select>
	</div>
	<div class="form-group">
	<label for="color">Color</label>
		<select name="wineColorId" id="color" required>
			<option value="1">1. Red</option>
			<option value="2">2. White</option>
			<option value="3">3. Rose</option>
		</select>
	</div>
	<input type="hidden" value="1" name="enabled">
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	
	</div>
		
		
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</body>
</html>