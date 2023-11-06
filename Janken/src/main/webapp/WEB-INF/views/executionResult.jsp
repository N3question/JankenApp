<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rock-paper-scissors Site</title>
	<link href="https://fonts.googleapis.com/css2?family=Rajdhani:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<h1 style="font-family: 'Rajdhani', sans-serif;">Result</h1>
	<hr>
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
	        <h2 style="font-family: 'Rajdhani', sans-serif;"><%=request.getAttribute("result")%></h2>
			<p style="font-family: 'Rajdhani', sans-serif;">Your selection : <br><%=request.getAttribute("selection")%></p>
			<p style="font-family: 'Rajdhani', sans-serif;">Computer selection : <br><%=request.getAttribute("pc1Selection")%></p>
	    <% } else if (playerCount.equals("3")) { %>
	    	<h2 style="font-family: 'Rajdhani', sans-serif;"><%=request.getAttribute("result")%></h2>
	        <p style="font-family: 'Rajdhani', sans-serif;">Your selection : <br><%=request.getAttribute("selection")%></p>
			<p style="font-family: 'Rajdhani', sans-serif;">Computer1 selection : <br><%=request.getAttribute("pc1Selection")%></p>
			<p style="font-family: 'Rajdhani', sans-serif;">Computer2 selection : <br><%=request.getAttribute("pc2Selection")%></p>
	    <% } %>
	<% } %>
	<a href="./janken" style="font-family: 'Rajdhani', sans-serif;">Back to Top</a> <!-- /から始まるのは絶対パス。./は現在のカレントディレクトリ -->
</body>
</html>