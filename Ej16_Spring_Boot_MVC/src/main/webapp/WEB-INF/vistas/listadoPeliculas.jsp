<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
</head>
<body>

	<div class="text-center page-header">
	    <h2 class="mt-4 mb-4">Base de datos de películas de Internet 3000</h2>
	</div>  

	<div class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <ul class="navbar-nav">
	        <li class="nav-item active">
	            <a class="nav-link" href="#">Películas</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Actores</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Directores</a>
	        </li>
	        <li class="nav-item">
	            <a class="nav-link" href="#">Salir</a>
	        </li>
	    </ul>
	</div>

	<div class="text-center mt-4 mb-4">
		Listado de películas
	</div>

	<div class="text-center mt-4 mb-4">
		<form method="get" action="formularioPeliculas">
			<input type="submit" class="btn btn-primary" value="Nueva"/> 
		</form>
	</div>	
	
	<div align="center">
		<h2>${mensaje}</h2>	
	</div>

	<div class="row">
	    <div class="col-sm-12 offset-sm-0 col-md-8 offset-md-2">
	        
			<table class="table table-hover table-striped">    
				<thead>
					<tr>
						<th>Título</th>
						<th>Director</th>
						<th>Genero</th>
						<th>Fecha</th>
					</tr>	
				</thead>
				<tbody>
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
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>