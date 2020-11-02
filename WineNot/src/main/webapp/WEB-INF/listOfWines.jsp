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
	
<title>List Of Wines</title>

</head>
<body>
 <hr>
     <div class ="container">

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="homePage.do"style="color:DarkRed"><strong>WineNot</strong> <i class='fas fa-wine-glass' style='font-size:24px'></i></a>
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
			
				</ul>
			
			</div>
		</nav>
		<hr>
    <form action="findWineName.do" method="GET" class="form-inline my-2 my-lg-0">  
					Wine Name: <input type="text" name="labelName"class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
   <!--  <form action="findWineType.do" method="GET" class="form-inline my-2 my-lg-0">
					 <input type="text" name="id"class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
    <form action="findWineType.do" method="GET" class="form-inline my-2 my-lg-0">
				<label for="id">Wine Type:</label>
				<select name="id" id="id">
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
			<!-- <input type="text" name="id"class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">  -->
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
    
    
   <!--  <form action="findWineColor.do" method="GET" class="form-inline my-2 my-lg-0">
					Wine Color: <input type="text" name="id"class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form> -->
				
    <form action="findWineColor.do" method="GET" class="form-inline my-2 my-lg-0">
    	<label for="id">Wine Color:</label>
				<select name="id" id="id">
				<option value="1">1. Red</option>
				<option value="2">2. White</option>
				<option value="3">3. Rose</option>
				</select>
					<!-- Wine Color: <input type="text" name="id"class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"> -->
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				 
				 

				 
				 
				 
				<hr>
<h1>Wine Searched:</h1>

<div class="container-fluid">
<table>
<c:forEach items="${wine }" var="wines">
<tr>
<td>${wines.id }</td>
<td><a href="getWine.do?wid=${wines.id }">${wines.labelName }</a></td>
</tr>
</c:forEach>
</table>
<br>
	<!-- <p>
			<a href="homePage.do" class="btn btn-primary" role="button">Back
				to Home</a>
		</p> -->
		<br>







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