<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
</head>

<script type="application/javascript">

//Dry stick Javascript

function volver(){
	let href = window.location.href
	if(href.includes("/seleccionarPelicula")) {
		window.location.href = '../listadoPeliculas'
	} else {
		window.location.href = 'listadoPeliculas'
	}
}

function vaciar(){
	document.getElementById("formulario").reset()
}

function enviarFormulario(path){
	formulario.action = path
	formulario.submit()
}

window.onload = function(){
	document.getElementById("btnVolver").onclick = volver
	document.getElementById("btnVaciar").onclick = vaciar
	document.getElementById("btnInsertar").onclick = function() { enviarFormulario("insertarPelicula") }
	document.getElementById("btnModificar").onclick = function() { enviarFormulario("modificarPelicula") }
	document.getElementById("btnBorrar").onclick = function() { enviarFormulario("borrarPelicula") }
}

</script>

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
		Formulario de películas
	</div>
		
	<div align="center">
		<h2>${mensaje}</h2>
	</div>
	
	<!-- 
	<form method="POST" id="formulario">
		<div align="center">
			<input type="button" id="btnInsertar"  value="Insertar"  />
			<input type="button" id="btnModificar" value="Modificar" />
			<input type="button" id="btnBorrar"    value="Borrar"    />
			<input type="button" id="btnVaciar"    value="Vaciar"/>
			<input type="button" id="btnVolver"    value="Volver"/>
		</div>
		
		<p/>
		
		<table align="center">
			<tr>
				<td>Título</td>
				<td>
					<input type="text" name="pelicula.titulo" value=""/>
				</td>
			</tr>	
			<tr>
				<td>Director</td>
				<td>
					<input type="text" name="pelicula.director" value=""/>
				</td>
			</tr>	
			<tr>
				<td>Género</td>
				<td>
					<input type="text" name="pelicula.genero" value=""/>
				</td>
			</tr>	
			<tr>
				<td>Fecha</td>
				<td>
					<input type="text" name="pelicula.fechaEstreno" value=""/>
				</td>
			</tr>	
		</table>
	
	</form>
	-->


	<form:form id="formulario" method="POST" modelAttribute="pelicula">
	
		<div class="text-center mt-4 mb-4">
			<input type="submit" id="btnInsertar" class="btn btn-primary" value="Insertar"  /> 
			<input type="submit" id="btnModificar" class="btn btn-primary" value="Modificar" /> 
			<input type="submit" id="btnBorrar" class="btn btn-danger"  value="Borrar"    /> 
			<input type="button" id="btnVaciar" class="btn btn-warning" value="Vaciar"    /> 
			<input type="submit" id="btnVolver" class="btn btn-warning" value="Volver"  /> 
		</div>		
		
		<div class="row">
		    <div class="col-sm-12 offset-sm-0 col-md-8 offset-md-2">
		        
				<div class="row">
				
				    <div class="col-sm-12 col-md-2 mt-1">
				        <label for="nombre">Título</label>
				    </div>
				    <div class="col-sm-12 col-md-10 mt-1">
				        <form:input path="titulo" id="titulo" class="form-control"/>
				    </div>	
				    			
				    <div class="col-sm-12 col-md-2 mt-1">
				        <label for="nombre">Director</label>
				    </div>
				    <div class="col-sm-12 col-md-10 mt-1">
				        <form:input path="titulo" id="director" class="form-control"/>
				    </div>
				    				
				    <div class="col-sm-12 col-md-2 mt-1">
				        <label for="nombre">Género</label>
				    </div>
				    <div class="col-sm-12 col-md-10 mt-1">
						<!-- 
						<form:input path="genero" id="genero"/>
						-->
						
						<!-- 
						<select name="genero">
							<option value="">Seleccione...</option>
							<c:forEach items="${generos}" var="g">
								<option value="${g.id}">${g.nombre}</option>
							</c:forEach>
						</select>
						-->
	
						<form:select path="genero" class="form-control">
							<option value="">Seleccione...</option>
							<form:options items="${generos}" itemValue="nombre" itemLabel="nombre" />
						</form:select>				        
				    </div>				
				
				    <div class="col-sm-12 col-md-2 mt-1">
				        <label for="nombre">Fecha</label>
				    </div>
				    <div class="col-sm-12 col-md-10 mt-1">
				        <form:input path="year" id="director" class="form-control"/>
				    </div>				
				
				</div>
			</div>
		</div>
	
	</form:form>

</body>
</html>
