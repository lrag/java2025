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
					<c:url var="url" value="seleccionarPedido">
						<c:param name="id" value="${p.id}"/>
					</c:url>					
					<a href="${url}">${p.titulo}</a>
					-->
					${p.titulo}
				</td>			
				<td>${p.director}</td>			
				<td>${p.genero}</td>			
				<td>${p.fechaEstreno}</td>			
			</tr>
		</c:forEach>
	</table>	

</body>
</html>