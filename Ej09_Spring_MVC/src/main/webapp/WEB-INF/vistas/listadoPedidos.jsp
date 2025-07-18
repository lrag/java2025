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
			Listado de pedidos
		</font>
	</h1>

	<p align="center">
		<a href="verFormularioPedidos">Nuevo</a>
	</p>
	
	<div align="center">
		<h2>${mensaje}</h2>	
	</div>

	<table align="center" border="1">
		<tr>
			<th>Codigo</th>
			<th>Cliente</th>
			<th>Fecha</th>
			<th>Estado</th>
		</tr>	
		<c:forEach var="p" items="${listaPedidos}">
			<tr>
				<td>
					<c:url var="url" value="seleccionarPedido">
						<c:param name="id" value="${p.id}"/>
					</c:url>					
					<a href="${url}">${p.codigo}</a>
				</td>			
				<td>${p.cliente.nombre}</td>			
				<td>${p.fecha}</td>			
				<td>${p.estado}</td>			
			</tr>
		</c:forEach>
	</table>	

</body>
</html>