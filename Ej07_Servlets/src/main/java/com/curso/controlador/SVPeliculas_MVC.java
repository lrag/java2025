package com.curso.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;

@WebServlet("/controladores/peliculas")
public class SVPeliculas_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Este es un recurso que compartirán todos los hilos que lleguen a este servlet
	//Hay que asegurarse de que sea thread-safe
	private ServicioPeliculas servicioPeliculas = new ServicioPeliculas();
       
    public SVPeliculas_MVC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Petición recibida en SVPeliculas_MVC");
		
		List<Pelicula> peliculas = servicioPeliculas.listarPeliculas();
		
		request.setAttribute("listaPeliculas", peliculas);
		
		request.getRequestDispatcher("/jsp/listadoPeliculas.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}



























