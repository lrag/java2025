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
	window.location.href = 'listadoPeliculas'
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
					<input type="text" name="titulo" value=""/>
				</td>
			</tr>	
			<tr>
				<td>Director</td>
				<td>
					<input type="text" name="director" value=""/>
				</td>
			</tr>	
			<tr>
				<td>Género</td>
				<td>
					<input type="text" name="genero" value=""/>
				</td>
			</tr>	
			<tr>
				<td>Fecha</td>
				<td>
					<input type="text" name="fechaEstreno" value=""/>
				</td>
			</tr>	
		</table>
	
	</form>

</body>
</html>