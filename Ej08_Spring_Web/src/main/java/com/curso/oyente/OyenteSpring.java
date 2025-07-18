package com.curso.oyente;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;

/*
Los oyentes están pendientes de eventos que suceden en el contenedor de servlets
Se registran en el web.xml o con la anotación @WebListener
Son clases 100% manejadas
El contenedor crea una única instancia y la reutiliza (son singletons)
La clase tiene que tener acceso público
Y constructor por defecto
*/
@WebListener
public class OyenteSpring implements ServletContextListener, ServletContextAttributeListener {
	
    public OyenteSpring() {
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("CONTEXTO INICIALIZADO");
    	
    	//ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
    	//sce.getServletContext().setAttribute("appCtx", appCtx);
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("SE VA A DESTRUIR EL CONTEXTO");
    }

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("ATRIBUTO AÑADIDO AL SERVLET_CONTEXT: "+event.getName()+"-"+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
	}
	
}
