import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Pruebas_EntityManager {

	public static void main(String[] args) throws InterruptedException {
		
		//El entity manager factory es threadsafe
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PU");
		
		//El entity manager tiene dentro una conexión asi que NO ES THREAD-SAFE
		EntityManager em = null;
		
		//////////
		//INSERT//
		//////////
		System.out.println("=========================================");
		Pelicula p1 = new Pelicula(null, "Conan", "Acción", 500, LocalDate.now());
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1); 
		System.out.println(p1);
		em.getTransaction().commit(); //.rollback();
		em.close();
		
		
		///////////////////////////////
		//UPDATE CON TODOS LOS CAMPOS//
		///////////////////////////////		
		System.out.println("=========================================");		
		/*Si usamos esta pelicula para el merge perderemos titulo, genero y fechaEstreno
		Integer idPelicula = p1.getId();
		int duracion = 131;
		Pelicula p2 = new Pelicula();
		p2.setId(idPelicula);
		p2.setDuracion(duracion);
		 */		
		
		//Debemos asegurarnos de que el objeto tenga todos los valores
		Pelicula p2 = new Pelicula(p1.getId(), "Die Hard", "Acción", 131, LocalDate.now());		
		
		em = emf.createEntityManager();
		em.getTransaction().begin();		
		//merge no es update
		//merge es sincronizar la base de datos con el objeto
		em.merge(p2);
		em.getTransaction().commit(); //.rollback();
		em.close();			
				
		
		/////////////////
		//SELECT POR ID//
		/////////////////
		System.out.println("=========================================");
		em = emf.createEntityManager();
		Pelicula p3 = em.find(Pelicula.class, p2.getId());
		System.out.println(p3);
		em.close();

		
		//////////////////////////////////////////////
		//UPDATE CUANDO NO TENEMOS TODOS LOS VALORES//
		//////////////////////////////////////////////
		System.out.println("=========================================");
		//Temenos estos datos:
		Integer idPelicula = p3.getId();
		int duracion = 121;
		
		em = emf.createEntityManager();
		em.getTransaction().begin();		

		Pelicula p4 = em.find(Pelicula.class, idPelicula);
		p4.setDuracion(duracion);
		
		//Gracias a la caché de primer nivel el merge no es necesario
		//(Pero no pasa nada si lo ponemos)
		//em.merge(p4);
		em.getTransaction().commit(); //.rollback();
		em.close();	
		
		
		/////////////////////////
		//CACHÉ DE PRIMER NIVEL//
		/////////////////////////
		System.out.println("=========================================");
		em = emf.createEntityManager(); //La caché de este em está vacía
		
		Pelicula p5a = em.find(Pelicula.class, p4.getId()); //Hace el select y guarda el objeto en la caché
		Pelicula p5b = em.find(Pelicula.class, p4.getId()); //Ya no hay select y nos entregan la instancia de pelicula que está en la caché
		Pelicula p5c = em.find(Pelicula.class, p4.getId()); //Ídem

		p5a.setTitulo("Airplane!");		
		System.out.println(p5c);	
		
		em.close();
		
		
		//////////
		//DELETE//
		//////////
		System.out.println("=========================================");
		idPelicula = p5a.getId();
		Pelicula p6 = new Pelicula();
		p6.setId(idPelicula); //Para borrar solo necesitamos el id
		
		em = emf.createEntityManager(); //La caché de este em está vacía
		em.getTransaction().begin();
		
		//Tambien podemos hacerlo con un find antes del remove
		//Pelicula p6 = em.find(Pelicula.class, idPelicula);
		//(Habría que preguntar si existe) 
		
		p6 = em.merge(p6); //nótese la asignación
		System.out.println("llamada a remove");
		//em.remove(p6); //El delete solo se ejecuta en el momento del commit
		//Thread.sleep(5_000);
		em.getTransaction().commit(); //.rollback();
		em.close();	

		
		///////////
		//REFRESH//
		///////////
		System.out.println("=========================================");
		//Temenos estos datos:
		idPelicula = p6.getId();
		duracion = 136;
		
		em = emf.createEntityManager();
		em.getTransaction().begin();		

		Pelicula p7 = em.find(Pelicula.class, idPelicula);
		//Cambiamos la duración. Se marca el objeto en la caché como 'no sincronizado'
		p7.setDuracion(duracion);
		//em.merge(p7); //Esto no hace el update. El update se ejecuta durante el commit
		
		//Al hacer refresh se sincroniza el objeto con lo que sigue estando en la tabla
		//Asi que pierde la marca
		em.refresh(p7); //fuerza un select

		//Ahora no hay update, porque hemos hecho 'refresh'
		em.getTransaction().commit(); //.rollback();
		em.close();		

		
		/////////////////
		//OTROS MÉTODOS//
		/////////////////
		
		//
		//DETACH: Solicitamos al em que se 'olvide' de una entidad que tiene en la caché
		//
		//em.detach(e);
		System.out.println("=========================================");		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Pelicula p8 = em.find(Pelicula.class, p7.getId());
		p8 = em.find(Pelicula.class, p7.getId()); //No hay select porque ya está en la caché
		//Si quisieramos volver a meter el objeto en la caché haríamos un merge
		
		em.detach(p8); //El objeto se elimina de la caché
		
		p8 = em.find(Pelicula.class, p7.getId()); //Otra vez select y otra vez vuelve a estar enla caché (un objeto nuevo)
		
		em.getTransaction().commit();
		em.close();
		
		
		
		//
		//CLEAR: Vacía la caché de primer nivel. 
		//Si habian objetos no sincronizados (tanto para update como para delete) en la caché se pierden esos cambios
		//
		
		//
		//FLUSH: Sincroniza la base de datos con los cambios que tengan los objetos de la caché
		//Luego se podrá seguir haciendo rollback
		//Utilizado normalmente antes de un CLEAR
		//
			
		/////////////////////////////////////////
		//JPQL: Java Persistence Query Language//
		/////////////////////////////////////////

		System.out.println("=========================================");		
		em = emf.createEntityManager();
		
		//select p.* from peliculas as p
		//select p from Pelicula as p
		Query q = em.createQuery("select p from Pelicula p"); //El 'as' es opcional y no lo pone nadie
		List<Pelicula> peliculas = q.getResultList(); //Las películas de la lista están enla caché
		for(Pelicula pAux: peliculas) {
			System.out.println(pAux);
		}
		
		
		em.close();
		
		emf.close();
		
	}
	
}







