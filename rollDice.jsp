<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Roll the dice</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="buttonArea">
		<form method="POST" action="setSettings">
			<table id="settingsForm">
				<tr>
					<td><label for="diceAmount">Amount of dice:</label></td>
					<td><input type="number" min="1" id="diceAmount" name="diceAmount" value="${sessionScope.numberOfDice}" /></td>
				</tr>
				<tr>
					<td><label for="eyesAmount">Amount of eyes per dice:</label></td>
					<td><input type="number" min="1" id="eyesAmount" name="eyesAmount" value="${sessionScope.numberOfEyes}" /></td>
				</tr>
				<tr><td />
					<td><input type="submit" value="set values" /></td>
				</tr>
			</table>
		</form>
		<div id="rollButtonArea">
			<form method="POST" action="rollDice">
				<input type="submit" name="rollButton" value="ROLL THE DICE!" />
			</form>
		</div>
	</div>
	<div id="resultArea">
		<c:forEach var="dice" items="${cup.getDices()}">
			<div class="dice">
				<span class="diceValue">
					${dice.getResult() eq 0 ? '?' : dice.getResult()}
				</span>
			</div>
		</c:forEach>
		<c:if test="${cup.getTotal() ne 0}">
			<span id="totalValue">The sum total of this roll is ${cup.getTotal()}.</span>
		</c:if>
	</div>
</body>
</html>