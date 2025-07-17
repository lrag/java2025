package com.curso.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;

public class SVPeliculas_sin_jsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Este es un recurso que compartirán todos los hilos que lleguen a este servlet
	//Hay que asegurarse de que sea thread-safe
	private ServicioPeliculas servicioPeliculas = new ServicioPeliculas();
       
    public SVPeliculas_sin_jsp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setHeader("Content-type", "text/html");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 align='center'><font color='lightGreen'>Listado de películas</font></h1>");

		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<th>Título</th>");
		out.println("<th>Director</th>");
		out.println("<th>Género</th>");
		out.println("<th>Año</th>");
		out.println("</tr>");
		
		List<Pelicula> peliculas = servicioPeliculas.listarPeliculas();
		for(Pelicula p: peliculas ) {
			out.println("<tr>");
			out.println("<td>"+p.getTitulo()+"</td>");
			out.println("<td>"+p.getDirector()+"</td>");
			out.println("<td>"+p.getGenero()+"</td>");
			out.println("<td>"+p.getFechaEstreno()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}



























