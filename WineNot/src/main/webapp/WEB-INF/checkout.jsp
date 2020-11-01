<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Confirm Order and Checkout</title>
</head>
<body>
	Items in cart
	<ul>
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
	</ul>
	<p>
	<table>
	<tr>
	<th>Shipping Details</th>
	<th>Billing Address</th>
	</tr>
	<tr>
	<td>${customerAddress.street} ${customerAddress.street2}</td>
	<td>${paymentInfo.address.street} ${paymentInfo.address.street2}</td>
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
	Payment Info<br>
	${paymentInfo.cardNumber}<br>
	Expiration Date: ${paymentInfo.exprDate.month} ${paymentInfo.exprDate.year}
	<br>
	Total: ${custOrder.amount}
	</p>
</body>
</html>