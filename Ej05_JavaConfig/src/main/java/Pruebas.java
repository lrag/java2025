import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;

public class Pruebas {

	public static void main(String[] args) {

		//Contenedor de spring / application context
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//Solicitando una bean por nombre: devuelve Object
		ServicioPeliculas sp = (ServicioPeliculas) appCtx.getBean("servicioPeliculas");
		Pelicula p = new Pelicula(null, "Blade Runner", null, "CI-FI");
		sp.insertar(p);
		
	}
	
}
