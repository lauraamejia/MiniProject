<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coin Inventory Program</title>
<style>
@import url('https://fonts.googleapis.com/css?family=Jura&display=swap');
@import url('https://fonts.googleapis.com/css?family=Sniglet&display=swap');

nav ul {
	display: flex;
	justify-content: space-between;
}

ul {

list-style: none;
}

nav ul li {
font-family: 'Jura', sans-serif;
font-size: 25px;
transition: border 1s;

}

nav ul li:hover {
border: 1px solid black;
}

h1 {
font-family: 'Sniglet', cursive;
margin-left: 40%;
font-size: 35px;
}

header {
position: absolute;
z-index: -1;
top: 0;
left: 0;

}

body {
background-color: #BDB76B;

}

.contents {
margin-top: 400px;
}

</style>

</head>
<body>

<header>
<img alt="stacks of coins" src="coinbanner.jpg" width=100%/>
	
</header>
<nav>
	<ul>
		<li>Add Coin</li>
		<li>Edit Coin</li>
		<li>Delete Coin</li>
		<li>Add Coin Transaction</li>
		<li>View Transactions</li>
	</ul>
</nav>
	
<div class="contents">
	<form method = "post" action = "">
		<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
		 <td><input type="radio" name="id" value="${currentitem.locid}"></td>
		 <td>${currentitem.type}</td>
		 <td>${currentitem.storagelocation}</td>
		 <td>${currentitem.condition}</td>
		 <td>${currentitem.dateOnCoin}</td>
		 </tr>
		</c:forEach>
		</table>
		<h2>select location to delete</h2>
		
	<input type="submit">
	</form>
	
</div>
</body>
</html>