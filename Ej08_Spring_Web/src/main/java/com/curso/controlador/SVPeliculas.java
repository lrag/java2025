package com.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;

@WebServlet("/controladores/peliculas")
public class SVPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Este es un recurso que compartirán todos los hilos que lleguen a este servlet
	//Hay que asegurarse de que sea thread-safe
	@Autowired
	private ServicioPeliculas servicioPeliculas;

	public SVPeliculas() {
        super();
        //Aqui es demasiado pronto para acceder al servletContext
        //servicioPeliculas = 
    }
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Método init de SVPeliculas");
		//Nuestro oyente deja el contenedor de spring en el servletContext con la clave 'appCtx'
		//ApplicationContext appCtx = (ApplicationContext) config.getServletContext().getAttribute("appCtx");
		
		//El ContextLoaderListener de spring lo deja con la clave'org.springframework.web.context.WebApplicationContext.ROOT'
		//ApplicationContext appCtx = (ApplicationContext) config.getServletContext().getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		
		ApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		servicioPeliculas = (ServicioPeliculas) appCtx.getBean("servicioPeliculas");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Petición recibida en SVPeliculas_MVC");
		List<Pelicula> peliculas = servicioPeliculas.listarPeliculas();
		request.setAttribute("listaPeliculas", peliculas);
		request.getRequestDispatcher("/WEB-INF/jsp/listadoPeliculas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}



























