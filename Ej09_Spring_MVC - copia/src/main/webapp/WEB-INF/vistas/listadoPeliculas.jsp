<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">
		<font color="lightGreen">
			Listado de películas
		</font>
	</h1>

	<p align="center">
		<a href="formularioPeliculas">Nueva</a>
	</p>
	
	<div align="center">
		<h2>${mensaje}</h2>	
	</div>

	<table align="center" border="1">
		<tr>
			<th>Título</th>
			<th>Director</th>
			<th>Genero</th>
			<th>Fecha</th>
		</tr>	
		<c:forEach var="p" items="${peliculas}">
			<tr>
				<td>
					<!-- 
					<a href="seleccionarPelicula?idPelicula=${p.id}">${p.titulo}</a>
					-->
					<a href="seleccionarPelicula/${p.id}">${p.titulo}</a>
				</td>			
				<td>${p.director}</td>			
				<td>${p.genero}</td>			
				<td>${p.year}</td>			
			</tr>
		</c:forEach>
		<c:if test="${peliculas.size()==0}">
			<tr>
				<td>No hay películas en la base de datos.</td>
			</tr>
		</c:if>
	</table>	

</body>
</html>