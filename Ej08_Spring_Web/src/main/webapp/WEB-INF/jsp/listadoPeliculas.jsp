<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 align="center">
		Listado de películas (JSTL)
	</h2>

	<table border="1" align="center">
		<tr>
			<th>Título</th>
			<th>Director</th>
			<th>Género</th>
			<th>Año</th>
		</tr>
		<c:forEach items="${listaPeliculas}" var="p">
			<tr>
				<td>${p.titulo}</td>
				<td>${p.director}</td>
				<td>${p.genero}</td>
				<td>${p.fechaEstreno}</td>
			</tr>	
		</c:forEach>
	</table>

</body>
</html>
















