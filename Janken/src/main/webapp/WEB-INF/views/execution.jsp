<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rock-paper-scissors Site</title>
	<link href="https://fonts.googleapis.com/css2?family=Rajdhani:wght@500&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<h1 style="font-family: 'Rajdhani', sans-serif;">Welcome to the rock-paper-scissors site!</h1>
	<hr>
	<form action="janken" method="post" id="myForm"> <!-- actionはデータを送信したいURLを選択。アノテーションで指定したURLにする -->
		<h5 style="font-family: 'Rajdhani', sans-serif;">What are your choices?</h5>
		<small id="error-message" style="color: red; font-family: 'Rajdhani', sans-serif;"></small>
		<div>
			<label for="rock" style="font-family: 'Rajdhani', sans-serif;">Rock</label>
	    	<input type="radio" id="rock" name="selection" value="Rock" style="font-family: 'Rajdhani', sans-serif;">
		</div>
	    <div>
			<label for="paper" style="font-family: 'Rajdhani', sans-serif;">Paper</label>
	    	<input type="radio" id="paper" name="selection" value="Paper" style="font-family: 'Rajdhani', sans-serif;">
		</div>
	    <div>
			<label for="scissors" style="font-family: 'Rajdhani', sans-serif;">Scissors</label>
	    	<input type="radio" id="scissors" name="selection" value="Scissors" style="font-family: 'Rajdhani', sans-serif;">
		</div>
	    <br>
	    <!-- checkbox version -->
	    <!-- <div>
			<input type="checkbox" id="multiPlayCheckbox" name="multiPlayCheckbox" value="test">
        	<label for="multiPlayCheckbox">
        		Multi Play (3player)<br>
	        	<small>
	        	If you want to play multiplayer,<br>
	        	please select this checkbox.
	        	</small>
        	</label>
		</div>
		<br> -->
		<h5 style="font-family: 'Rajdhani', sans-serif;">Required Selection</h5>
		<div>
			<label for="playerCount" style="font-family: 'Rajdhani', sans-serif;">
				<small>
				Please specify the number of players :
				</small> 
			</label>
        	<select name="playerCount" id="playerCount">
	            <option value="2">2 player ( user + computer 1 )</option>
	            <option value="3">3 player ( user + computer 1 + computer 2 )</option>
	        </select>
		</div>
	    <input type="submit" id="submit" value="Submit">
	</form>
	
	<script src="./js/script.js"></script>
</body>
</html>