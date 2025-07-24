import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.PASS;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;
import static org.hibernate.cfg.JdbcSettings.URL;
import static org.hibernate.cfg.JdbcSettings.USER;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.curso.modelo.entidad.Pelicula;

public class Pruebas_Session {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
                .addAnnotatedClass(Pelicula.class)
                .setProperty("jakarta.persistence.jdbc.url", "jdbc:h2:file:C:/H2/hibernate6")
                .setProperty("jakarta.persistence.jdbc.user", "sa")
                .setProperty("jakarta.persistence.jdbc.password", "")
                .setProperty(SHOW_SQL, true)
                .setProperty(FORMAT_SQL, false)
                .setProperty(HIGHLIGHT_SQL, true)
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .buildSessionFactory();
		Session s = null;
		
		//////////
		//INSERT//
		//////////
		System.out.println("==========================================");
		s = sf.openSession();
		//s.getTransaction().begin();
		s.beginTransaction();
		
		Pelicula p1 = new Pelicula(null, "Alien", "Susto", 100, LocalDate.now());
		//Integer id = (Integer) s.save(p1); //deprecated
		System.out.println(p1.getId());
		//Tambien tenemos el persist de JPA
		s.persist(p1); //void
		System.out.println(p1.getId());
		s.getTransaction().commit(); //.rollback()
		s.close();
		
		///////////////////////////////
		//UPDATE CON TODOS LOS CAMPOS//
		///////////////////////////////		
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		/*
		Pelicula p = new Pelicula();
		p.setId(1);
		p.setDirector("Ridley Scott");
		s.update(p); (deprecated) //Update (y merge) hacen modificaciones a toda la tabla asi que perderiamos el resto de columnas
		*/

		Pelicula p2 = new Pelicula(p1.getId(), "Alien---", "Susto", 100, LocalDate.now());
		s.merge(p2);
		
		s.getTransaction().commit(); //.rollback()
		s.close();

		/////////////////
		//SELECT POR ID//
		/////////////////
		System.out.println("==========================================");
		s = sf.openSession();

		//Caché de primer nivel, solo ejecuta el primer select,
		//guarda el objeto en la caché y lo reutiliza
		Pelicula p3a = s.get(Pelicula.class, p2.getId());
		Pelicula p3b = s.get(Pelicula.class, p2.getId());
		Pelicula p3c = s.find(Pelicula.class, p2.getId()); //JPA
		
		p3a.setTitulo("Don erre que erre");
		System.out.println(p3c.getTitulo());
		s.close();
		
		//////////////////////////////////////////////
		//UPDATE CUANDO NO TENEMOS TODOS LOS VALORES//
		//////////////////////////////////////////////
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		Integer id = p2.getId();
		Integer duracion = 222;

		Pelicula p4 = s.get(Pelicula.class, id);
		p4.setDuracion(duracion);
		//s.merge(p4);
		s.getTransaction().commit();
		s.close();
		
				
		//////////
		//DELETE//
		//////////
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		Pelicula p5 = new Pelicula();
		p5.setId(p4.getId());
		//s.delete(p5); (deprecated) //Esto borra la pelicula si el id es correcto. si el id no es correcto: excepci�n
		s.remove(p5);
		
		s.getTransaction().commit();
		s.close();
		

		/*
		//OTROS METODOS
		s.evict(object);
		s.flush(); //Ejecuta cualquier consulta que estuviera pendiente
		s.clear(); //Vac�a la cach� de primer nivel
		s.refresh(object);
		*/
		
		//
		//sf.openStatelessSession();
		StatelessSession ss = sf.openStatelessSession();
		ss.beginTransaction();

		//ss.insert(entityName, entity)
		//ss.update(entity);
		//ss.delete(entity);
		//ss.get(entityClass, id);
				
		ss.getTransaction().commit();
		
		sf.close();
		
		
	}
	
}
















