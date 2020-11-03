<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address Information</title>
</head>
<body>

<p>
		<table>
			<tr>Username: <td>${user.username }</td> <form action= "updateUsernameForm.do">
			${user.username }
			<input type= "text" name="username" value="${user.username }"/>
			<button type= "submit">Change Username</button><br>
			</form></tr>
			<tr>Email: <td>${user.email }</td> <form action= "updateEmailForm.do">
			${user.username }
			<input type= "text" name="email" value="${user.email }"/>
			<button type= "submit">Change Email</button><br>
			</form></tr>
			<tr>Password: <td>${user.password }</td> <form action= "updatePasswordForm.do">
			${user.password }
			<input type= "hidden" name="pass" value="${user.password }"/>
			<button type= "submit">Change Password</button>
			</form></tr><br><br>

</body>
</html>