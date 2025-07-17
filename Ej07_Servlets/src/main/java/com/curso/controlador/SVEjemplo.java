package com.curso.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Un servlet es una clase 100% manejad
//Las instancias las crea el ServletContainer
//Debe ser clases
//	-con acceso público
//	-con constructor por defecto
//Incluye callbacks para el ciclo de vida:
//  init
//	destroy
//
//Son singletons
//Una única instancia procesará todas las peticiones
//-->han de ser thread safe

/*
GET    : Para obtener recursos alojados en el servidor
POST   : Añadir recursos al servidor (y otra cosa)
PUT    : Sustituir un recurso por otro (y otra cosita)
DELETE : Eliminar recursos 
PATCH  : Modificar recursos
-------
HEAD
OPTIONS


                     |
http://localhost:8080/controladores/SVEjemplo
                     | 
Esta parte se utiliza  Esta parte se utiliza
para abrir el socket   para crear la petición http

GET /contralores/SVEjemplo

*/

//Al registrar un servlet le asignamos una 'urlPattern'
@WebServlet("/controladores/SVEjemplo")
public class SVEjemplo implements Servlet {
	
	public SVEjemplo() {
		super();
		System.out.println("Instanciando SVEjemplo");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Método init de SVEjemplo");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		System.out.println("Petición recibida en SVEjemplo");
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURI());
		System.out.println("Parámetro dato: "+request.getParameter("dato"));
		
		PrintWriter out = response.getWriter();
		//Html estático generado dinámicamente 
		response.setHeader("Content-type", "text/html");
		out.println("<html>");
		out.println("<body>");
		out.println("<marquee><h1><font color='lightGreen'>Pedazo de aplicación web</font></h1></marquee>");
		out.println("</body>");
		out.println("</html>");
		
	}

	@Override
	public String getServletInfo() {

		return null;
	}

	@Override
	public void destroy() {
		System.out.println("Método destroy dde SVEjemplo");
	}

}
