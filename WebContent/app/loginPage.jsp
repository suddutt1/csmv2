<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Predictive Maintenance++</title>
	<link rel="stylesheet" href="themes/csm_theme.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.icons.min.css" />
	<link rel="stylesheet" href="themes/jquery.mobile.structure-1.4.5.min.css" />
	<script src="themes/jquery.min.js"></script>
	<script src="themes/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
	<div data-role="page"  data-theme="a">
	<div data-role="header">
         <h2 style="font-size: 1.1em;color:#ffffff">Global Mining Corp</h2>
    </div>
    <div data-role="content">
        <div id="banner" style="text-align: center;">
             <img src="themes/images/bulb.png" width="50px" height="75px" />
        </div>
        <form action="loadHome.wss" method="post" data-ajax="false">
        	<c:if test="${loginError != null }" >
        	<div data-role="fieldcontainer">
        		<p style="color: red;" ><b>${loginError}</b></p>
        	</div>
        	</c:if>
		    <div data-role="fieldcontainer">
			<label for="username">User Name:</label>
			<input type="text" name="username" id="username" required placeholder="Enter your name">
			</div>
			<div data-role="fieldcontainer">
			<label for="password">Password:</label>
			<input name="password" id="password" value="" autocomplete="off" required type="password">
			</div>
    		<input value="Submit" type="submit">
		</form>
    </div>   
</div>
</body>
</html>