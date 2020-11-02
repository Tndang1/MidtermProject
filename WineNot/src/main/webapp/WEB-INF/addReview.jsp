<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "addWineReview.do">
	<input type = "hidden" name = "custId" value = "1">
	<input type = "hidden" name = "wineId" value = "${wineId}">
	Review: <input type ="text" name = "review">
	Rating: <input type = "number" name = "rating">
	Image URL Link:<input type = "text" name = "image">
	<button type ="submit">Submit your review!</button>
	</form>
</body>
</html>