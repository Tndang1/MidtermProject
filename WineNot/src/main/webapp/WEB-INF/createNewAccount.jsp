<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Create A New Account</title>
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
		
		<form>
		<div class="container">
		<h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
   <%--  <hr>
      <table>
			<tr>Username: <td>${user.username }</td> <form action= "createCustomer.do">
			${user.username }
			<input type= "text" name="firstName" value="${user.username }"/>
			<button type= "submit">First Name</button>
			</form></tr>
			<tr>Email: <td>${user.email }</td> <form action= "createEmail.do">
			${user.username }
			<input type= "text" name="email" value="${user.email }"/>
			<button type= "submit">Enter Email</button>
			</form></tr>
			<tr>Password: <td>${user.password }</td> <form action= "createPasswordForm.do">
			${user.password }
			<input type= "text" name="pass" value="${user.password }"/>
			<button type= "submit">Create Password</button>
			</form></tr><br><br>  
			 --%>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputFName">First Name</label>
      <input type="firstName" class="form-control" id="inputFName" placeholder="FirstName">
    </div>
    <div class="form-group col-md-6">
      <label for="inputLName">Last Name</label>
      <input type="lastName" class="form-control" id="inputLName" placeholder="LastName">
    </div>
    <div class="form-group col-md-6">
      <label for="inputBirthdate">Date of Birth</label>
      <input type="text" class="form-control" id="inputBirthdate" placeholder="MM/DD/YYYY">
    
    </div>
    
    
    
    
    <div class="form-group col-md-6">
      <label for="inputEmail">Email</label>
      <input type="email" class="form-control" id="inputEmail">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword">Password</label>
      <input type="text" class="form-control" id="inputPassword">
    </div>
    <div class="form-group">
    <label for="inputAddress">Address</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  <div class="form-group">
    <label for="inputAddress2">Address 2</label>
    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
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
    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
  
</form>

</body>
</html>