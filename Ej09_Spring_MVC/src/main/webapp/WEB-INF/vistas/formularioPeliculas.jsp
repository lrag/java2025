<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

	<h1 align="center">
		<font color="lightGreen">
			Formulario de películas
		</font>
	</h1>
	
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
					<form:input path="titulo" id="titulo"/>
				</td>
			</tr>	
			<tr>
				<td>Director</td>
				<td>
					<form:input path="director" id="director"/>
				</td>
			</tr>	
			<tr>
				<td>Género</td>
				<td>
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

					<form:select path="genero">
						<option value="">Seleccione...</option>
						<form:options items="${generos}" itemValue="nombre" itemLabel="nombre" />
					</form:select>
					
				</td>
			</tr>	
			<tr>
				<td>Fecha</td>
				<td>
					<form:input path="year" id="year"/>
				</td>
			</tr>	
		</table>
	
	</form:form>

</body>
</html>
