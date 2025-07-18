<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">
		<font color="lightGreen">
			Scopes de Spring en una aplicación web
		</font>
	</h1>
	
	<p align="center">
		<a href="SVPruebasScopes">Actualizar</a>
	</p>

	<table align="center" border="1">
		<tr>
			<td>Prototype 1</td>
			<td>${o2}</td>
		</tr>
		<tr>
			<td>Prototype 2</td>
			<td>${o3}</td>
		</tr>
		<tr>
			<td>Request 1</td>
			<td>${o4}</td>
		</tr>
		<tr>
			<td>Request 2</td>
			<td>${o5}</td>
		</tr>
		<tr>
			<td>Sesión</td>
			<td>${o6}</td>
		</tr>
		<tr>
			<td>Singletón</td>
			<td>${o1}</td>
		</tr>
	</table>


</body>
</html>