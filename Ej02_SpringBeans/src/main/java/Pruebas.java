import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;

public class Pruebas {

	public static void main(String[] args) {

		/*
		//SIN ESPRÍN:
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:C:/H2/bbdd_peliculas_2025");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		PeliculaDao peliculaDao = new PeliculaDao();
		peliculaDao.setDataSource(dataSource);
		
		ServicioPeliculas servicioPeliculas = new ServicioPeliculas();
		servicioPeliculas.setPeliculaDao(peliculaDao);		
		
		Pelicula p = new Pelicula(null, "Blade Runner", null, "CI-FI");
		servicioPeliculas.insertar(p);
		*/
		
		//Contenedor de spring / application context
		
		//ApplicationContext appCtx = new FileSystemXmlApplicationContext("C:/no se que/no se cuantos/Beans.xml");
		//ApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans.xml");
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans_Autowiring.xml");
		
		//Solicitando una bean por nombre: devuelve Object
		ServicioPeliculas sp = (ServicioPeliculas) appCtx.getBean("servicioPeliculas");
		Pelicula p = new Pelicula(null, "Blade Runner", null, "CI-FI");
		sp.insertar(p);
		
	}
	
}
