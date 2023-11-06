<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rock-paper-scissors Site</title>
	<link rel="stylesheet" href="./css/style.css">
	<link href="https://fonts.googleapis.com/css2?family=Rajdhani:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<div class="outbox">
		<div class="box">
			<h1 >Result : </h1>
			<!-- checkbox version -->
			<%-- <% String checkboxSelection = request.getParameter("multiPlayCheckbox");
			   if (checkboxSelection != null) { %>
				<p>テスト中...</p>
			<% }else{ %>
				<h2><%=request.getAttribute("result")%></h2>
				<p>Your selection : <%=request.getAttribute("selection")%></p>
				<p>Computer selection : <%=request.getAttribute("pcSelection")%></p>
			<% } %> --%>
			<% String playerCount = request.getParameter("playerCount");
			   if (playerCount != null) { %>
			    <% if (playerCount.equals("2")) { %>
			        <h2><%=request.getAttribute("result")%></h2>
			        <div class="border2">
						<p>Your selection : <br><%=request.getAttribute("selection")%></p>
						<p>Computer selection : <br><%=request.getAttribute("pc1Selection")%></p>
					</div>
			    <% } else if (playerCount.equals("3")) { %>
			    	<h2><%=request.getAttribute("result")%></h2>
			    	<div class="border2">
				        <p>Your selection : <br><%=request.getAttribute("selection")%></p>
						<p>Computer1 selection : <br><%=request.getAttribute("pc1Selection")%></p>
						<p>Computer2 selection : <br><%=request.getAttribute("pc2Selection")%></p>
					</div>
			    <% } %>
			<% } %>
			<div class="backbox">
				<a href="./janken" class="back">Back to Top</a> <!-- /から始まるのは絶対パス。./は現在のカレントディレクトリ -->
			</div>
		</div>
	</div>
</body>
</html>