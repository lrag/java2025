
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Persona;

public class Pruebas2 {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans2.xml");
		
		
		System.out.println("===========================================");
		Persona p1a = (Persona) appCtx.getBean("persona3");
		Persona p1b = (Persona) appCtx.getBean("persona3");
		Persona p1c = (Persona) appCtx.getBean("persona3");
		
		System.out.println(p1a);
		System.out.println(p1b);
		System.out.println(p1c);
		
		Persona p2a = (Persona) appCtx.getBean("persona3Bis");
		Persona p2b = (Persona) appCtx.getBean("persona3Bis");
		Persona p2c = (Persona) appCtx.getBean("persona3Bis");
		System.out.println(p2a);
		System.out.println(p2b);
		System.out.println(p2c);		

		System.out.println("===========================================");
		Persona p3a = (Persona) appCtx.getBean("persona4");
		Persona p3b = (Persona) appCtx.getBean("persona4");
		Persona p3c = (Persona) appCtx.getBean("persona4");
		System.out.println(p3a);
		System.out.println(p3b);
		System.out.println(p3c);
		
	}
	
}

