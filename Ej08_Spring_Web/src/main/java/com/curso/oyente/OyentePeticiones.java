package com.curso.oyente;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class OyentePeticiones implements ServletRequestListener, ServletRequestAttributeListener {

    public OyentePeticiones() {
    }

    public void requestInitialized(ServletRequestEvent sre)  {
    	HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
    	System.out.println("HA LLEGADO UNA NUEVA PETICION: "+request+"-"+request.getMethod()+" "+request.getRequestURI());
    }
    
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("HA FINALIZADO EL PROCESO DE UNA PETICIÓN: "+sre.getServletRequest());
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	System.out.println("SE HA AÑADIDO UN ATRIBUTO A UNA PETICION: "+srae.getName()+"-"+srae.getValue());
    }
    
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    }
    
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    }
	
}
