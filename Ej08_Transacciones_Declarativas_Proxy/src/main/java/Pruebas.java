import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculas;

public class Pruebas {

	public static void main(String[] args) {
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);

		GestorPeliculas gp = (GestorPeliculas) appCtx.getBean("gestorPeliculas");
		
		System.out.println("==================================================");
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas.add(new Pelicula(1111,"T1","D1","G1",111));
		peliculas.add(new Pelicula(2222,"T2","D2","G2",222));
		peliculas.add(new Pelicula(3333,"T3","D3","G3",333));
		peliculas.add(new Pelicula(4444,"T4","D4","G4",444));
		peliculas.add(new Pelicula(5555,null,"D5","G5",555));
		
		try {
			//Borrar todas las películas
			gp.borrarPeliculas();
			//Insertar
			gp.insertar(peliculas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		System.out.println("==================================================");
		List<Pelicula> peliculas2 = gp.listarTodas();
		for(Pelicula p: peliculas2){
			System.out.println(p.getTitulo());
		}		
		
	}
	
}
