<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, com.curso.modelo.entidad.Pelicula"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2 align="center">
		Listado de películas
	</h2>
	
	<%
	//for(int a=0; a<10; a++){
		//'out' es un avariable implícita que referencia al PrintWriter que tiene el objeto HttpServletResponse 
		//out.println("<div align='center'>"+a+"</div>");		
	//}
	%>	
	<%
	for(int a=0; a<10; a++){
		%>
		<!-- <div align='center'><%=a%></div> -->		
		<%
	}
	%>	

	<table border="1" align="center">
		<tr>
			<th>Título</th>
			<th>Director</th>
			<th>Género</th>
			<th>Año</th>
		</tr>
		<!-- Scriptlet -->
		<%
		List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("listaPeliculas");
		for(Pelicula p: peliculas){
		%>
			<tr>
				<td><%out.println(p.getTitulo());%></td>
				<td><%=p.getDirector()%></td>
				<td><%=p.getGenero()%></td>
				<td><%=p.getFechaEstreno()%></td>
			</tr>
		<%
		} 
		%>
	</table>

</body>
</html>