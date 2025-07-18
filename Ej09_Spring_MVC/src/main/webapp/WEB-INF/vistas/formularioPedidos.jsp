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
<body>

	<h1 align="center">
		<font color="lightGreen">
			Formulario de pedidos
		</font>
	</h1>
	
	<div align="center">
		<h2>${mensaje}</h2>
	</div>
	
	<form:form id="formulario" method="post" modelAttribute="pedido">
	
		<div align="center">
			<input type="submit" value="Insertar"  onclick="formulario.action='insertarPedido'"/>
			<input type="submit" value="Modificar" onclick="formulario.action='modificarPedido'"/>
			<input type="submit" value="Borrar"    onclick="formulario.action='borrarPedido'"/>
			<input type="submit" value="Aceptar"   onclick="formulario.action='aceptarPedido'"/>
			<input type="button" value="Vaciar"    onclick="//vaciarFormulario()"/>
			<input type="button" value="Cancelar"  onclick="document.location='verListadoPedidos'"/>
		</div>
		
		<form:hidden path="id"/>
	
		<table align="center">
			<tr>
				<td>Código</td>
				<td>
					<form:input path="codigo"/>
					<form:errors path="codigo"/>
				</td>
			</tr>
			<tr>
				<td>Fecha</td>
				<td>
					<form:input path="fecha"/>
					<form:errors path="fecha"/>
				</td>
			</tr>
			<tr>
				<td>Cliente</td>
				<td>
					<form:select path="cliente.id"> 
						<form:option value="">Seleccione...</form:option>
					    <form:options items="${listaClientes}" itemLabel="nombre" itemValue="id"/>
					</form:select> 
					<form:errors path="cliente.id"/>
				</td>
			</tr>
			<tr>
				<td>Estado</td>
				<td>
					<form:input path="estado"/>
					<form:errors path="estado"/>
				</td>
			</tr>
		</table>
	
	</form:form>

	<hr/>
	
	<form:form id="formularioDetalles" modelAttribute="detalle">
	
		<div align="center">
			<input type="submit" value="Insertar"  onclick="formularioDetalles.action='insertarDetalle'"/>
			<input type="submit" value="Modificar" onclick="formularioDetalles.action='modificarDetalle'"/>
			<input type="submit" value="Borrar"    onclick="formularioDetalles.action='borrarDetalle'"/>
			<input type="button" value="Vaciar"    onclick="//vaciarFormulario()"/>
		</div>
		
		<form:hidden path="id"/> 
		<form:hidden path="pedido.id"/> 
	
		<table align="center">
			<tr>
				<td>Producto</td>
				<td>
					<form:select path="producto.id"> 
						<form:option value="">Seleccione...</form:option>
					    <form:options items="${listaProductos}" itemLabel="nombre" itemValue="id"/>
					</form:select> 
					<form:errors path="producto.id"/>
				</td>
			</tr>
			<tr>
				<td>Cantidad</td>
				<td>
					<form:input path="cantidad"/>
					<form:errors path="cantidad"/>
				</td>
			</tr>
			<tr>
				<td>Precio</td>
				<td>
					<form:input path="precio"/>
					<form:errors path="precio"/>
				</td>
			</tr>
		</table>
		
		<table align="center" border="1">
			<tr>
				<th>Producto</th>
				<th>Cantidad</th>
				<th>Precio</th>
				<th>Total</th>
			</tr>			
			<c:forEach var="dp" items="${pedido.detalles}">
				<tr>
					<td>
						<c:url var="url" value="seleccionarDetalle">
							<c:param name="id" value="${dp.id}"/>
						</c:url>					
						<a href="${url}">${dp.producto.nombre}</a>
					</td>			
					<td>${dp.cantidad}</td>			
					<td>${dp.precio}</td>			
					<td>${dp.precio*dp.cantidad}</td>			
				</tr>
			</c:forEach>
		</table>	
	
	</form:form>	


</body>
</html>