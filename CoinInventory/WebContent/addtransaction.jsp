<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Transaction</title>
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
	<form method = "post" action = "addtransactiondataservlet">
		<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
		 <td><input type="radio" name="id" value="${currentitem.id}"></td>
		 <td>Coin Type: ${currentitem.type}</td>
		 <td>Storage Location: ${currentitem.storageLocation}</td>
		 <td>Date On Coin:${currentitem.dateOnCoin}</td>
		 
		 </tr>
		</c:forEach>
		</table>
		<h2>Select coin to add transaction detail to and add detail below</h2>

		<select name="tranlist">
			<option value="1">Buy</option>
			<option value="2">Sell</option>
			<option value="3">Trade</option>
		</select>
		
		Input Price: <input type="text" name ="price">
		Input Dealor:<input type="text" name ="dealor">
		Input Transaction Date:<input type="date" name = "trandate">
				

		<fieldset>
	<legend>Transaction Detail</legend>
	Price:
	<input type="text" name="price">
	Dealer:
	<input type="text" name="dealor">
	Transaction Date:
	<input type="text" name="trandate">
	<br/>
	<br/>

	<input type="submit">
	</fieldset>
	</form>
	
</div>
</body>
</html>