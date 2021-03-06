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
		<li><a href= "addcoin.jsp">Add Coin</a></li>
		<li><a href="editcoinservlet">Edit Coin</a></li>
		<li><a href="deletecoinservlet">Delete Coin</a></li>
		<li><a href="addtransactionservlet">Add Coin Transaction</a></li>
		<li><a href="ViewAllTransactionsServlet">View Transactions</a></li>
		<li><a href="ViewAllCoinServlet">View Coins</a></li>
	</ul>
</nav>
	
<div class="contents">
<form action="addcoinservlet" method="post">
	<fieldset>
	<legend>Coin Detail</legend>
	Coin Type:
	<input type="text" name="type">
	Storage Location:
	<input type="text" name="location">
	Condition:
	<input type="text" name="condition">
	Date On Coin:
	<input type="date" name="date">
	<br/>
	<br/>
	<input type="submit">
	</fieldset>
</form>
</div>
</body>
</html>