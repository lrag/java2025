import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Persona;
import com.curso.modelo.negocio.GestorPersonas;
import com.curso.modelo.persistencia.PersonaRepositorio;

public class PruebasSpring {

	public static void main(String[] args){
				
		AnnotationConfigApplicationContext appCtx = 
			new AnnotationConfigApplicationContext(Configuracion.class);
		
		PersonaRepositorio personaRepositorio = (PersonaRepositorio) appCtx.getBean("personaRepositorio");
		
		personaRepositorio.save(new Persona(null,"Ringo Starr","C/Tal","555123"));
		
		Persona p = new Persona(195, "Groucho Marx", "C/Tal", "555123");
		personaRepositorio.save(p);

		System.out.println("========================================");
		List<Persona> personas = personaRepositorio.findAll();
		for(Persona pAux: personas){
			System.out.println(pAux);
		}
		
		System.out.println("========================================");
		//Persona p2 = personaRepositorio.findOne(1);
		//System.out.println(p2);
		//p2.setNombre("GROUCHO MARX");
		
		//GestorPersonas gp = appCtx.getBean(GestorPersonas.class);
		//gp.modificarNombre(1, "--GROUCHO MARX--");
		
	}
	
	
	
}







